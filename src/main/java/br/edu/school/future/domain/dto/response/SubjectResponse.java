package br.edu.school.future.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubjectResponse {
    private String idSubject;
    private String nameSubject;
    private int workload;
    private List<String> grade;
    private String media;
}



