package br.edu.school.future.domain.dto.response;

import br.edu.school.future.domain.enums.Gender;
import br.edu.school.future.domain.enums.SkinType;
import br.edu.school.future.domain.enums.StatusStudent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterResponse {

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
    private StatusStudent statusStudent;
}
