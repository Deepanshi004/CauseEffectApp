package com.example.causeeffectapp;

public class Person {
    private String name;
    private String street;
    private String city;
    private String state;
    private String country;
    private String telephone;
    private String birthday;

    public Person(String name,String street,String city,
                  String state,String country,String telephone,
                  String birthday){
        this.name=name;
        this.birthday=birthday;
        this.state=state;
        this.street=street;
        this.city=city;
        this.country=country;
        this.telephone=telephone;
    }

    public String getName(){ return name;}
    public String getStreet(){ return street;}
    public String getCity(){ return city;}
    public String getState(){ return state;}
    public String getCountry(){ return country;}
    public String getTelephone(){ return telephone;}
    public String getBirthday(){ return birthday;}

    public void setName(String s) {
        this.name=s;
    }
}
