package Controller;

public class RideAgenda {

    private Ride ride;
    private int placeNbrUsed;

    public RideAgenda(Ride ride, int placeNbrUsed){
        this.ride = ride;
        this.placeNbrUsed = placeNbrUsed;
    }

    public int getPlaceNbrUsed() {
        return placeNbrUsed;
    }

    public Ride getRide() {
        return ride;
    }
}
