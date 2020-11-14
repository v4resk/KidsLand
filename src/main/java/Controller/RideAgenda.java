package Controller;

public class RideAgenda {

    private Ride ride;
    private int placeNbrUsed;
    private double price;

    public RideAgenda(Ride ride, int placeNbrUsed,double price){
        this.ride = ride;
        this.placeNbrUsed = placeNbrUsed;
        this.price = price;
    }

    public int getPlaceNbrUsed() {
        return placeNbrUsed;
    }
    public Ride getRide() {
        return ride;
    }
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
