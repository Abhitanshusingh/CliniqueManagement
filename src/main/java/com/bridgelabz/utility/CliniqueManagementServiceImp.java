package com.bridgelabz.utility;

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

}
