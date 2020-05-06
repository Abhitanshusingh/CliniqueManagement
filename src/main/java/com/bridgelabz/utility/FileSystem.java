package com.bridgelabz.utility;

import com.bridgelabz.model.Doctor;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class FileSystem {

    ObjectMapper objectMapper = new ObjectMapper();

    public <E> ArrayList<E> readFile(String filePath) throws IOException {
        return objectMapper.readValue(new File(filePath), new TypeReference<ArrayList<E>>() {
        });
    }

    public <E> void writeFile(ArrayList<E> list, String filePath) throws IOException {
        objectMapper.writeValue(new File(filePath), list);
    }

    public  ArrayList<Doctor> readDoctorFile(String filePath) throws IOException {
        return objectMapper.readValue(new File(filePath), new TypeReference<ArrayList<Doctor>>() {
        });
    }
}
