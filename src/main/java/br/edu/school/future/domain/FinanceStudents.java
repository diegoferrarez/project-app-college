package br.edu.school.future.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "financeStudent")
public class FinanceStudents {

    @Id
    private String id;
    private String numberRegistration;
    private FinancePlan value;
}

