package lt.swedbank.itacademy.util;

import lt.swedbank.itacademy.domain.Loan;
import lt.swedbank.itacademy.domain.LoanRiskType;

import java.math.BigDecimal;
import java.util.Comparator;

public class LoanComparator implements Comparator<Loan> {
    @Override
    public int compare(Loan o1, Loan o2) {
        if (calcRiskType(o1.getRiskType()).compareTo(calcRiskType(o2.getRiskType())) != 0) {
            return calcRiskType(o1.getRiskType()).compareTo(calcRiskType(o2.getRiskType()));
        }

        if ((o2.calculateTotalLoanCost()).compareTo((o1.calculateTotalLoanCost())) != 0) {
            return (o2.calculateTotalLoanCost()).compareTo((o1.calculateTotalLoanCost()));
        }

        return o1.getCreationDate().compareTo(o2.getCreationDate());
    }

    private Integer calcRiskType(LoanRiskType riskType) {
        switch (riskType) {
            case LOW_RISK:
                return 3;
            case HIGH_RISK:
                return 1;
            case NORMAL_RISK:
                return 2;
            default:
                return 0;
        }
    }
}
