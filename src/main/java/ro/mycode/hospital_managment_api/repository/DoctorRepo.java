package ro.mycode.hospital_managment_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.mycode.hospital_managment_api.model.Doctor;

public interface DoctorRepo  extends JpaRepository<Doctor,Long> {
}
