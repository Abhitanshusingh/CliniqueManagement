package com.bridgelabz.model;

public class Doctor {
    private String name;
    private int id;
    private String specialization;
    private String availability;

    public Doctor(String name, int id, String specialization, String availability) {
        this.name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        this.id = id;
        this.specialization = specialization.substring(0, 1).toUpperCase() + specialization.substring(1).toLowerCase();
        this.availability = availability;
    }

    public Doctor() {

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

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", specialization='" + specialization + '\'' +
                ", availability='" + availability + '\'' +
                '}';
    }
}
