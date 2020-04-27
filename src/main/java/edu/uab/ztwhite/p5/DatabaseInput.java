/*
 * File: Data.java
 * Author: Zachary White ztwhite@uab.edu
 * Assignment:  P5 - EE333 Fall 2019
 * Vers: 1.0.0 11/02/2019 zw - initial coding
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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author Zachary White ztwhite@uab.edu
 */
public class DatabaseInput {

    /**
     * Writes the Activity ArrayList to the existing CSV file.
     *
     * @param cal
     */
    public static void writeCSV(Calendar cal) {

        try {

            BufferedWriter bw = null;

            String fileString = "P5Calendar.csv";
            String fileLine = "";

            FileWriter fw = new FileWriter(fileString, false);
            bw = new BufferedWriter(fw);

            ArrayList<Activity> activities = cal.getActivities();

            for (int j = 0; j < 1; j++) {
                bw.write("Year" + "," + "Month" + "," + "Activity" + "," + "Role" + "\n");
            }

            for (int i = 0; i < activities.size(); i++) {
                Activity activity = activities.get(i);
                bw.append(activity.Year + "," + activity.Month + "," + activity.Name + "," + activity.Roles);
            }

            bw.close();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    /**
     * Adds any new Activities that were added by the user to the Activity
     * ArrayList
     *
     * @param cal
     */
    public static void writeNewCSV(Calendar cal) {

        try {

            BufferedWriter bw = null;

            String fileString = "P5Calendar.csv";
            String fileLine = "";

            FileWriter fw = new FileWriter(fileString, true);
            bw = new BufferedWriter(fw);

            ArrayList<Activity> activities = cal.getActivities();

            int lastElement = activities.size();
            Activity activity = activities.get(lastElement - 1);
            bw.write(activity.Year + "," + activity.Month + "," + activity.Name + "," + activity.Roles.name + " " + "("
                    + activity.Roles.subRole + ")" + "\n");

            bw.close();

        } catch (IOException e) {

            e.printStackTrace();

        }
    }

    /**
     * Deletes any Activities chosen by the user from the CSV file.
     *
     * @param activity
     */
    public void deleteCSV(Activity activity) {

        try {
            BufferedReader br = new BufferedReader(new FileReader("P5Calendar.csv"));
            String myLine = br.readLine();

            while (myLine != null) {

                // read new line
                myLine = br.readLine();

            }
        } catch (IOException e) {

        }
    }

    /**
     * The most important part of this program. readRecord is called first by
     * the main method. Once called this method reads through the CSV file named
     * 'DatabaseInput' where it stores all the data in the Activity ArrayList
     *
     * @param cal
     *
     */
    public static void readRecord(Calendar cal) {

        boolean firstLine = true;
        boolean found = false;
        String ActivityName = " ";
        Role r;
        String Month = " ";

        int Year = 0;

        try {

            Scanner x = new Scanner(new File("P5Calendar.csv"));

            while (x.hasNext() && !found) {

                String[] line = x.nextLine().split(",");

                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                Year = Integer.parseInt(line[0]);
                Month = line[1];
                ActivityName = line[2];

                r = new Role(line[3].replaceAll("\\(.*\\)", ""),
                        line[3].substring(line[3].indexOf("(") + 1, line[3].indexOf(")")));

                Activity act = new Activity(Year, Month, ActivityName, r);

                cal.addActivity(act);

            }

            x.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
