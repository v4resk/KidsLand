package Run;

//** TO-DO LIST : Gui implements back-end
//                  Add employee fonctions;



import Controller.*;

import Controller.Ride;
import Model.ModelSQL;
import Controller.Person;
import Controller.RideAgenda;
import View.Login;
import View.TimeEvaluator;
import com.toedter.calendar.JCalendar;
import java.util.Calendar;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        final String url = "jdbc:mysql://localhost:3306/kidsLand";
        final String passwd = "Alex08";
        final String user = "alex";




        try {
            Connection conn = DriverManager.getConnection(url,user,passwd);
            ModelSQL msql = new ModelSQL(conn);
            Controller controller = new Controller(msql);
           new Login(controller);

            //------------TEST---------------------------------
            
            long millis=System.currentTimeMillis();
            java.sql.Date date = Date.valueOf("2020-11-25");
            ArrayList<Ride> listRide= msql.getRideList();
            ArrayList<Person> listPerson = msql.getPersonList();
            HashMap<java.sql.Date,ArrayList<RideAgenda>>agenda = msql.getAgenda();
            Boolean boolEmployee = false;

            Employee mbr = new Employee("Thomas","Shelby",date,"Thomas.shelby@free.fr");
            mbr.setController(controller);

            controller.db_addAgenda("BoatTrip", Date.valueOf("2020-12-12"),12);

            //SignIn
            if(controller.signIn_check("Thomas.shelby@free.fr","dontfwpk")){
                System.out.println("Loged in");
                if(controller.isAnEmployee("Thomas.shelby@free.fr"))
                    System.out.println("As employee");
            }

           if(mbr.bookARide(Date.valueOf("2020-12-12"),agenda.get(Date.valueOf("2020-12-12")).get(0),10,"Normal"))
              System.out.println("booked");




            System.out.println(agenda.toString());
            //-------------END OF TEST----------------------------
        }
        catch(SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());

        }
    }
}
