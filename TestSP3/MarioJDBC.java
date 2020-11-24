import java.sql.*;
import java.util.ArrayList;

public class MarioJDBC {

    private Connection conn;
    String JdbcUrl = "jdbc:mysql://localhost/MariosPizza?" + "autoReconnect=true&useSSL=false";
    String username = "root";
    String password = "Cervelo2011";

    public MarioJDBC() {
        createConnection();
    }

    public void createConnection() {
        try {
            conn = DriverManager.getConnection(JdbcUrl, username, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ArrayList<Pizza> getMenuFromDB() {
        // TODO: have a look at preparedStatements!
        ArrayList<Pizza> tmp = new ArrayList<Pizza>();



        try {
            if(!conn.isValid(1))
            {
                System.out.println("No connection found");
                createConnection();
            }
            System.out.println("Am I here?");
            Statement stm;
            stm = conn.createStatement();
            System.out.println("Statement created");
            String sql = "select * from MariosPizza.Pizza";

            ResultSet resultSet;

            resultSet = stm.executeQuery(sql);

            while (resultSet.next()) {
                System.out.println("resultSet had next!");
                Pizza pizza = new Pizza(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("Topping"),
                        resultSet.getInt("Price")
                );

                tmp.add(pizza);
            }
            System.out.println("No more entries in resultSet");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return tmp;
    }


//
//        Connection

//


    // insertOrder

}
