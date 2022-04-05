package com.company;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class ReportBuilder {

    public void report(List<Task> tasks, HashMap<String, ArrayList<String>> logs, int cycle) throws InterruptedException {
        printLifeCycle(logs,cycle);
        report(tasks,cycle);
    }

    private void printLifeCycle(HashMap<String,ArrayList<String>> lifecycle, int cycle)throws InterruptedException{

        System.out.print("C \t\t");
        for (String processorId: lifecycle.keySet()) System.out.print(processorId+"\t\t");
        System.out.println();

        System.out.print("\t\t");
        for (int i = 0 ; i < lifecycle.size(); i++) System.out.print("ㅜ\t\t");
        System.out.println();


        for(int i = 0 ; i < cycle; i++){
            TimeUnit.MILLISECONDS.sleep(150);
            System.out.print((i+1)+"\t\t");
            for(String taskId : lifecycle.keySet()) System.out.print(lifecycle.get(taskId).get(i) + "\t\t");
            System.out.println();
        }


        System.out.println("\nC: cycle\tP: processor\tT: task\t\t︱: processor state idle\t★: Task Finished\n");
    }

    private void report(List<Task> tasks, int cycles){
        int wSum = 0, tatSum = 0;
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.println("TaskId\tCreationTime\tRequestedTime\tCompletionTime\tPriority\tTurnAroundTime\tWaitingTime");
        System.out.println("------------------------------------------------------------------------------------------------");
        
        for(Task task : tasks){
            System.out.println(
                    task.getId()+"\t\t" +
                    task.getCreationTime()+"\t\t\t\t"+
                    task.getRequestedTime()+"\t\t\t\t"+
                    task.getCompletionTime()+"\t\t\t\t"+
                    (task.getPriority()?"high":"low ")+"\t\t"+
                    task.getTurnAroundTime()+"\t\t\t\t"+
                    task.getWaitingTime());

            wSum += task.getWaitingTime();
            tatSum += task.getTurnAroundTime();
        }

        System.out.println("\nfinished in "+cycles+" cycles");
        System.out.println("average turn around time time = "+ (tatSum/ (tasks.size()*1.0)));
        System.out.println("average waiting time = "+ (wSum/(tasks.size()*1.0)));
    }
}
