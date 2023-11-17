package br.edu.school.future.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "subjects")
public class Subjects {

    private String idSubject;
    private String nameSubject;
    private int workload;
}
