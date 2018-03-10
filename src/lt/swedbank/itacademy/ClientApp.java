package lt.swedbank.itacademy;


import lt.swedbank.itacademy.domain.DomainInitializer;
import lt.swedbank.itacademy.domain.Loan;
import lt.swedbank.itacademy.domain.LoanRiskType;
import lt.swedbank.itacademy.domain.Task1DomainInitializer;
import lt.swedbank.itacademy.service.LoanService;

import java.math.BigDecimal;
import java.util.List;

public class ClientApp {

    public static void main(String[] args) {

        Loan[] loans = getInitializer().initializeLoans();
        LoanService service = new LoanService(loans);

        List<Loan> highRiskLoans = service.findHighRiskLoans();
        service.setHighRiskLoans(highRiskLoans);
        System.out.println("Number of high risk loans:");
        System.out.println("There are " + service.getHighRiskLoans().size());

        BigDecimal averageLoanCost = service.calculateAverageLoanCost();
        service.setAverageLoanCost(averageLoanCost);
        System.out.println("Average Loan Cost: ");
        System.out.println(service.getAverageLoanCost());

        System.out.println("Average Loan Cost(LoanRiskType): ");
        averageLoanCost = service.calculateAverageLoanCost(LoanRiskType.HIGH_RISK);
        service.setAverageLoanCost(averageLoanCost);
        System.out.println("High Risk: " + service.getAverageLoanCost());
        averageLoanCost = service.calculateAverageLoanCost(LoanRiskType.NORMAL_RISK);
        service.setAverageLoanCost(averageLoanCost);
        System.out.println("Normal Risk: " + service.getAverageLoanCost());
        averageLoanCost = service.calculateAverageLoanCost(LoanRiskType.LOW_RISK);
        service.setAverageLoanCost(averageLoanCost);
        System.out.println("Low Risk: " + service.getAverageLoanCost());

        System.out.println("Maximum Non Expired Loan: " + service.getMaximumPriceOfNonExpiredLoans());


    }


    public static DomainInitializer getInitializer() {
        return new Task1DomainInitializer();
    }

}
