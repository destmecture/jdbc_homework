import java.sql.*;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        City podolsk = new City("Podolsk");
        City kaluga = new City("Kaluga");
        City kaluga2 = new City("Kaluga23955");

        CityDaoImpl cityDao = new CityDaoImpl();

        //int idd = cityDao.addCity(kaluga2);
        //System.out.println(idd);
        //System.out.println(kaluga2.getId());
        Employee vladimir = new Employee("_Vladimir222", "Kuzmichev222", "male", 35, kaluga2);
        Employee dmitriy = new Employee("_Dmitriy", "Antonov", "male", 23, kaluga2);
        Employee ilya = new Employee("_Ilya", "Sergeev", "male", 27, kaluga2);
        kaluga2.setEmployees(List.of(vladimir,dmitriy,ilya));

        //EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();

        cityDao.addCity(kaluga2);




        //cityDao.updateCity(kaluga2.getId(), kaluga2);

    }
}
