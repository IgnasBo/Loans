package lt.swedbank.itacademy.service;

import lt.swedbank.itacademy.domain.Loan;
import lt.swedbank.itacademy.domain.LoanRiskType;
import lt.swedbank.itacademy.domain.VehicleLoan;
import lt.swedbank.itacademy.util.LoanComparator;

import java.math.BigDecimal;
import java.util.*;

public class LoanService {

    private Loan[] loans;
    private BigDecimal averageLoanCost;
    private List<Loan> highRiskLoans;

    public LoanService(Loan[] loans) {
        this.loans = loans;
    }

    public Map<LoanRiskType, List<Loan>> groupLoansByRiskType() {
        Map<LoanRiskType, List<Loan>> loansGroupedByRiskType = new HashMap<>();
        for (LoanRiskType riskType : LoanRiskType.values()) {
            loansGroupedByRiskType.put(riskType, findRiskLoans(riskType));
        }
        return loansGroupedByRiskType;
    }

    public Set<String> findVehicleModels() {
        Set<String> vehicleModels = new HashSet<>();
        for (Loan vehicleLoan : loans) {
            if (vehicleLoan instanceof VehicleLoan) {
                vehicleModels.add(((VehicleLoan) vehicleLoan).getModel());
            }
        }
        return vehicleModels;
    }

    public List<Loan> findHighRiskLoans() {
        List<Loan> highRiskLoans = new ArrayList<>();
        for (Loan loan : loans) {
            if (loan.getRiskType().equals(LoanRiskType.HIGH_RISK)) {
                highRiskLoans.add(loan);
            }
        }
        return highRiskLoans;
    }

    private List<Loan> findRiskLoans(LoanRiskType riskType) {
        List<Loan> highRiskLoans = new ArrayList<>();
        for (Loan loan : loans) {
            if (loan.getRiskType().equals(riskType)) {
                highRiskLoans.add(loan);
            }
        }
        return highRiskLoans;
    }

    public BigDecimal calculateAverageLoanCost() {
        BigDecimal loanSum = new BigDecimal("0");
        for (Loan loan : loans) {
            loanSum = loanSum.add(loan.getPrice().multiply(loan.getInterestRate().divide(new BigDecimal("100")).add(new BigDecimal("1"))));
        }
        return loanSum.divide(BigDecimal.valueOf(loans.length));
    }

    public BigDecimal calculateAverageLoanCost(LoanRiskType riskType) {
        BigDecimal loanSum = new BigDecimal("0");
        int count = 0;
        for (Loan loan : loans) {
            if (loan.getRiskType().equals(riskType)) {
                loanSum = loanSum.add(loan.getPrice().multiply(loan.getInterestRate().divide(new BigDecimal("100")).add(new BigDecimal("1"))));
                count++;
            }
        }
        return loanSum.divide(BigDecimal.valueOf(count));
    }

    public BigDecimal getMaximumPriceOfNonExpiredLoans() {
        BigDecimal maxLoan = BigDecimal.ZERO;
        for (Loan loan : loans) {
            if (loan.isValid() && loan.getPrice().compareTo(maxLoan) > 0) {
                maxLoan = loan.getPrice();
            }
        }
        return maxLoan;
    }

    public List<Loan> getHighRiskLoans() {
        return highRiskLoans;
    }

    public void setHighRiskLoans(List<Loan> highRiskLoans) {
        this.highRiskLoans = highRiskLoans;
    }

    public BigDecimal getAverageLoanCost() {
        return averageLoanCost;
    }

    public void setAverageLoanCost(BigDecimal averageLoanCost) {
        this.averageLoanCost = averageLoanCost;
    }

    public Set<Loan> prioritizeLoans() {
        List<Loan> prioritizedLoans = new ArrayList<>(Arrays.asList(loans));
        Collections.sort(prioritizedLoans, new LoanComparator());
        Set<Loan> sortedLoans = new HashSet<>();
        sortedLoans.addAll(prioritizedLoans);
        return sortedLoans;
        }
}
