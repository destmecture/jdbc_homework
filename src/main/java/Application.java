import java.sql.*;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        City podolsk = new City(5, "Podolsk");
        CityDaoImpl cityDao = new CityDaoImpl();
        Employee vladimir = new Employee(1, "Vladimir", "Kuzmichev", "male", 35, podolsk.getId());
        Employee dmitriy = new Employee(2, "Dmitriy", "Antonov", "male", 23, podolsk.getId());
        Employee ilya = new Employee(3, "Ilya", "Sergeev", "male", 27, podolsk.getId());

        podolsk.setEmployees(List.of(vladimir,dmitriy,ilya));
        cityDao.addCity(podolsk);
    }
}
