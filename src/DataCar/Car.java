package DataCar;

import java.io.Serializable;

public class Car implements Serializable {
    private String CarReg;
    private int YearMade;
    private String colour1;
    private String colour2;
    private String colour3;
    private String CarMake;
    private String CarModel;
    private int carCount;
    private int Price;

    public Car(String CarReg, int YearMade, String colour1, String colour2, String colour3, String CarMake, String CarModel, int Price, int carCount) {
        this.CarReg = CarReg;
        this.YearMade = YearMade;
        this.colour1 = colour1;
        this.colour2 = colour2;
        this.colour3 = colour3;
        this.CarMake = CarMake;
        this.CarModel = CarModel;
        this.Price = Price;
        this.carCount= carCount;
    }

    public String getCarReg() {

        return CarReg;
    }

    public void setCarReg(String CarReg) {
        this.CarReg = CarReg;
    }

    public int getYearMade() {
        return YearMade;
    }

    public void setYearMade(int YearMade) {
        this.YearMade = YearMade;
    }

    public String getColour1() {
        return colour1;
    }

    public void setColour1(String colour1) {
        this.colour1 = colour1;
    }

    public String getColour2() {
        return colour2;
    }

    public void setColour2(String colour2) {
        this.colour2 = colour2;
    }

    public String getColour3() {
        return colour3;
    }

    public void setColour3(String colour3) {
        this.colour3 = colour3;
    }

    public String getCarMake() {
        return CarMake;
    }

    public void setCarMake(String carMake) {
        this.CarMake = carMake;
    }

    public String getCarModel() {
        return CarModel;
    }

    public void setCarModel(String carModel) {
        this.CarModel = carModel;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }
    public int getCarCount()
    {
        return carCount;
    }
    public void setCarCount(int carCount)
    {
        this.carCount= carCount;
    }

    @Override
    public String toString() {
        return CarReg + "," + YearMade + "," + colour1 + "," + colour2 + "," +
                colour3 + "," + CarMake + "," + CarModel + "," + Price + ","+ carCount;
    }
}

