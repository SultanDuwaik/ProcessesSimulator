package com.company;

public class NullTask implements Task {
    @Override
    public String getState() {
        return "null object";
    }

    @Override
    public int getCreationTime() {
        return -1;
    }

    @Override
    public String getId() {
        return "null id";
    }

    @Override
    public void setState(String state) {

    }

    @Override
    public boolean getPriority() {
        return false;
    }

    @Override
    public void process(int cycle) {

    }

    @Override
    public int getWaitingTime() {
        return -1;
    }

    @Override
    public int getTurnAroundTime() {
        return -1;
    }

    @Override
    public int getRequestedTime() {
        return -1;
    }

    @Override
    public int getBurstTime() {
        return -1;
    }

    @Override
    public int getCompletionTime() {
        return -1;
    }

    @Override
    public void setCompletionTime(int completionTime) {

    }

    @Override
    public String toString() {
        return "NullTask";
    }
}
