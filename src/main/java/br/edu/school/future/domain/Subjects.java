package br.edu.school.future.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "subjects")
public class Subjects implements Serializable {

    private String idSubject;
    private String nameSubject;
    private int workload;
    private List<String> grade;
    private String media;

}
