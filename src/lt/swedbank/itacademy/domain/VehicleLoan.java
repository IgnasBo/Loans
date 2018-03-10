package lt.swedbank.itacademy.domain;

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

//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (this.getClass() != obj.getClass()) {
//            return false;
//        }
//        VehicleLoan o = (VehicleLoan) obj;
//        return super.equals(o) &&
//                Objects.equals(manufactured, o.manufactured) &&
//                Objects.equals(maximumAge, o.maximumAge) &&
//                Objects.equals(model, o.model);
//    }

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
