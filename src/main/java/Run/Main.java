package Run;

import Controller.*;
import Model.ModelSQL;
import View.Login;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        final String url = "jdbc:mysql://mysql-v4resk.alwaysdata.net:3306/v4resk_kidsland";
        final String passwd = "MJJ6FxqA7vWpQxx";
        final String user = "v4resk_user";
    //MJJ6FxqA7vWpQxx

        try {
            Connection conn = DriverManager.getConnection(url,user,passwd);
            ModelSQL msql = new ModelSQL(conn);
            Controller controller = new Controller(msql);
            new Login(controller);
        }
        catch(SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());

        }
    }
}
