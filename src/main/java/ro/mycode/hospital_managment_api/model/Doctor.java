package ro.mycode.hospital_managment_api.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="Doctor")
@Table(name="doctors")
@SuperBuilder
public class Doctor implements Comparable<Doctor> {

    @Id
    @SequenceGenerator(name="doctor_sequence",sequenceName = "doctor_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "doctor_sequence")
    private Long id;

    @Column(name="doctor_name",nullable=false)
    @NotBlank(message="string field cannot be an empty string ")
    private String doctorName;

    @Column(name="type_of_doctor")
    @Size(min = 2,message = "Must be min2 caracters")
    private String typeOfDoctor;

    @Column(name="phone_number")
    @Min(value=10,message = "The phone number must be 10 digit")
    private String phonNumber;

    @Column(name="email")
    @Email(message = "That  string field must be a valid email address.")
    private String email;


    @Override
    public boolean equals(Object o){
        Doctor doctor=(Doctor) o;
        return  this.phonNumber==doctor.phonNumber;
    }

    @Override
    public int compareTo(Doctor o) {
        return 0;
    }

    @OneToMany(
            mappedBy = "doctor",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )

    @JsonManagedReference
    @Builder.Default
    List<Patient> pacients=new ArrayList<>();

    public  void addDoctor(Patient pacient){
        this.pacients.add(pacient);
        pacient.setDoctor(this);
    }



}
