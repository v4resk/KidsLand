package Controller;

public class Guest extends Person {

public Guest(){
    super(null,null,null,null);
}

    @Override
    public double calculateDiscount() {
        //no discount
        return 1;
    }
}
