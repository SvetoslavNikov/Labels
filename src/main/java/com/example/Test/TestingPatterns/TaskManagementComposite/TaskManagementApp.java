package com.example.Test.TestingPatterns.TaskManagementComposite;

import java.util.ArrayList;
import java.util.List;

public class TaskManagementApp {
    public static void main(String[] args) {
        // Creating simple tasks
        Task simpleTask1 = new SimpleTask("Complete Coding");
        Task simpleTask2 = new SimpleTask("Write Documentation");

        // Creating a task list
        TaskList projectTasks = new TaskList("Project Tasks");
        projectTasks.addTask(simpleTask1);
        projectTasks.addTask(simpleTask2);

        // Nested task list
        TaskList phase1Tasks = new TaskList("Phase 1 Tasks");
        phase1Tasks.addTask(new SimpleTask("Design"));
        phase1Tasks.addTask(new SimpleTask("Implementation"));

        projectTasks.addTask(phase1Tasks);

        // Displaying tasks
        projectTasks.display();
    }
}

//component
interface Task{
    String getTitle();
    void setTitle();
    void display();
}

//leaf
class SimpleTask implements Task{
    private String title;

    public SimpleTask(String title){
        this.title = title;
    }
    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle() {
        this.title = title;
    }

    @Override
    public void display() {
        System.out.println("Simple task title: " + title);
    }
}

//compositek
class TaskList implements Task{
    private String title;

    private List<Task> tasks;
    public TaskList(String title){
        this.title = title;
        tasks = new ArrayList<>();
    }
    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle() {
        this.title = title;
    }

    public void addTask(Task task){
        this.tasks.add(task);
    }

    public void removeTask(Task task){
        if(tasks.contains(task)){
            this.tasks.remove(task);
        }
    }

    @Override
    public void display() {
        System.out.println("Task list title: "+title);
        for(Task task: tasks){
            task.display();
        }
    }
}
