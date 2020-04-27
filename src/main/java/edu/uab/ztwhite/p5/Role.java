/*
 * File: Role.java
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

/**
 *
 * @author Zachary White ztwhite@uab.edu
 */
public class Role {

    /**
     *
     */
    public String name;

    /**
     *
     */
    public String subRole;

    /**
     * Constructor that builds the Role name and subRole for the given Activity.
     * @param name
     * @param subRole
     */
    public Role(String name, String subRole) {
        this.name = name;
        this.subRole = subRole;

        if (name.equals("Director")) {
            this.subRole = "Management";
        } else {

        }
    }

    /**
     * Gets the role name for the current Activity
     * @return
     */
    public String getRoleName() {
        return name;
    }

    /**
     * Gets the sub role for the current Activity
     * @return
     */
    public String getSubRoleName() {
        return subRole;
    }

    /**
     * Sets the sub role for the current Activity
     * @param subRole
     */
    public void setSubRoleName(String subRole) {
        this.subRole = subRole;
    }

    /**
     * Sets the role name for the current Activity
     * @param role
     */
    public void setRole(Role role) {
        this.name = name;
    }

    /**
     * Returns true if the name of the role for the current Activity equals 'ALL'
     * @param roleName
     * @return
     */
    public boolean sameRole(String roleName) {
        if (roleName.equalsIgnoreCase("ALL")) {
            return true;
        } else if (roleName.equalsIgnoreCase(this.name)) {
            return true;
        } else if (roleName.equalsIgnoreCase(this.subRole)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return (this.getRoleName());

    }

}
