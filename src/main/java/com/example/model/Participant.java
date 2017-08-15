package com.example.model;

public class Participant {

    private int lane;
    private int startNumber;
    private String firstname;
    private String lastname;
    private String country;
    private double sb2017;
    private double pb;

    public int getLane() {
        return lane;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Participant(int lane, int startNumber, String firstname, String lastname, String country, double sb2017, double pb) {
        this.lane = lane;
        this.startNumber = startNumber;
        this.firstname = firstname;
        this.lastname = lastname;
        this.country = country;
        this.sb2017 = sb2017;
        this.pb = pb;
    }
}
