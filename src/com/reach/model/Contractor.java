package com.reach.model;

public class Contractor extends User implements Model{

    protected String field;
    protected String subfield;
    protected String yearsOfExperience;
    protected String area;

    public Contractor(UserType choice, String userName, String PrivateName, String LastName, String Password) {
        this.userType = choice;
        setUserName(userName);
        setFirstName(PrivateName);
        setLastName(LastName);
        setPassword(Password);
    }
    //Getters & Setters
    @Override
    public UserType getUserType() {
        return UserType.contractor;
    }

    public String getField() {
        return field;
    }

    public String getSubfield() {
        return this.subfield;
    }

    public void setField(String enterF) {
        this.field=enterF;
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

    public void setSubfield(String subfield) {
        this.subfield=subfield;
    }
}