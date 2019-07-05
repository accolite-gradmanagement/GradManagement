package com.assessment.data.model;

public class ScoreDetails {
    private  int employeeId;
    private String  employeeName;
    private int totalQuestions;
    private  int correctQuestions;
    private  int incorrectQuestions;
    private int successPercentage;
    private int year;
    private  String batchName;
    private String testName;
    private int score;
    private  int rank;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public int getCorrectQuestions() {
        return correctQuestions;
    }

    public void setCorrectQuestions(int correctQuestions) {
        this.correctQuestions = correctQuestions;
    }

    public int getIncorrectQuestions() {
        return incorrectQuestions;
    }

    public void setIncorrectQuestions(int incorrectQuestions) {
        this.incorrectQuestions = incorrectQuestions;
    }

    public int getSuccessPercentage() {
        return successPercentage;
    }

    public void setSuccessPercentage(int successPercentage) {
        this.successPercentage = successPercentage;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
