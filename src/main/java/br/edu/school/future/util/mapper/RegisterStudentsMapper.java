package br.edu.school.future.util.mapper;

import br.edu.school.future.domain.FinanceStudents;
import br.edu.school.future.domain.RegisterStudents;
import br.edu.school.future.domain.dto.response.RegisterResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegisterStudentsMapper {

    private final ObjectMapper mapper;

    @SneakyThrows
    public RegisterResponse toResponse(RegisterStudents students) {
        var json = this.mapper.writeValueAsString(students);
        return this.mapper.readValue(json, RegisterResponse.class);
    }

    @SneakyThrows
    public FinanceStudents toResponseFinance(FinanceStudents studentsFinance) {
        var json = this.mapper.writeValueAsString(studentsFinance);
        return this.mapper.readValue(json, FinanceStudents.class);
    }
}
