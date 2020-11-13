package Run;

import Controller.Controller;
import Controller.Ride;
import Model.ModelSQL;
import Controller.Person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        final String url = "jdbc:mysql://localhost:3306/kidsLand";
        final String pswd = "root";
        final String user = "v4resk";
        try {
            Connection conn = DriverManager.getConnection(url,user,pswd);
            ModelSQL msql = new ModelSQL(conn);
            Controller controller = new Controller(msql);

            //------------TEST---------------------------------
            long millis=System.currentTimeMillis();
            java.sql.Date date=new java.sql.Date(millis);
            ArrayList<Person> listRide= msql.getPersonList();
            if(controller.db_addMember("Jean","Dupont",date,"john22.macdo1@hotmail.com","Azerty"))
                System.out.println("Succes Add");
            else
                System.out.println("email is not unic");

            for (int i = 0; i < listRide.size(); i++) {
                System.out.println(listRide.get(i).getEmail());
                System.out.println(listRide.get(i).getName());
            }
            //-------------END OF TEST----------------------------
        }
        catch(SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());

        }
    }
}
