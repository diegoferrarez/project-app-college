package br.edu.school.future.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Subjects implements Serializable {
    private String nameSubject;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> note;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String media;
}
