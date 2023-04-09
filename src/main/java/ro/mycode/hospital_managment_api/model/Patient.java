package ro.mycode.hospital_managment_api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="Pacient")
@Table(name="pacients")
public class Patient implements  Comparable<Patient> {

    @Id
    @SequenceGenerator(name="pacient_sequence",sequenceName = "pacient_sequence",allocationSize =1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pacient_sequence")
    private Long id;

    @Column(name="book_name",nullable = false)
    @NotBlank(message = "String field cannot be an empty string")
    private String pacientName;

    @Column(name="investigation_date",nullable = false)
    private LocalDate investigationDate;

    @Column(name ="address",nullable = false)
    @Size(max=50,message = " The address can't be longer az 50 caracters")
    private String address;

    @ManyToOne
    @JoinColumn(
            name="patient_id",
            referencedColumnName = "id",
            foreignKey  =@ForeignKey(name="user_id_fk")
    )

    @JsonBackReference
    private Doctor doctor;//with witch Object is linked

    @Override
    public int compareTo(Patient o) {
        return 0;
    }
}
