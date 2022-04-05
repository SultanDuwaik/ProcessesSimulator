package com.company;

public interface Task {
    String getState();
    int getCreationTime();
    String getId();
    boolean getPriority();
    int getWaitingTime();
    int getTurnAroundTime();
    int getRequestedTime();
    int getBurstTime();
    int getCompletionTime();
    void setState(String state);
    void setCompletionTime(int completionTime);
    void process(int cycle);
}
