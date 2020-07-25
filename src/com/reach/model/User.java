package com.reach.model;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class User implements Serializable,Model {

    public User() {}

    protected String userName;
    protected String lastName;
    protected String firstName;
    private String Password;
    protected UserType userType;
    protected int userId;
    protected String phone;
    protected String userCity;
    protected ArrayList<Job> jobs = new ArrayList<>();
    protected ArrayList<Job> jobsHistory = new ArrayList<>();

    // Setters
    public void setPassword(String password) {
        Password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setJobs(ArrayList<Job> jobs) {
        this.jobs = jobs;
    }

    public void setJobsHistory(ArrayList<Job> jobsHistory) {
        this.jobsHistory = jobsHistory;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public void addJob(String WorkerUser,String CustomerUser,String description,int lastId){
        Job newOne = new Job(CustomerUser,WorkerUser,description,lastId);
        jobs.add(newOne);
    }

    public void addJob(Job toAdd,int lastId){
        Job newOne = new Job(toAdd,lastId);
        jobs.add(newOne);
    }

    // getters
    public ArrayList<Job> getJobs() {
        return jobs;
    }

    public ArrayList<Job> getJobsHistory() {
        return jobsHistory;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getUserId() {
        return userId;
    }

    public String getPhone() {
        return phone;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserCity() {
        return userCity;
    }

    public UserType getUserType() {
        return userType;
    }

    public String getPassword() {
        return Password;
    }

}
