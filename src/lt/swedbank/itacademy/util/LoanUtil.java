package lt.swedbank.itacademy.util;

import lt.swedbank.itacademy.domain.VehicleLoan;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

public class LoanUtil {
    public static BigDecimal calculateVehicleDepreciation(VehicleLoan vehicleLoan) {
        BigDecimal vehicleDepreciation = vehicleLoan.getPrice().multiply((calculateYearsInUse(vehicleLoan.getManufactured()).divide(BigDecimal.valueOf(vehicleLoan.getMaximumAge()), 5, RoundingMode.HALF_UP) ));
        if (vehicleDepreciation.compareTo(vehicleLoan.getPrice()) > 0) {
            return vehicleLoan.getPrice();
        } else {
            return vehicleDepreciation;
        }
    }

    private static BigDecimal calculateYearsInUse(Date manufactured){
        return BigDecimal.valueOf(DateUtil.differenceInDays(new Date(), manufactured)/365);
    }
}
