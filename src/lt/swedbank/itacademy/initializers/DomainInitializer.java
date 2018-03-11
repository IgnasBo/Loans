package lt.swedbank.itacademy.initializers;

import lt.swedbank.itacademy.domain.Loan;

public interface DomainInitializer {

    Loan[] initializeLoans();

}
