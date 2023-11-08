package br.edu.school.future.service;

import br.edu.school.future.domain.FinanceStudents;

public interface FinanceService {

    FinanceStudents createFinancialStatement(FinanceStudents students);

    Object getByNumberRegistration(String NumberRegistration);

    Object changeValueMensality(String NumberRegistration, FinanceStudents students);
}
