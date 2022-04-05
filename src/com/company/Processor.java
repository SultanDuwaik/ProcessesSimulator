package com.company;

public class Processor{
    private String state;
    private Task task;
    private final String id;

    public Processor(String id){
        this.state = "Idle";
        this.id = id;
        task = new NullTask();
    }

    public String getState() { return state; }
    public String getId() { return id; }

    public Task getTask(){
        return task;
    }

    public Task removeTask(){
        Task temp = task;
        this.state = "Idle";
        task = new NullTask();
        return temp;
    }

    public void setTask(Task task){
        this.task = task;
        task.setState("Executing");
        state = "Busy";
    }

    public boolean executeTask(int cycle){
        task.process(cycle); 
        if(task.getState().equals("Finished")) {
            removeTask();
            return true;
        }
        return false;

    }
}
