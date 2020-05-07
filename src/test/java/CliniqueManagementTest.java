import com.bridgelabz.model.Doctor;
import com.bridgelabz.model.Patients;
import com.bridgelabz.utility.CliniqueManagementServiceImp;
import com.bridgelabz.utility.FileSystem;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class CliniqueManagementTest {

    public static final String doctorfilePath = "./src/main/resources/Doctor.json";
    public static final String patientfilePath = "./src/main/resources/Patient.json";
    CliniqueManagementServiceImp cliniqueManagementServiceImp;
    FileSystem fileSystem;
    ObjectMapper objectMapper;

    @Before
    public void setUp() {
        cliniqueManagementServiceImp = new CliniqueManagementServiceImp();
        fileSystem = new FileSystem();
        objectMapper = new ObjectMapper();

    }

    @Test
    public void givenFile_whenAddDoctorDelail_shouldReturnTrue() {
        try {
            Doctor doctor1 = new Doctor("Deepak singh", 3421, "Dentist", "9am");
            Doctor doctor2 = new Doctor("Anoop singh", 4321, "Skin", "12am");
            Doctor doctor3 = new Doctor("Devki gupta", 3241, "Corona", "3pm");
            Doctor doctor4 = new Doctor("Kishan pandey", 4342, "Orthopaedics", "6pm");
            Doctor doctor5 = new Doctor("Himanshu singh", 5321, "Dermatology", "9pm");

            cliniqueManagementServiceImp.addInformation(doctor1, doctorfilePath);
            cliniqueManagementServiceImp.addInformation(doctor2, doctorfilePath);
            cliniqueManagementServiceImp.addInformation(doctor3, doctorfilePath);
            cliniqueManagementServiceImp.addInformation(doctor4, doctorfilePath);
            cliniqueManagementServiceImp.addInformation(doctor5, doctorfilePath);
            ArrayList<Doctor> data = objectMapper
                    .readValue(new File(doctorfilePath), new TypeReference<ArrayList<Doctor>>() {
                    });
            Assert.assertEquals(doctor1.getName(), data.get(0).getName());
            Assert.assertEquals(doctor2.getName(), data.get(1).getName());
            Assert.assertEquals(doctor3.getName(), data.get(2).getName());
            Assert.assertEquals(doctor4.getName(), data.get(3).getName());
            Assert.assertEquals(doctor5.getName(), data.get(4).getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenFile_whenAddPatientDelail_shouldReturnTrue() {
        try {
            Patients patients1 = new Patients("Amar khan", 1, 9897636572L, 27);
            Patients patients2 = new Patients("Ali khan", 2, 9978987631L, 22);
            Patients patients3 = new Patients("Shahil khan", 3, 7897635382L, 23);
            Patients patients4 = new Patients("Danish khan", 4, 8947038738L, 25);
            Patients patients5 = new Patients("Abhi singh", 5, 7004342412L, 23);
            cliniqueManagementServiceImp.addInformation(patients1, patientfilePath);
            cliniqueManagementServiceImp.addInformation(patients2, patientfilePath);
            cliniqueManagementServiceImp.addInformation(patients3, patientfilePath);
            cliniqueManagementServiceImp.addInformation(patients4, patientfilePath);
            cliniqueManagementServiceImp.addInformation(patients5, patientfilePath);

            ArrayList<Patients> data = objectMapper
                    .readValue(new File(patientfilePath), new TypeReference<ArrayList<Patients>>() {
                    });
            Assert.assertEquals(patients1.getName(), data.get(1).getName());
            Assert.assertEquals(patients2.getName(), data.get(2).getName());
            Assert.assertEquals(patients3.getName(), data.get(3).getName());
            Assert.assertEquals(patients4.getName(), data.get(4).getName());
            Assert.assertEquals(patients5.getName(), data.get(5).getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenFile_whenSearchDoctorByName_shouldReturnTrue() {
        String doctorName = "Anoop singh";
        boolean isDoctor = cliniqueManagementServiceImp.searchDoctorByName(doctorName, doctorfilePath);
        Assert.assertTrue(isDoctor);
    }

    @Test
    public void givenFile_whenSearchDoctorById_shouldReturnTrue() {
        int doctorId = 5321;
        boolean isDoctor = cliniqueManagementServiceImp.searchDoctorById(doctorId, doctorfilePath);
        Assert.assertTrue(isDoctor);
    }
}
