import java.sql.*;
import java.util.List;

public class Application {

    public static void main(String[] args) {


        City kaluga2 = new City("Kaluga");

        CityDaoImpl cityDao = new CityDaoImpl();
        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();

        Employee vladimir = new Employee("___1", "___1", "male", 35, kaluga2);
        Employee dmitriy = new Employee("___2", "___2", "male", 23, kaluga2);
        Employee ilya = new Employee("___3", "___3", "male", 27, kaluga2);
        kaluga2.addEmployee(vladimir);
        kaluga2.addEmployee(dmitriy);
        kaluga2.addEmployee(ilya);

        cityDao.addCity(kaluga2);

        Employee ivan = new Employee("Ivan", "Ivanovich", "male", 27, kaluga2);

        kaluga2.removeEmployee(vladimir);
        kaluga2.addEmployee(ivan);
        cityDao.updateCity(kaluga2.getId(), kaluga2);
        cityDao.deleteCity(18);

    }
}
