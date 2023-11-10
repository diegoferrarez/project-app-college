package br.edu.school.future.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FinancePlan {
    private BigDecimal valueTotal;
    private BigDecimal discount;
    private BigDecimal valueMensality;

}
