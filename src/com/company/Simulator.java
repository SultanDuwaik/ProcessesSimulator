package com.company;
import java.io.*;
import java.util.*;

public class Simulator {
    ProcessingUnit processingUnit;
    TreeSet<Task> tasksQueue;
    List<Task> tasks;
    ReportBuilder reportBuilder;
    int cycle;

    public Simulator()
    {
        processingUnit = new ProcessingUnit();
        tasksQueue = new TreeSet<>(new PriorityArrivalQueueComp());
        tasks = new ArrayList<>();
        reportBuilder = new ReportBuilder();
        cycle = 0;
    }

    public void simulate(String path) throws IOException, InterruptedException {
           if(path.endsWith(".csv")) {
               readFile(path);
               startSimulation();
           }
           else System.out.println("wrong file format");
    }


    private void readFile(String path) throws IOException {
        InputStream i = Simulator.class.getResourceAsStream(path);
        BufferedReader br = new BufferedReader(new InputStreamReader(i));
        addProcessors(br);
        br.readLine();
        addTasks(br);
    }


    private void startSimulation() throws InterruptedException {
        if(  processingUnit.getNumOfProcessors() > 0) {
            while (!finished()) {
                addArrivedTasksToQueue();
                addTasksToProcessor();
                executeTasks();
                cycle++;
            }
            reportBuilder.report(tasks, processingUnit.getLifecycle() , cycle);
        } else System.out.println("no processors Found!");
    }


    private boolean finished() {
        boolean isCompleted = true;
        for(Task task: tasks){
            if(!task.getState().equals("Finished")) {
                isCompleted = false;
                break;
            }
        }
        return isCompleted;
    }


    private void addProcessors(BufferedReader br) throws IOException {
        int numberOfProcessors = Integer.parseInt(br.readLine().replaceAll("[^0-9]", ""));
        for(int i = 0 ; i < numberOfProcessors; i++) {
            processingUnit.addProcessor(new Processor("p"+(i+1)));
        }
    }

    private void addTasks(BufferedReader br) throws IOException {
        String line;
        while((line = br.readLine()) != null){
            String[] values = line.split(",");
            tasks.add(new RealTask(values[0].trim(),
                    Integer.parseInt(values[1].trim()),
                    Integer.parseInt(values[2].trim()),
                    values[3].trim().equals("high")));
        }
    }

    private void addArrivedTasksToQueue(){
        for(Task task: tasks){
            if(task.getCreationTime() == cycle && task.getState().equals("Waiting"))
                tasksQueue.add(task);
        }
    }


    private void addTasksToProcessor(){
        tasksQueue = processingUnit.addTasks(tasksQueue);
    }

    private void executeTasks(){
        processingUnit.executeTasks(cycle);
    }
}
