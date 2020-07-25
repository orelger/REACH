package com.reach.controller;

import com.reach.model.*;
import java.util.ArrayList;
import java.util.List;

public class MyController {

    private static final MyController instance = new MyController();

    //constructor for singleton
    private MyController(){}
    //Method to return the instance of the singleton
    public static MyController getInstance(){return instance;}
    //Method to verify the user name and password
    public boolean verifyUserNameAndPassword(String userName,String password) {
        if(WriterReader.verify(userName,password))
            return true;
        else
            return false;
    }

    /*public int getUserId(String userName)
    {
        return WriterReader.UsersHM.get(userName).getUserId();
    }*/

    public UserType getUserType(String userName){
        return WriterReader.getUserType(userName);
    }

    public String getFirstName(String username) {
        return WriterReader.getFirstName(username);
    }

    public String getLastName(String username) {
        return WriterReader.getLastName(username);
    }

    public String getPhone(String userName) {
        return WriterReader.getPhone(userName);
    }

    public void setPhone(String userName ,String phone) {
        WriterReader.setPhone(userName , phone);
    }

    public void setCity(String userName, String city) {
        WriterReader.setCity(userName,city);
    }

    public String getCity(String username) {
        return WriterReader.getCity(username);
    }

    public String getExperience(String username) {
        return WriterReader.getExperience(username);
    }

    public String getArea(String username) {
        return WriterReader.getArea(username);
    }

    public void setExperience(String userName, String experience) {
        WriterReader.setExperience(userName,experience);
    }

    public void setNewJob(String CustomerUserName,String WorkerUserName,String description){
        WriterReader.setNewJob(CustomerUserName,WorkerUserName,description);
        //WriterReader.UsersHM.get(WorkerUserName)
    }

    public String getField(String userName) {
        return WriterReader.getField(userName);
    }

    public void setField(String userName, String enterF) {
        WriterReader.setField(userName,enterF);
    }

    public void setSubfield(String userName, String subfield) {
        WriterReader.setSubfield(userName,subfield);
    }

    public String getSubfield(String username) {
        return WriterReader.getSubfield(username);
    }

    public void setArea(String userName, String chooseArea) {
        WriterReader.setArea(userName,chooseArea);
    }

    //Get user's job list siaze by user name
    public int getUserJobsSize(String userName){
        User user = WriterReader.UsersHM.get(userName);
        return user.getJobs().size();
    }

    //Get user's history jobs list size by user name
    public int getUserJobHistorySize(String userName){
        User user = WriterReader.UsersHM.get(userName);
        return user.getJobsHistory().size();
    }

    //Get job's description from history jobs list by user name and index
    public  String HistoryDescription(String userName, int i){
        return WriterReader.UsersHM.get(userName).getJobsHistory().get(i).getDescription();
    }

    //Get job's description from jobs list by user name and index
    public  String JobDescription(String userName, int i){
        return WriterReader.UsersHM.get(userName).getJobs().get(i).getDescription();
    }

    //Get job accaptence status from jobs list by user name and index
    public Boolean JobAcceptance(String userName,int i){
        User user = WriterReader.UsersHM.get(userName);
        ArrayList<Job> list = user.getJobs();
        Boolean answer = list.get(i-1).getAccepted();
        return answer;
    }

    public void JobSetAcceptance(String userName,int i){
        WriterReader.JobSetAcceptance(userName,i-1);
    }

    //Declare job accepted in jobs list and update accaptence status for the job
    public void acceptJob(String WorkerUserName , String CusUserName,int ID){
        ArrayList<Job> list = WriterReader.UsersHM.get(WorkerUserName).getJobs();
        Job job = list.get(ID-1);
        job.setAccepted();
        WriterReader.UsersHM.get(WorkerUserName).getJobs().get(ID-1).setAccepted();
        WriterReader.setNewJobForCustomer(CusUserName,job);
    }

    //Get customer user name from a specipic job in a wrokers job list by user name and index
    public String getJobFromWorker(String userName,int i){
        return WriterReader.UsersHM.get(userName).getJobs().get(i-1).getCustomerUserName();
    }

    //Get job id from history jobs list by user name and index
    public int HistoryID(String userName, int i){
        return WriterReader.UsersHM.get(userName).getJobsHistory().get(i).getId();
    }

    //Get job id from jobs list by user name and index
    public int JobID(String userName, int i){
        ArrayList<Job> list = WriterReader.UsersHM.get(userName).getJobs();
        Job job = list.get(i);
        int x = job.getId();
        return x;
    }

