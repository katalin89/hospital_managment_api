package ro.mycode.hospital_managment_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.mycode.hospital_managment_api.model.Patient;

@Repository
public interface PatientRepo extends JpaRepository<Patient,Long> {
}
