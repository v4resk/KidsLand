package Model;

//IMPORT
import Controller.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

//A FAIR : Add Time in constructor; (new classes / Agenda)
//         Add functionality to add and remove availability of Ride in Time table;


// The ModelSQL class manages data of our application.
// She tak raw information in the data base and convert them in exploitable data for our application
public class ModelSQL {

    // VARIABLES
    private final ArrayList<Ride> rideList;
    private final ArrayList<Person> personList;
    private final HashMap<java.sql.Date,ArrayList<RideAgenda>> agenda;
    private Statement stmt;

    public ModelSQL(Connection conn) {
        //INIT ARRAY
        rideList = new ArrayList<Ride>();
        personList = new ArrayList<Person>();
        agenda = new HashMap<Date, ArrayList<RideAgenda>>();

        //SELECT AND ORGANISE DATA FROM DATABASE
        try {
            // TAKE PERSON TABLE
            stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM Ride");
            while (res.next()) {
                rideList.add(new Ride(res.getString(1), res.getInt(2), res.getDouble(3)));
            }
            //TAKE LIST OF RIDE AVAILABLE
            res = stmt.executeQuery("SELECT * FROM Person");
            while (res.next()) {
                if (res.getBoolean(6))
                    personList.add(new Employee(res.getString(1), res.getString(2), res.getDate(3), res.getString(4)));
                else
                    personList.add(new Member(res.getString(1), res.getString(2), res.getDate(3), res.getString(4)));
            }

            //CONSTRUCTION OF AGENDA
            res = stmt.executeQuery("SELECT * FROM Time");
            while (res.next()){
                
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

    //------------------------------EXECUTE QUERY/UPDATE---------------------------------------------------

    //ADD NEW MEMBER
    public void db_AddMember(String firstName, String name, java.sql.Date age, String email,String passwd) {

        personList.add(new Member(name,firstName,age,email));
        String query = "INSERT INTO Person "+
                        "(name,firstName,date_naissance,email,mdp,employBool) VALUES"
                        + "("
                        + "'"+ name +"'"+","
                        +"'"+ firstName +"'"+","
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

    public void db_DeleteMember(String email){
        for(int i=0; i<personList.size();i++){
            if(email.equals(personList.get(i).getEmail())){
                personList.remove(i);
                break;
            }
        }
        String query = "DELETE FROM Person " +
                "WHERE email = " + "'"+email+"'";
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
    public void db_addRide(String name,int nbrPlace,double price){
        rideList.add(new Ride(name, nbrPlace, price));
        String query ="INSERT INTO Ride "+
                "(name,placeNbr,price) VALUES"
                + "("
                + "'"+ name +"'"+","
                +"'"+ nbrPlace +"'"+","
                +"'"+price +"'"
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

    public void db_DeleteRide(String name){
        for(int i=0; i<rideList.size();i++){
            if(name.equals(rideList.get(i).getName())){
                rideList.remove(i);
                break;
            }
        }
        String query1 = "DELETE FROM Time " +
                "WHERE name = " + "'"+name+"'";
        String query2 = "DELETE FROM Ride " +
                "WHERE name = " + "'"+name+"'";
        try {
            stmt.executeUpdate(query1);
            stmt.executeUpdate(query2);
        }
        catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());

        }
    }
//---------------------------------------------------------------------------------------------------------




}
