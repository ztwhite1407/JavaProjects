/*
 * File: Activity.java
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

import java.util.*;

/**
 *
 * @author Zachary White ztwhite@uab.edu
 */
public class Activity implements Comparable<Activity> {

    String Name;
    Role Roles;
    String Month;
    int Year;

    /**
     * Constructor for Activity which sets the Activity's Year, Month, Name, Role and SubRole
     * from either user's input or data read from CSV file. 
     * @param Year 
     * @param Month
     * @param Name
     * @param Roles
     */
    public Activity(int Year, String Month, String Name, Role Roles) {
        this.Name = Name;
        this.Roles = Roles;
        this.Month = Month;
        this.Year = Year;
    }

    /**
     *
     * @param Name
     * Set's the Activity Name. 
     */
    public void setActivity(String Name) {
        this.Name = Name;
    }

    /**
     *
     * @return
     *  Returns the name of the Activity
     */
    public String getActivityName() {
        return Name;
    }

    /**
     * Sets the Roles (Roles and SubRole) for the current Activity
     * @param Roles
     */ 
    public void setActivityRole(Role Roles) {
        this.Roles = Roles;
    }

    /**
     * Returns the Roles (Role and SubRole) for the current Activity
     * @return
     */
    public Role getActivityRole() {
        return Roles;
    }

    /**
     * Sets the month for the current Activity
     * @param Month
     */
    public void setActivityMonth(String Month) {
        this.Month = Month;
    }

    /**
     * Returns the month for the current Activity
     * @return
     */
    public String getActivityMonth() {
        return Month;
    }

    /**
     * Sets the year for the current Activity
     * @param Year
     */
    public void setActivityYear(int Year) {
        this.Year = Year;
    }

    /**
     * Returns the year for the current Activity
     * @return
     */
    public int getActivityYear() {
        return Year;
    }

    /**
     * Returns the activity that matches that of what the user inputs.  
     * This method is used when the user wants to display all Activities
     * based on a certain Year, Month, Role or Activity name. 
     * @return
     */ 
    public int[] matchingActivities() {
        return matchingActivities();
    }

    @Override
    public String toString() {
        return ("\n" + "Year: " + this.getActivityYear() + "\n"
                + "Month: " + this.getActivityMonth() + "\n"
                + "Activity: " + this.getActivityName() + "\n"
                + "Role: " + this.getActivityRole() + "\n"
                + "SubRole: " + this.getActivityRole().subRole + "\n");
    }

    /**
     *
     * @param i
     */
    public void add(int i) {
    }

    @Override
    public int compareTo(Activity year) {
        return this.Year > year.Year ? 1 : this.Year < year.Year ? -1 : 0;
    }
}
