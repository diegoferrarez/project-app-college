package br.edu.school.future.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfoSubjects {

    private int workload;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> note;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String media;
}
