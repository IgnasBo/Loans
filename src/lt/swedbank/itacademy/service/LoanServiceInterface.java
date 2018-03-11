package lt.swedbank.itacademy.service;

import lt.swedbank.itacademy.domain.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface LoanServiceInterface {

    List<Loan> getHighRiskLoans();

    BigDecimal calculateAverageLoanCost();

    BigDecimal calculateAverageLoanCost(LoanRiskType riskType);

    BigDecimal getMaximumPriceOfNonExpiredLoans();

    Map<LoanRiskType, List<Loan>> groupLoansByRiskType();

    Set<String> findVehicleModels();

    List<VehicleLoan> getNormalRiskVehicleLoans();

    int getMaximumAgeOfLowRiskLoanedVehicles();

    List<VehicleLoan> getExpiredHighRiskVehicleLoansOfHighestDuration();

    List<Loan> getPersonalRealEstateLoans();

    List<HarvesterLoan> getLowRiskHarvesterLoans();

    List<Loan> getExpiredLandLoansInReservation();

    List<VehicleLoan> getLoansOfHigherThanAverageDepreciation();
}
