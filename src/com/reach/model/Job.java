package com.reach.model;

import java.io.Serializable;

public class Job implements Serializable,Model{
    protected int id;
    protected String description;
    protected String customerUserName;
    protected String workerUserName;
    protected String title;
    protected String date;
    protected String deadline;
    protected Price Price;
    protected Boolean accepted = false;

    public Job(String CusUserName,String WorkUserName,String desc,int lastId){
        customerUserName = CusUserName;
        workerUserName = WorkUserName;
        description = desc;
        id = lastId;
    }

    public Job(Job toAdd,int lastId) {
        id = lastId;
        description = toAdd.getDescription();
        customerUserName = toAdd.getCustomerUserName();
        workerUserName = toAdd.getWorkerUserName();
        title = toAdd.getTitle();
        date = toAdd.getDate(); //
        deadline = toAdd.getDeadline(); //
        Price = toAdd.getPrice(); //
        accepted = toAdd.getAccepted();
    }

    public String getWorkerUserName() {
        return workerUserName;
    }

    public String getCustomerUserName() {
        return customerUserName;
    }

    public void setAccepted(){
        accepted = true;
    }

    public int getId() {
        return id;
    }

    public Boolean getAccepted(){return accepted;}

    public String getDate() {
        return date;
    }

    public Price getPrice() {
        return Price;
    }

    public String getDeadline() {
        return deadline;
    }

    public String getDescription() {
        return this.description;
    }

    public String getTitle() {
        return title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public void setPrice(Price price){
        this.Price=price;
    }

    /*public void setTitle(String title) {
        this.title = title;
    }*/
}
