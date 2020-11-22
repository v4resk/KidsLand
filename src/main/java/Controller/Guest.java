package Controller;

import java.sql.Date;

public class Guest extends Person {

public Guest(){
    super(null,null,null,null);
}

    @Override
    public boolean bookARide(Date date, RideAgenda ride, int nbrOfTickets, String reduction) {
        if(controller==null)
            return false;
        if(!controller.canIBook(nbrOfTickets,date,ride))
            return false;
        return controller.bookARide(date,ride.getRide().getName(),email,ride.getPrice(),nbrOfTickets,"Normal");
    }
}
