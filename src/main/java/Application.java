import java.sql.*;

public class Application {
    public static void main(String[] args) {

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
        Employee employee1 = new Employee(20,"Evgeniy", "Semenov", "male", 44, moscow.getId());

        EmployeeDaoImpl emp1 = new EmployeeDaoImpl();
        System.out.println("_______________");
        emp1.addEmployee(employee1);
        System.out.println("_______________");
        System.out.println(emp1.getEmployeeById(1));
        System.out.println("_______________");
        System.out.println(emp1.getAllEmployee());
        System.out.println("_______________");
        emp1.updateEmployee(4, employee1);
        System.out.println("_______________");
        //emp1.deleteEmployee(3);

    }
}