    public Job getJob(String userName,int ID){
        return WriterReader.UsersHM.get(userName).getJobs().get(ID-1);
    }

    //Edit job detais
    public void EditNewJob(String customerUserName, String workerUserName, String startDate,String endDate,String price,int ID) {
        WriterReader.EditNewJob(customerUserName,workerUserName,
                getJob(workerUserName,ID).getDescription(),
                startDate,endDate,price,ID);

    }

    //Get size of matching search results list
    public int getResultsSize(String prof,String area){
        int results=0;
        ArrayList<String> keys = new ArrayList<>(WriterReader.UsersHM.keySet());
        for (String key : keys)
        {
            User user = WriterReader.UsersHM.get(key);
            if(user.getUserType()==UserType.freelancer && (((Freelancer)user).getArea()) != null &&  ((Freelancer)user).getArea().equals(area) && (((Freelancer)user).getField()) != null &&  ((Freelancer)user).getField().equals(prof))
                results++;
            else if(user.getUserType()==UserType.contractor && (((Contractor)user).getArea()) != null &&  ((Contractor)user).getArea().equals(area) && (((Contractor)user).getField()) != null &&  ((Contractor)user).getField().equals(prof))
                results++;
        }
        return results;
    }

    //Get results name by filters and index in list
    public String getResultsName(String prof,String area,int i) {
        List<User> results = new ArrayList<>();
        ArrayList<String> keys = new ArrayList<>(WriterReader.UsersHM.keySet());
        for (String key : keys)
        {
            User user = WriterReader.UsersHM.get(key);
            if(user.getUserType()==UserType.freelancer && (((Freelancer)user).getArea()) != null &&  ((Freelancer)user).getArea().equals(area) && (((Freelancer)user).getField()) != null &&  ((Freelancer)user).getField().equals(prof))
                results.add(WriterReader.UsersHM.get(key));
            else if(user.getUserType()==UserType.contractor && (((Contractor)user).getArea()) != null &&  ((Contractor)user).getArea().equals(area) && (((Contractor)user).getField()) != null &&  ((Contractor)user).getField().equals(prof))
                results.add(WriterReader.UsersHM.get(key));
        }
        return results.get(i).getFirstName();
    }

    //Get results user name by filters and index in list
    public String getResultsUserName(String prof,String area,int i) {
        List<User> results = new ArrayList<>();
        ArrayList<String> keys = new ArrayList<>(WriterReader.UsersHM.keySet());
        for (String key : keys)
        {
            User user = WriterReader.UsersHM.get(key);
            if(user.getUserType()==UserType.freelancer &&
                    (((Freelancer)user).getArea()) != null &&
                    ((Freelancer)user).getArea().equals(area) &&
                    (((Freelancer)user).getField()) != null &&
                    ((Freelancer)user).getField().equals(prof))
                results.add(WriterReader.UsersHM.get(key));
            else if(user.getUserType()==UserType.contractor &&
                    (((Contractor)user).getArea()) != null &&
                    ((Contractor)user).getArea().equals(area) &&
                    (((Contractor)user).getField()) != null &&
                    ((Contractor)user).getField().equals(prof))
                results.add(WriterReader.UsersHM.get(key));
        }
        return results.get(i/2).getUserName();
    }

    //Get resluts sub-field by filters and index in list
    public String getResultsSub(String prof, String area, int i) {
        List<User> results = new ArrayList<>();
        ArrayList<String> keys = new ArrayList<>(WriterReader.UsersHM.keySet());
        for (String key : keys)
        {
            User user = WriterReader.UsersHM.get(key);
            if(user.getUserType()==UserType.freelancer && (((Freelancer)user).getArea()) != null &&  ((Freelancer)user).getArea().equals(area) && (((Freelancer)user).getField()) != null &&  ((Freelancer)user).getField().equals(prof))
                results.add(WriterReader.UsersHM.get(key));
            else if(user.getUserType()==UserType.contractor && (((Contractor)user).getArea()) != null &&  ((Contractor)user).getArea().equals(area) && (((Contractor)user).getField()) != null &&  ((Contractor)user).getField().equals(prof))
                results.add(WriterReader.UsersHM.get(key));
        }
        if(results.get(i).getUserType()==UserType.contractor) {
            return ((Contractor) results.get(i)).getSubfield();
        }
        else if (results.get(i).getUserType()==UserType.freelancer) {
            return ((Freelancer) results.get(i)).getSubfield();
        }
        return null;
    }

}