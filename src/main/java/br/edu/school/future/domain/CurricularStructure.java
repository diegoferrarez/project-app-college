package br.edu.school.future.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "curriculum")
public class CurricularStructure {
    private String curricularStructure;
    private List<Subjects> subjects;
    private int workload;
}
