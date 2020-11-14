package Controller;

public class Ride {
    private String name;
    private int nbrPlace;
    private double price;

    public Ride(String name, int nbrPlace, double price){
        this.name = name;
        this.nbrPlace = nbrPlace;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public int getNbrPlace() {
        return nbrPlace;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setNbrPlace(int nbrPlace) {
        this.nbrPlace = nbrPlace;
    }


    public void setPrice(float price) {
        this.price = price;
    }
}
