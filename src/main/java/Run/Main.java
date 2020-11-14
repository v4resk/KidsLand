package Run;

import Controller.Controller;
import Controller.Ride;
import Model.ModelSQL;
import Controller.Person;
import Controller.RideAgenda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        final String url = "jdbc:mysql://localhost:3306/kidsLand";
        final String passwd = "root";
        final String user = "v4resk";
        try {
            Connection conn = DriverManager.getConnection(url,user,passwd);
            ModelSQL msql = new ModelSQL(conn);
            Controller controller = new Controller(msql);

            //------------TEST---------------------------------
            long millis=System.currentTimeMillis();
            java.sql.Date date=new java.sql.Date(millis);
            ArrayList<Ride> listRide= msql.getRideList();
            ArrayList<Person> listPerson = msql.getPersonList();
            HashMap<java.sql.Date,ArrayList<RideAgenda>>agenda = msql.getAgenda();

            controller.db_addRide("LocaFola",120,11);
            for (int i = 0; i < listRide.size(); i++) {
                System.out.println(listRide.get(i).getName());

            }
            controller.db_DeleteRide("LocaFola");
            for (int i = 0; i < listRide.size(); i++) {
                System.out.println(listRide.get(i).getName());

            }

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
