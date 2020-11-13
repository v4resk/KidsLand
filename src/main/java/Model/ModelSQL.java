package Model;

//IMPORT
import Controller.Employee;
import Controller.Member;
import Controller.Person;
import Controller.Ride;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

// The ModelSQL class manages data of our application.
// She tak raw information in the data base and convert them in exploitable data for our application
public class ModelSQL {

    // VARIABLES
    private ArrayList<Ride> rideList;
    private ArrayList<Person> personList;
    private Statement stmt;

    public ModelSQL(Connection conn) {
        //INIT ARRAY
        rideList = new ArrayList<Ride>();
        personList = new ArrayList<Person>();

        //SELECT AND ORGANISE DATA FROM DATABASE
        try {
            stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM ride");
            while (res.next()) {
                rideList.add(new Ride(res.getString(1), res.getInt(2), res.getInt(3), res.getFloat(4)));
            }
            res = stmt.executeQuery("SELECT * FROM person");
            while (res.next()) {
                if (res.getBoolean(6))
                    personList.add(new Employee(res.getString(1), res.getString(2), res.getDate(3), res.getString(4)));
                else
                    personList.add(new Member(res.getString(1), res.getString(2), res.getDate(3), res.getString(4)));
            }

        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }

    }
    //----------------------------Get--------------------------------------------------------------------
    public ArrayList<Person> getPersonList() {
        return personList;
    }

    public ArrayList<Ride> getRideList() {
        return rideList;
    }
    //------------------------------------------------------------------------------------------------------

    //------------------------------EXECUTE QUERRY/UPDATE---------------------------------------------------

    //ADD NEW MEMBER
    public void db_AddMember(String fisrtName, String name, java.sql.Date age, String email,String passwd) {

        personList.add(new Member(name,fisrtName,age,email));
        String query = "INSERT INTO person "+
                        "(name,firstName,date_naissance,email,mdp,employBool) VALUES"
                        + "("
                        + "'"+ name +"'"+","
                        +"'"+ fisrtName +"'"+","
                        +"'"+age +"'"+","
                        +"'"+email +"'"+","
                        +"'"+passwd+"'"+","
                        +"'"+"0"+"'"
                        +   ")";
        try {
            stmt.executeUpdate(query);
        }
        catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }

    }

    //ADD NEW RIDE
    public void db_addRide(String name,int nbrPlace,int nbrPlaceUsed,float price){
        rideList.add(new Ride(name, nbrPlace, nbrPlaceUsed, price));
        String query ="INSERT INTO ride "+
                "(name,placeNbr,placeNbrUse,price) VALUES"
                + "("
                + "'"+ name +"'"+","
                +"'"+ nbrPlace +"'"+","
                +"'"+nbrPlaceUsed +"'"+","
                +"'"+price +"'"+","
                +   ")";
        try {
            stmt.executeUpdate(query);
        }
        catch (SQLException e) {
        System.out.println("SQLException: " + e.getMessage());
        System.out.println("SQLState: " + e.getSQLState());
        System.out.println("VendorError: " + e.getErrorCode());
    }


    }

//---------------------------------------------------------------------------------------------------------




}
