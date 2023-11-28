package br.edu.school.future.domain.dto.response;

import br.edu.school.future.domain.Subjects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StructureResponse {
    private String curricularStructure;
    private List<Subjects> subjects;
}



