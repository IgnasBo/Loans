package lt.swedbank.itacademy.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class RealEstateLoan extends Loan {
    private float area;
    private String district;
    private RealEstatePurpose purpose;

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public RealEstatePurpose getPurpose() {
        return purpose;
    }

    public void setPurpose(RealEstatePurpose purpose) {
        this.purpose = purpose;
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
//        RealEstateLoan o = (RealEstateLoan) obj;
//        return super.equals(o) &&
//                Objects.equals(area, o.area) &&
//                Objects.equals(district, o.district) &&
//                Objects.equals(purpose, o.purpose);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(super.hashCode(), area, district, purpose);
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RealEstateLoan)) return false;
        if (!super.equals(o)) return false;
        RealEstateLoan that = (RealEstateLoan) o;
        return Float.compare(that.area, area) == 0 &&
                Objects.equals(district, that.district) &&
                purpose == that.purpose;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), area, district, purpose);
    }
}
