package br.edu.school.future.domain;

import br.edu.school.future.domain.enums.StatusStudent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "students")
public class RegisterStudents {
    @Id
    private String id;
    private String name;
    private String surname;
    private String registrationNumber;
    private LocalDate birthDay;
    private int age;
    private String numberFone;
    private String serieNumber;
    private FinancePlan value;
    private StatusStudent statusStudent;
    private CurricularStructure curriculum;
}
