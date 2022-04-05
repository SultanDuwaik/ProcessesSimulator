package com.company;

import java.util.Comparator;

public class PriorityArrivalQueueComp implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Task p1 = (Task)o1;
        Task p2 = (Task)o2;

        if(p1.getPriority() && !p2.getPriority()) return -1;
        else if(p1.getPriority() == p2.getPriority() && p1.getBurstTime() < p2.getBurstTime()) return -1;
        else return 1;
    }
}
