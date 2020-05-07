import com.bridgelabz.model.Doctor;
import com.bridgelabz.model.Patient;
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
            Patient patient1 = new Patient("Amar khan", 1, 9897636572L, 27);
            Patient patient2 = new Patient("Ali khan", 2, 9978987631L, 22);
            Patient patient3 = new Patient("Shahil khan", 3, 7897635382L, 23);
            Patient patient4 = new Patient("Danish khan", 4, 8947038738L, 25);
            Patient patient5 = new Patient("Abhi singh", 5, 7004342412L, 23);
            cliniqueManagementServiceImp.addInformation(patient1, patientfilePath);
            cliniqueManagementServiceImp.addInformation(patient2, patientfilePath);
            cliniqueManagementServiceImp.addInformation(patient3, patientfilePath);
            cliniqueManagementServiceImp.addInformation(patient4, patientfilePath);
            cliniqueManagementServiceImp.addInformation(patient5, patientfilePath);

            ArrayList<Patient> data = objectMapper
                    .readValue(new File(patientfilePath), new TypeReference<ArrayList<Patient>>() {
                    });
            Assert.assertEquals(patient1.getName(), data.get(0).getName());
            Assert.assertEquals(patient2.getName(), data.get(1).getName());
            Assert.assertEquals(patient3.getName(), data.get(2).getName());
            Assert.assertEquals(patient4.getName(), data.get(3).getName());
            Assert.assertEquals(patient5.getName(), data.get(4).getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenFile_whenSearchDoctorByName_shouldReturnTrue() {
        String doctorName = "Anoop singh";
        boolean isDoctorName = cliniqueManagementServiceImp.searchDoctorByName(doctorName, doctorfilePath);
        Assert.assertTrue(isDoctorName);
    }

    @Test
    public void givenFile_whenSearchDoctorById_shouldReturnTrue() {
        int doctorId = 5321;
        boolean isDoctorId = cliniqueManagementServiceImp.searchDoctorById(doctorId, doctorfilePath);
        Assert.assertTrue(isDoctorId);
    }

    @Test
    public void givenFile_whenSearchDoctorBySpecialization_shouldReturnTrue() {
        String doctorSpecialist = "Corona";
        boolean isDoctorSpecialist = cliniqueManagementServiceImp
                .searchDoctorBySpecialization(doctorSpecialist, doctorfilePath);
        Assert.assertTrue(isDoctorSpecialist);
    }

    @Test
    public void givenFile_whenSearchDoctorByAvailability_shouldReturnTrue() {
        String doctorAvailability = "6pm";
        boolean isDoctorAvailability = cliniqueManagementServiceImp
                .searchDoctorByAvailability(doctorAvailability, doctorfilePath);
        Assert.assertTrue(isDoctorAvailability);
    }

    @Test
    public void givenFile_whenSearchPatientByName_shouldReturnTrue() {
        String patientName = "Ali khan";
        boolean isPatientName = cliniqueManagementServiceImp.searchPatientByName(patientName, patientfilePath);
        Assert.assertTrue(isPatientName);
    }

    @Test
    public void givenFile_whenSearchPatientByMobileNumber_shouldReturnTrue() {
        long mobileNumber = 9897636572L;
        boolean isPatientName = cliniqueManagementServiceImp.searchPatientByMobileNumber(mobileNumber, patientfilePath);
        Assert.assertTrue(isPatientName);
    }
}
