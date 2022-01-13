package register_servlet;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerDAO {

    public int registerCustomer(Customer customer) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO employee" +
            "  (NAME, EMAIL,CONFIRM_EMAIL, PASSWORD, CONFIRM_PASSWORD) VALUES " +
            " (?, ?, ?, ?,?,?);";

        int result = 0;

        Class.forName("com.mysql.cj.jdbc.Driver");

        //Step 1: Established the connection with database
      try (Connection connection = DriverManager
     .getConnection("jdbc:mysql://localhost:3306/registrationform?useSSL=false", "root", "MYSQL PASSWORD");

        // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement =  connection.prepareStatement(INSERT_USERS_SQL)) {      
    	    preparedStatement.setString(1,customer.getName());
            preparedStatement.setString(3,customer.getEmail());
            preparedStatement.setString(4,customer.getConfirmEmail());
            preparedStatement.setString(5, customer.getPassword());
            preparedStatement.setString(6, customer.getConfirmPassword());

        // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
