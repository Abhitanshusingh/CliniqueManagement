package com.bridgelabz.service;

public interface ICliniqueManagementService {

    public <E> void addInformation(E data, String filePath);

    /**
     * This method is used to add data
     * into json file.
     */

    public boolean searchDoctorByName(String doctorName, String filePath);

    /**
     * This method is used to search doctor
     * by name from json file.
     */
}
