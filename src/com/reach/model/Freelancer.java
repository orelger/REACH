package com.reach.model;

public class Freelancer extends User implements  Model{

    protected String field;
    protected String subfield;
    protected String yearsOfExperience;
    protected String area;

    public Freelancer(UserType choice, String userName, String PrivateName, String LastName, String Password) {
        this.userType = choice;
        setUserName(userName);
        setFirstName(PrivateName);
        setLastName(LastName);
        setPassword(Password);
    }

    @Override
    public UserType getUserType() {
        return UserType.freelancer;
    }

    public String getField() {
        return this.field;
    }

    public String getSubfield() {
        return this.subfield;
    }

    public void setSubfield(String subfield) {
        this.subfield=subfield;
    }

    public String getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(String yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public void setArea(String area){
        this.area=area;
    }

    public String getArea() {
        return this.area;
    }

    public void setField(String enterF) {
        this.field=enterF;
    }
}