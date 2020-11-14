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
            // NEED TO FIX DATE BUG
            long millis=System.currentTimeMillis();
            java.sql.Date date=new java.sql.Date(millis);
            ArrayList<Ride> listRide= msql.getRideList();
            ArrayList<Person> listPerson = msql.getPersonList();
            HashMap<java.sql.Date,ArrayList<RideAgenda>>agenda = msql.getAgenda();



            System.out.println("------------------------------");
            if(controller.db_addRide("TowerOfLove",120,7.2))
                System.out.println("CA MARCHE0");
            if(controller.db_addAgenda("TowerOfLove",date,7.2))
                System.out.println("CA MARCHE1");

            if(controller.db_UpdateRidePrice("TowerOfLove",date,20))
                System.out.println("CA MARCHE2");

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
