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

    public boolean searchDoctorById(int doctorId, String doctorfilePath);
    /**
     * This method is used to search doctor
     * by id from json file.
     */

    public boolean searchDoctorBySpecialization(String doctorSpecialist, String doctorfilePath);
    /**
     * This method is used to search doctor
     * by specialist from json file.
     */

    public boolean searchDoctorByAvailability(String doctorAvailability, String doctorfilePath);
    /**
     * This method is used to search doctor
     * by availability from json file.
     */

    public boolean searchPatientByName(String patientName, String patientFilePath);
    /**
     * This method is used to search patient
     * by name from json file.
     */

    public boolean searchPatientByMobileNumber(long mobileNumber, String patientfilePath);
    /**
     * This method is used to search patient
     * by mobile number from json file.
     */
}
