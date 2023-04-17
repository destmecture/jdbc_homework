import java.sql.*;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        City podolsk = new City(4,"Podolsk");
        City kaluga = new City(120,"Kaluga");
        City kaluga2 = new City(120,"Kaluga2349999955");

        CityDaoImpl cityDao = new CityDaoImpl();

        //int idd = cityDao.addCity(kaluga2);
        //System.out.println(idd);
        //System.out.println(kaluga2.getId());
        Employee vladimir = new Employee(1, "_Vladimir222", "Kuzmichev222", "male", 35, kaluga2);
        Employee dmitriy = new Employee(2, "_Dmitriy", "Antonov", "male", 23, kaluga2);
        Employee ilya = new Employee(3, "_Ilya", "Sergeev", "male", 27, kaluga2);
        kaluga2.setEmployees(List.of(vladimir,dmitriy,ilya));

        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();

        //cityDao.addCity(kaluga2);

        //cityDao.updateCity(kaluga2.getId(), kaluga2);

    }
}
