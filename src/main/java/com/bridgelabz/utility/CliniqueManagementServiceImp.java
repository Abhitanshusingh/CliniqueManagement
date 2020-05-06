package com.bridgelabz.utility;

import com.bridgelabz.model.Doctor;
import com.bridgelabz.service.ICliniqueManagementService;

import java.io.IOException;
import java.util.ArrayList;

public class CliniqueManagementServiceImp implements ICliniqueManagementService {

    FileSystem fileSystem = new FileSystem();

    @Override
    public <E> void addInformation(E data, String filePath) {
        try {
            ArrayList<E> readData = fileSystem.readFile(filePath);
            readData.add(data);
            fileSystem.writeFile(readData, filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean searchDoctorByName(String doctorName, String filePath) {
        try {
            ArrayList<Doctor> readData = fileSystem.readDoctorFile(filePath);
            for (Doctor doctorsData : readData) {
                if (doctorsData.getName().contains(doctorName)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
