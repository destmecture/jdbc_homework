import java.sql.*;

public class Application {
    public static void main(String[] args) throws SQLException {

        final String user = "postgres";
        final String password = "kxudlprd";
        final String url = "jdbc:postgresql://localhost:5432/skypro";

        try(final Connection connection =
                    DriverManager.getConnection(url, user, password);
            PreparedStatement statement =
                    connection.prepareStatement("SELECT * FROM employee")){

            final ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                String name = resultSet.getString("first_name");
                String surname = resultSet.getString("last_name");
                String gender = resultSet.getString("gender");
                int age = resultSet.getInt("age");
                int id = resultSet.getInt("id");

                System.out.println("ID = "+id);
                System.out.println("Name = "+name);
                System.out.println("Surname = "+surname);
                System.out.println("Gender = "+gender);
                System.out.println("Age = "+age);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        City moscow = new City(1, "Moscow");
        Employee employee1 = new Employee(7,"Evgeniy", "Evgeniev", "male", 44, moscow);



    }
}
