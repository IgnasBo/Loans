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
        //You are calling "compareTo" twice for "price" and "enginePower" and getting same result. Hmm, I don't know, maybe you
        // could save result of a first call and re-use it later? :)
        //"this" keyword is not needed. Here is a good explanation when you should use "this" - https://stackoverflow.com/questions/2411270/when-should-i-use-this-in-a-class
        if (compareTo.getPrice().compareTo(this.getPrice()) != 0) {
            return compareTo.getPrice().compareTo(this.getPrice());
        }
        //"Float.compare(...)" - good job!
        if (Float.compare(compareTo.enginePower, this.enginePower) != 0) {
            return Float.compare(compareTo.enginePower, this.enginePower);
        }
        return this.getInterestRate().compareTo(compareTo.getInterestRate());
    }
}
