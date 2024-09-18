/*
 * Subject: Software Design Patterns
 * Creational Pattern -> Builder
 * Class: Program
 */
package com.ceron.data.transfer;

/**
 * Author: Fabrizio Bolaño
 */
public class Program {
    private String programName;
    private int numberOfSemesters;

    public Program() {
    }

    public Program(String programName, int numberOfSemesters) {
        this.programName = programName;
        this.numberOfSemesters = numberOfSemesters;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public int getNumberOfSemesters() {
        return numberOfSemesters;
    }

    public void setNumberOfSemesters(int numberOfSemesters) {
        this.numberOfSemesters = numberOfSemesters;
    }

    @Override
    public String toString() {
        return "Program{" + "programName='" + programName + '\'' + ", numberOfSemesters=" + numberOfSemesters + '}';
    }
}
