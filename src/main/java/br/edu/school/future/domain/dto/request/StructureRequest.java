package br.edu.school.future.domain.dto.request;

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
public class StructureRequest {
    private String curricularStructure;
    private List<Subjects> subjects;
}



