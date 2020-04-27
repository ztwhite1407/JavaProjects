/*
 * File: main.java
 * Author: Zachary White ztwhite@uab.edu
 * Assignment:  P5 - EE333 Fall 2019
 * Vers: 1.0.0 10/29/2019 zw - initial coding
 *
 * Credits:  (if any for sections of code)
 */
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uab.ztwhite.p5;

import java.io.BufferedReader;
import java.util.*;
import java.io.*;
import java.lang.*;

/**
 *
 * @author Zachary White ztwhite@uab.edu
 */
public class main {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        
        System.out.println("Zachary White/ztwhite");
        Calendar calendar = new Calendar();

        // filling up the calendar from whatever was in the file
        DatabaseInput.readRecord(calendar);

        boolean contin = true;

        while (contin) {

            Scanner scan = new Scanner(System.in);
            System.out.println("Welcome to the P5 Calendar App. \n " + "Please read below for instructions:\n "
                    + "To add an activity to the calendar, please type 'add' \n"
                    + "To delete an activity to the calendar, please type 'delete' \n"
                    + "To display items in the calendar, please type 'display' \n"
                    + "To exit program, please type 'exit'");
            String Choice1 = scan.nextLine();

            if (Choice1.equals("add")) {

                System.out.println("Enter Activity Description");
                String ActivityName = scan.nextLine();

                System.out.println("Enter a Role for this Activity");
                String ActivityRole = scan.nextLine();

                System.out.println("Enter Sub Role. If Sub Role " + "\n" + "doesn't exists, just press enter");
                String ActivitySubRole = scan.nextLine();

                System.out.println("What Month?");
                String ActivityMonth = scan.nextLine();

                System.out.println("What Year?");
                int ActivityYear = scan.nextInt();

                Role r = new Role(ActivityRole, ActivitySubRole);

                Activity activity = new Activity(ActivityYear, ActivityMonth, ActivityName, r);

                calendar.addActivity(activity);

                DatabaseInput.writeNewCSV(calendar);

            } else if (Choice1.equals("delete")) {

                System.out.println("Please enter the Activity you would like to delete");
                String deletedActivity = scan.nextLine();

                boolean worked = calendar.deleteActivity(deletedActivity);
                DatabaseInput.writeCSV(calendar);

                if (worked) {
                    System.out.println("Activity successfully deleted");
                } else {
                    System.out.println("Activity not found");
                }

            } else if (Choice1.equals("display")) {

                System.out.println("Please select from the following: \n" + "Display entire calendar, ENTER: 'All' \n"
                        + "Display by Activity Name, ENTER: 'Name' \n" + "Display by Year, ENTER: 'Year' \n"
                        + "Display by Month: Enter 'Month' \n" + "Display by Role, ENTER: 'Role'\n");
                String displayBy = scan.nextLine();

                if (displayBy.equals("Name")) {

                    System.out.println("Please enter the activity you want to display:");
                    String activityName = scan.nextLine();

                    ArrayList<Activity> act = calendar.searchByName(activityName);

                    if (act != null) {
                        System.out.println("\n" + "Activities with the name provided: " + "\n" + act);

                    } else {
                        System.out.println("No activity found by that name\n");
                    }

                } else if (displayBy.equals("Year")) {

                    System.out.println("Please enter the year of the activity you want to display.");
                    int activityYear = scan.nextInt();

                    ArrayList<Activity> act = calendar.searchByYear(activityYear);
                    ;
                    if (act != null) {
                        System.out.println("\n" + "Activities that happened in the Year provided: " + "\n" + act);
                    } else {
                        System.out.println("No activity found in year provided\n");
                    }

                } else if (displayBy.equals("Month")) {

                    System.out.println("Please enter a month to search by:");
                    String activityMonth = scan.nextLine();

                    ArrayList<Activity> act = calendar.searchByMonth(activityMonth);

                    if (act != null) {
                        System.out.println("\n" + "Activities that happened in the Month provided: " + "\n" + act);
                    } else {
                        System.out.println("No activity found in month provided\n");
                    }

                } else if (displayBy.equals("Role")) {

                    System.out.println("Please enter a Role to search by:");
                    String activityRole = scan.nextLine();

                    ArrayList<Activity> act = calendar.searchByRole(activityRole);

                    if (act != null) {
                        System.out.println("\n" + "Activities that include the Role provided: " + "\n" + act);
                    } else {
                        System.out.println("No role found from that provided\n");
                    }

                } else if (displayBy.equals("All")) {

                    ArrayList<Activity> act = calendar.activity;

                    System.out.println("Would you like it sorted in 'ascending' or 'descending' order?");
                    String sortType = scan.nextLine();

                    if (sortType.equals("ascending")) {
                        Collections.sort(act);
                        System.out.println("\n" + "All Activities: " + "\n" + act);
                    } else if (sortType.equals("descending")) {
                        Collections.reverse(act);
                        System.out.println("\n" + "All Activities: " + "\n" + act);
                    }
                }
            } else if (Choice1.equals("exit")) {

                contin = false;
                System.out.println("Goodbye");

            }

        }

    }

}
