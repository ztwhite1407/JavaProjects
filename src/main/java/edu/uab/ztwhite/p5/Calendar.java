/*
 * File: Calendar.java
 * Author: Zachary White ztwhite@uab.edu
 * Assignment:  P5 - EE333 Fall 2019
 * Vers: 1.0.0 10/26/2019 zw - initial coding
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
import java.io.FileReader;
import java.util.*;

/**
 *
 * @author Zachary White ztwhite@uab.edu
 */
public class Calendar {

    /**
     * @param activity Creates an ArrayList of Activities(Which include the
     * Year, Month, Name and Roles in each Activity List))
     */
    ArrayList<Activity> activity = new ArrayList<>();

    /**
     * returns true when a new activity is added to the Activity ArrayList
     *
     * @param newActivity
     * @return
     */
    public boolean addActivity(Activity newActivity) {
        activity.add(newActivity);
        return true;
    }

    /**
     * Return's the size of the activity ArrayList.
     *
     * @return
     */
    public int size() {
        return activity.size();
    }

    /**
     * Returns the activities of the Activity ArrayList.
     *
     * @return
     */
    public ArrayList<Activity> getActivities() {
        return activity;
    }

    /**
     * Returns true if the Activity selected by the user to delete is
     * successfully deleted.
     *
     * @param activityName
     * @return
     */
    public boolean deleteActivity(String activityName) {

        // search for that activity in the arraylist
        // and return true if we find it and delete it
        int indexOfActivity = -1;

        for (int i = 0; i < activity.size(); i++) {
            Activity a = activity.get(i);
            if (a.getActivityName().equalsIgnoreCase(activityName)) {
                indexOfActivity = i;
            }
        }
        // if not found return false
        if (indexOfActivity == -1) {
            return false;
        }

        activity.remove(indexOfActivity);
        return true;

    }

    /**
     * Searches the Activity ArrayList for activity names that match the name
     * searched for by the user. A new ArrayList is created named
     * 'matchActivity' where the positions of those elements that match are
     * stored. The matchActivity ArrayList is returned.
     *
     * @param activityName
     * @return
     */
    public ArrayList<Activity> searchByName(String activityName) {

        ArrayList<Activity> matchActivity = new ArrayList<>();
        int indexOfActivity = -1;

        for (int i = 0; i < activity.size(); i++) {
            Activity a = activity.get(i);

            if (a.getActivityName().contains(activityName)) {
                indexOfActivity = i;
                matchActivity.add(a);

            }
        }

        if (indexOfActivity == -1) {
            return null;
        }

        return matchActivity;
    }

    /**
     * Searches the Activity ArrayList for months that match the month searched
     * for by the user. A new ArrayList is created named 'matchActivity' where
     * the positions of those elements that match are stored. The matchActivity
     * ArrayList is returned.
     *
     *
     * @param Month
     * @return
     */
    public ArrayList<Activity> searchByMonth(String Month) {

        ArrayList<Activity> matchActivity = new ArrayList<>();
        int indexOfActivity = -1;

        for (int i = 0; i < activity.size(); i++) {
            Activity a = activity.get(i);

            if (a.getActivityMonth().contains(Month)) {
                indexOfActivity = i;
                matchActivity.add(a);

            }
        }

        if (indexOfActivity == -1) {
            return null;
        }

        return matchActivity;
    }

    /**
     * Searches the Activity ArrayList for activity years that match the year
     * searched for by the user. A new ArrayList is created named
     * 'matchActivity' where the positions of those elements that match are
     * stored. The matchActivity ArrayList is returned.
     *
     * @param Year
     * @return
     */
    public ArrayList<Activity> searchByYear(int Year) {

        ArrayList<Activity> matchActivity = new ArrayList<>();
        int indexOfActivity = -1;

        for (int i = 0; i < activity.size(); i++) {
            Activity a = activity.get(i);

            if (a.getActivityYear() == (Year)) {
                indexOfActivity = i;
                matchActivity.add(a);

            }
        }

        if (indexOfActivity == -1) {
            return null;
        }

        return matchActivity;
    }

    /**
     * Searches the Activity ArrayList for activity Roles that match the Role
     * searched for by the user. A new ArrayList is created named
     * 'matchActivity' where the positions of those elements that match are
     * stored. The matchActivity ArrayList is returned.
     *
     * @param activityRole
     * @return
     */
    public ArrayList<Activity> searchByRole(String activityRole) {

        ArrayList<Activity> matchActivity = new ArrayList<>();
        int indexOfActivity = -1;

        for (int i = 0; i < activity.size(); i++) {
            Activity a = activity.get(i);

            if (a.getActivityRole().toString().contains(activityRole)) {
                indexOfActivity = i;
                matchActivity.add(a);

            }
        }

        if (indexOfActivity == -1) {
            return null;
        }

        return matchActivity;
    }

}
