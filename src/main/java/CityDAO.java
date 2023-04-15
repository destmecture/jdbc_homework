import java.util.List;

public interface CityDAO {
    void addCity(City city);
    City getCityById(int id);
    List<City> getAllCity();
    void updateCity(int id, City city);
    void deleteCity(int id);
}
