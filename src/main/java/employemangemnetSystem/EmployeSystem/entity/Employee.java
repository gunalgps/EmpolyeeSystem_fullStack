package employemangemnetSystem.EmployeSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "employees")

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="Fristname")
    private String FristName;
    @Column(name = "Lastname")
    private String LastName;
    @Column(name = "email" ,nullable = false, unique = true)
    private String email;
}
