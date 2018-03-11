package lt.swedbank.itacademy.domain;

import lt.swedbank.itacademy.util.DateUtil;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class VehicleLoan extends Loan {
    private Date manufactured;
    private int maximumAge;
    private String model;

    public Date getManufactured() {
        return manufactured;
    }

    public void setManufactured(Date manufactured) {
        this.manufactured = manufactured;
    }

    public int getMaximumAge() {
        return maximumAge;
    }

    public void setMaximumAge(int maximumAge) {
        this.maximumAge = maximumAge;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getAge() {
        return (int) DateUtil.differenceInDays(new Date(), this.manufactured) / 365;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VehicleLoan)) return false;
        if (!super.equals(o)) return false;
        VehicleLoan that = (VehicleLoan) o;
        return maximumAge == that.maximumAge &&
                Objects.equals(manufactured, that.manufactured) &&
                Objects.equals(model, that.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), manufactured, maximumAge, model);
    }
}
