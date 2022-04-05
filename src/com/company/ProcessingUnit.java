package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeSet;

public class ProcessingUnit {

    private ArrayList<Processor> processors;
    private HashMap<String, ArrayList<String>> lifecycle;

    public  ProcessingUnit(){
        processors = new ArrayList<>();
        lifecycle = new LinkedHashMap<>();
    }

    public void addProcessor(Processor processor){
        processors.add(processor);
        lifecycle.put(processor.getId(),new ArrayList<>());
   }


    public int getNumOfProcessors(){
        return processors.size();
    }

    public HashMap<String, ArrayList<String>> getLifecycle(){
        return lifecycle;
    }

    public TreeSet<Task> addTasks(TreeSet<Task> tasksQueue) {

        for (Processor processor : processors) {
            if (tasksQueue.size() > 0) {
                if (processor.getState().equals("Idle")) {
                    processor.setTask(tasksQueue.pollFirst());
                } else if (!processor.getTask().getPriority() && tasksQueue.first().getPriority()||
                          ( processor.getTask().getPriority() == tasksQueue.first().getPriority()&&
                            tasksQueue.first().getBurstTime() < processor.getTask().getBurstTime())) {
                    tasksQueue.add(processor.removeTask());
                    processor.setTask(tasksQueue.pollFirst());
                }
            }
        }
        return tasksQueue;
    }

    public void executeTasks(int cycle){
        for(Processor processor:processors){
            if(!processor.getTask().getId().equals("null id")) {
                String taskId = processor.getTask().getId();
                if (processor.executeTask(cycle)) {
                    lifecycle.get(processor.getId()).add(taskId + "★");
                } else lifecycle.get(processor.getId()).add(taskId);
            }
            else lifecycle.get(processor.getId()).add("︱");
        }

    }

}
