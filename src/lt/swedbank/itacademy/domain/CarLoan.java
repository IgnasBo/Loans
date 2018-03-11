package lt.swedbank.itacademy.domain;

public class CarLoan extends VehicleLoan implements Comparable<CarLoan> {

    private float enginePower;

    public float getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(float enginePower) {
        this.enginePower = enginePower;
    }

    public int compareTo(CarLoan compareTo) {
        if (compareTo.getPrice().compareTo(this.getPrice()) != 0) {
            return compareTo.getPrice().compareTo(this.getPrice());
        }
        if (Float.compare(compareTo.enginePower, this.enginePower) != 0) {
            return Float.compare(compareTo.enginePower, this.enginePower);
        }
        return this.getInterestRate().compareTo(compareTo.getInterestRate());
    }
}
