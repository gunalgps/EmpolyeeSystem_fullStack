package employemangemnetSystem.EmployeSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employeedto {
    private Long id;
    private String FristName;
    private String LastName;
    private String email;

}
