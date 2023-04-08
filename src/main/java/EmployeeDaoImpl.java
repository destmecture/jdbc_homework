import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDAO{

    final String user = "postgres";
    final String password = "kxudlprd";
    final String url = "jdbc:postgresql://localhost:5432/skypro";

    @Override
    public void addEmployee(Employee employee) {
        try(final Connection connection =
                        DriverManager.getConnection(url, user, password);
                PreparedStatement statement =
                        connection.prepareStatement("INSERT INTO employee ( first_name, last_name, gender, age, city_id) " +
                                "VALUES ( (?), (?), (?), (?), (?))"))
        {
            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            statement.setString(3, employee.getGender());
            statement.setInt(4, employee.getAge());
            statement.setInt(5, employee.getCity().getId());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Employee was added");
    }

    @Override
    public Employee getEmployeeById(int id) {
        Employee employee = new Employee();


        try(final Connection connection =
                    DriverManager.getConnection(url, user, password);
            PreparedStatement statement =
                    connection.prepareStatement("SELECT * FROM employee INNER JOIN city ON employee.city_id = " +
                            "city.city_id WHERE id = (?)"))
        {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                employee.setId(resultSet.getInt("id"));
                employee.setFirstName(resultSet.getString("first_name"));
                employee.setLastName(resultSet.getString("last_name"));
                employee.setGender(resultSet.getString("gender"));
                employee.setAge(resultSet.getInt("age"));
                employee.setCity(new City(resultSet.getInt("city_id"), resultSet.getString("city_name")));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> empl = new ArrayList<>();
        try(final Connection connection =
                    DriverManager.getConnection(url, user, password);
            PreparedStatement statement =
                    connection.prepareStatement("SELECT * FROM employee INNER JOIN city ON employee.city_id = " +
                            "city.city_id"))
        {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String gender = resultSet.getString("gender");
                int age = resultSet.getInt("age");
                City city = new City(resultSet.getInt("city_id"), resultSet.getString("city_name"));
                empl.add(new Employee(id, firstName,lastName, gender, age, city));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empl;
    }

    @Override
    public void updateEmployee(int id, Employee employee) {
        try(final Connection connection =
                    DriverManager.getConnection(url, user, password);
            PreparedStatement statement =
                    connection.prepareStatement("UPDATE employee SET first_name = (?), last_name = (?), " +
                            "gender = (?), age = (?), city_id = (?) WHERE id = (?)"))
        {
            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            statement.setString(3, employee.getGender());
            statement.setInt(4, employee.getAge());
            statement.setInt(5, employee.getCity().getId());
            statement.setInt(6, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Employee was updated");
    }

    @Override
    public void deleteEmployee(int id) {
        try(final Connection connection =
                    DriverManager.getConnection(url, user, password);
            PreparedStatement statement =
                    connection.prepareStatement("DELETE FROM employee WHERE id = (?)"))
        {
            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Employee was deleted");

    }
}
