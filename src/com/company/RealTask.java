package com.company;

public class RealTask implements Task{

    private final int creationTime;
    private int burstTime;
    private final int requestedTime;
    private int completionTime;
    private final boolean priority;
    private String state;
    private final String id;

    public RealTask(String id, int creationTime, int burstTime, boolean priority){
        this.burstTime = burstTime;
        this.requestedTime = burstTime;
        this.state = burstTime < 1 ? "Finished": "Waiting";
        this.creationTime = creationTime;
        this.priority = priority;
        this.id = id;
    }

    public int getRequestedTime() {
        return requestedTime;
    }

    public int getBurstTime() { return burstTime; }

    public int getTurnAroundTime(){
        if(completionTime <= 0) return 0;
        return getCompletionTime() - getCreationTime();
    }

    public int getWaitingTime(){
        if(completionTime <= 0) return 0;
        int val = getTurnAroundTime() - getRequestedTime();
        return (val < 1)? 0 : val;
    }

    public int getCreationTime() { return creationTime; }

    public int getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(int completionTime) {
        this.completionTime = completionTime;
    }

    public boolean getPriority() {
        return priority;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getId() {
        return id;
    }

    @Override
    public void process(int cycle) {
        if(!state.equals("Finished"))
            burstTime--;
        if(burstTime == 0) {
            state = "Finished";
            setCompletionTime(cycle + 1);
        }
    }
}
