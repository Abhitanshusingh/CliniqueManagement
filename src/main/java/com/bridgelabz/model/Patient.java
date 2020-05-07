package com.bridgelabz.model;

public class Patients {
    private String name;
    private int id;
    private long mobileNumbre;
    private int age;

    public Patients() {
    }

    public Patients(String name, int id, long mobileNumbre, int age) {
        this.name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        this.id = id;
        this.mobileNumbre = mobileNumbre;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getMobileNumbre() {
        return mobileNumbre;
    }

    public void setMobileNumbre(long mobileNumbre) {
        this.mobileNumbre = mobileNumbre;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
