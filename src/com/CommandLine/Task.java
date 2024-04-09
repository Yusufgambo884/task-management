package com.CommandLine;

import java.time.LocalDate;

public class Task {

    private String title;

    private String description;

    private LocalDate dueDate;

    private boolean completed;


    //constructor
    public Task(String title, String description, LocalDate dueDate) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.completed = false;
    }

    // gitter and sitter
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Task{" +
            "title='" + title + '\'' +
            ", description='" + description + '\'' +
            ", dueDate=" + dueDate +
            ", completed=" + completed +
            '}';
    }
}
