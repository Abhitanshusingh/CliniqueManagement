import com.bridgelabz.model.Doctor;
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
            Doctor doctor1 = new Doctor("Deepak singh", 1, "Dentist", "9am");
            Doctor doctor2 = new Doctor("Anoop singh", 2, "Skin", "9am");
            Doctor doctor3 = new Doctor("Devki gupta", 3, "Corona", "9am");
            Doctor doctor4 = new Doctor("Kishan pandey", 4, "Orthopaedics", "9am");
            Doctor doctor5 = new Doctor("Himanshu singh", 5, "Dermatology", "9am");

            cliniqueManagementServiceImp.addInformation(doctor1, doctorfilePath);
            cliniqueManagementServiceImp.addInformation(doctor2, doctorfilePath);
            cliniqueManagementServiceImp.addInformation(doctor3, doctorfilePath);
            cliniqueManagementServiceImp.addInformation(doctor4, doctorfilePath);
            cliniqueManagementServiceImp.addInformation(doctor5, doctorfilePath);
            ArrayList<Doctor> data = objectMapper
                    .readValue(new File(doctorfilePath), new TypeReference<ArrayList<Doctor>>() {
                    });
            Assert.assertEquals(doctor1.getName(), data.get(1).getName());
            Assert.assertEquals(doctor2.getName(), data.get(2).getName());
            Assert.assertEquals(doctor3.getName(), data.get(3).getName());
            Assert.assertEquals(doctor4.getName(), data.get(4).getName());
            Assert.assertEquals(doctor5.getName(), data.get(5).getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
