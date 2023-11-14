package br.edu.school.future.domain.dto.request;

import br.edu.school.future.domain.FinancePlan;
import br.edu.school.future.domain.enums.Gender;
import br.edu.school.future.domain.enums.SkinType;
import br.edu.school.future.domain.enums.StatusStudent;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    @Id
    private String id;
    private String name;
    private String surname;
    private String registrationNumber;
    private String birthDay;
    private int age;
    private Gender gender;
    private String numberFone;
    private SkinType type;
    private FinancePlan value;
    private StatusStudent statusStudent;
}
