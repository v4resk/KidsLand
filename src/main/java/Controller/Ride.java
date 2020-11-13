package Controller;

public class Ride {
    private String name;
    private int nbrPlace;
    private int nbrPlaceUsed;
    private float price;

    public Ride(String name, int nbrPlace,int nbrPlaceUsed, float price){
        this.name = name;
        this.nbrPlace = nbrPlace;
        this.nbrPlaceUsed = nbrPlaceUsed;
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public int getNbrPlace() {
        return nbrPlace;
    }

    public String getName() {
        return name;
    }

    public int getNbrPlaceUsed() {
        return nbrPlaceUsed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNbrPlace(int nbrPlace) {
        this.nbrPlace = nbrPlace;
    }

    public void setNbrPlaceUsed(int nbrPlaceUsed) {
        this.nbrPlaceUsed = nbrPlaceUsed;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
