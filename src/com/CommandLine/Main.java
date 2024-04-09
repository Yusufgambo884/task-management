package com.CommandLine;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        while (true){
            //display a manu
            System.out.println("Tasks management application");
            System.out.println("1. Add Task ");
            System.out.println("2. Edit Task ");
            System.out.println("3. View Task ");
            System.out.println("4. Delete A Task");
            System.out.println("5. Mark A Task As Completed");
            System.out.println("0. Exit");

            System.out.println("Enter your Choice");

            // get user input
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the new line

            switch (choice) {
                case 0:
                    System.out.println("Exiting..");
                    return;
                case 1:
                    //add Task
                    System.out.println("Enter The Task Title.");
                    String title = scanner.nextLine();

                    System.out.println("Enter the Task Description");
                    String description = scanner.nextLine();

                    LocalDate dueDate = null;
                    while (dueDate == null){
                        System.out.println("Enter The Task DueDate (YYY-MM-DD) ");
                        String dueDateString = scanner.nextLine();

                        try {
                            dueDate = LocalDate.parse(dueDateString);
                        } catch (DateTimeException e){
                            System.out.println("Invalid Date Format. Please Try Again.");
                        }
                    }
                    taskManager.addTask(title, description, dueDate);
                    System.out.println("Task Added Successfully.");
                    break;
                case 2:
                    // Edit Task
                    System.out.println("Enter The Task Number To Edit: ");
                    int editIndex = scanner.nextInt();
                    scanner.nextLine(); // consume the new line charter

                    if (editIndex <= 0 || editIndex > taskManager.getTasks().size()){
                        System.out.println(" Invalid Task Number Please Try Again. ");
                        break;
                    }
                    System.out.println(" Enter the new Task Title: ");
                    String newTitle = scanner.nextLine();

                    System.out.println("Enter The Task Description: ");
                    String newDescription = scanner.nextLine();
                    LocalDate newDueDate = null;
                    while (newDueDate == null){
                        System.out.println(" Enter The New Task Due Date (YYYY-MM-DD) ");
                        String newDueDateString = scanner.nextLine();

                        try {
                            newDueDate = LocalDate.parse(newDueDateString);
                        }catch (DateTimeException e){
                            System.out.println("Invalid date format please try again.");
                        }
                    }

                    taskManager.editTask(editIndex -1, newTitle, newDescription, newDueDate);
                    System.out.println("Task Added Successfully. ");
                    break;

                case 3:
                    // view all task
                    taskManager.viewTasks();
                    break;

                case 4:
                    // delete task
                    System.out.println("Enter the task number to delete.");
                    int deleteIndex = scanner.nextInt();
                    scanner.nextLine(); //consuming the new line charter

                    if (deleteIndex <= 0 || deleteIndex > taskManager.getTasks().size()) {
                        System.out.println("Invalid Task number please try again. ");
                        break;
                    }

                    taskManager.deleteTask(deleteIndex - 1);
                    System.out.println("Task deleted successfully");
                    break;

                case 5:
                    // mark task as completed
                    System.out.println("Enter the task number to mark as completed.");
                    int completeIndex = scanner.nextInt();
                    scanner.nextLine(); //consume the new line charter

                    if (completeIndex <= 0 || completeIndex > taskManager.getTasks().size()){
                        System.out.println("Task marked as completed successfully.");
                        break;
                    }
                    System.out.println();
            }
        }
    }
}
