package lt.swedbank.itacademy;


import lt.swedbank.itacademy.domain.*;
import lt.swedbank.itacademy.initializers.DomainInitializer;
import lt.swedbank.itacademy.initializers.Task1DomainInitializer;
import lt.swedbank.itacademy.initializers.Task2DomainInitializer;
import lt.swedbank.itacademy.initializers.Task3DomainInitializer;
import lt.swedbank.itacademy.service.LoanService;
import lt.swedbank.itacademy.tasktests.*;

public class ClientApp {

    public static void main(String[] args) {

        //Day 3 Tasks:
        System.out.println("\n***DAY 3 TASKS***");
        runTask1();
        runTask2();
        runTask3();

        //Day 4 Tasks:

        System.out.println("\n***DAY 4 TASKS***");
        Task2Test.task2Test();
        Task3Test.task3Test();
        Task4Test.task4Test();
        Task5Test.task5Test();
        Task6Test.task6Test();

    }

    private static void runTask1() {
        LoanService service = new LoanService(getInitializer(1).initializeLoans());
        System.out.println("\nTASK 1");
        System.out.println("\nNumber of high risk loans:");
        System.out.println("There are " + service.getHighRiskLoans().size());

        System.out.println("\nAverage Loan Cost: ");
        System.out.println(service.calculateAverageLoanCost());

        System.out.println("\nAverage Loan Cost(LoanRiskType): ");
        System.out.println("High Risk: " + service.calculateAverageLoanCost(LoanRiskType.HIGH_RISK));
        System.out.println("Normal Risk: " + service.calculateAverageLoanCost(LoanRiskType.NORMAL_RISK));
        System.out.println("Low Risk: " + service.calculateAverageLoanCost(LoanRiskType.LOW_RISK));

        System.out.println("\nAverage cost of high risk loans: " + service.calculateAverageLoanCost(LoanRiskType.HIGH_RISK));

        System.out.println("\nMaximum Non Expired Loan: " + service.getMaximumPriceOfNonExpiredLoans());

    }

    private static void runTask2() {
        LoanService service = new LoanService(getInitializer(2).initializeLoans());

        System.out.println("\nTASK 2");
        System.out.println("\nGet Normal Risk Vehicle Loans: ");
        System.out.println("There are " + service.getNormalRiskVehicleLoans().size());

        System.out.println("\nGet maximum age of low risk loaned vehicles: ");
        System.out.println(service.getMaximumAgeOfLowRiskLoanedVehicles());

        System.out.println("\nGet personal real estate loans: ");
        System.out.println("There are " + service.getPersonalRealEstateLoans().size());

        System.out.println("\nGet expired high risk vehicles loans of highest duration: ");
        System.out.print("There is " + service.getExpiredHighRiskVehicleLoansOfHighestDuration().size());
        if (!service.getExpiredHighRiskVehicleLoansOfHighestDuration().isEmpty()) {
            System.out.println(", and highest duration is " + service.getExpiredHighRiskVehicleLoansOfHighestDuration().get(0).getTermInYears());
        }
    }

    private static void runTask3() {
        LoanService service = new LoanService(getInitializer(3).initializeLoans());

        System.out.println("\nTASK 3");
        System.out.println("\nGet low risk harvester loans: ");
        System.out.println("There are " + service.getLowRiskHarvesterLoans().size());

        System.out.println("\nGet expired land loans in reservation: ");
        System.out.println("There are " + service.getExpiredLandLoansInReservation().size());

        System.out.println("\nGet loans of higher than average depreciation:");
        System.out.println("There are " + service.getLoansOfHigherThanAverageDepreciation().size() + ", average depreciation is aprrox. " + service.calculateAverageDepreciation());
    }

    private static DomainInitializer getInitializer(int task) {
        switch (task) {
            case 1:
                return new Task1DomainInitializer();
            case 2:
                return new Task2DomainInitializer();
            default:
                return new Task3DomainInitializer();

        }
    }

}
