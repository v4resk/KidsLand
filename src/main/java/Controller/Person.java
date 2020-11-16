package Controller;


public abstract class Person {
    protected String firstName;
    protected String name;
    protected java.sql.Date age;
    protected int age_int;
    protected String email;
    protected Controller controller;

    public Person(String name, String firstName, java.sql.Date age,String email){
        this.name = name;
        this.firstName = firstName;
        this.age = age;
        this.email = email;
        controller = null;
    }
//------------------------------SET/GET------------------------------------------------------------------------
    public String getEmail() {
        return email;
    }
    public String getName() {
        return name;
    }
    // Need to set a controller if you want to interact with DB/ BOOK tickets....
    public void setController(Controller controller){this.controller = controller; }
//----------------------------------------------------------------------------------------------------------
    public boolean bookARide(java.sql.Date date, RideAgenda ride,int nbrOfTickets){
        if(controller==null)
            return false;
        if(!controller.canIBook(nbrOfTickets,date,ride))
            return false;
        return controller.bookARide(date,ride.getRide().getName(),email,ride.getPrice()*this.calculateDiscount(),nbrOfTickets);
    }

    public abstract double calculateDiscount();

}
