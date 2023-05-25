import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CityDaoImpl implements CityDAO{

    @Override
    public void addCity(City city) {
        int idCit;
        try(Session session = HibernateConnectUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.save(city);
            transaction.commit();
        }
        System.out.println("City was added");

    }

    @Override
    public City getCityById(int id) {

        try (Session session = HibernateConnectUtil.getSessionFactory().openSession()){
            return session.get(City.class, id);
        }
    }

    @Override
    public List<City> getAllCity() {
        try(Session session = HibernateConnectUtil.getSessionFactory().openSession()){
            return session.createQuery("FROM City").list();
        }
    }

    @Override
    public void updateCity(int id, City city) {
        try(Session session = HibernateConnectUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            city.setId(id);
            session.update(city);
            transaction.commit();
        }
        System.out.println("City was updated");
    }

    @Override
    public void deleteCity(int id) {
        try(Session session = HibernateConnectUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();;
            session.delete(getCityById(id));
            transaction.commit();
        }
        System.out.println("City was deleted");
    }
}
