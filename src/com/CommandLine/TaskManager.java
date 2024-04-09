package com.CommandLine;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    final private List<Task> tasks;

    // constructor
    public TaskManager() {tasks = new ArrayList<>();}

    // add a task
    public  void addTask(String title, String description, LocalDate dueDate){
        var task = new Task(title, description,dueDate);
        tasks.add(task);
    }

    // edit task
    public void editTask(int index, String title, String description, LocalDate dueDate){
        Task task = tasks.get(index);
        task.setTitle(title);
        task.setDescription(description);
        task.setDueDate(dueDate);
    }

    public List<Task> getTasks(){
        return tasks;
    }

    //view task
    public void viewTasks(){
        if (tasks.isEmpty()) {
            System.out.println("No Task Fund. ");
            return;
        }
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println("Task # " + (i + 1));
            System.out.println(tasks.get(i));
            System.out.println(); // empty line
        }
    }

    // delete tasks
    public void deleteTask(int index){
        tasks.remove(index);
    }

    //mark as read
    public void markTaskAsRead(int index){
        Task task = tasks.get(index);
        task.setCompleted(true);
    }
}
