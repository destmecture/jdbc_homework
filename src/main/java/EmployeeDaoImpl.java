import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDAO{

    final String user = "postgres";
    final String password = "kxudlprd";
    final String url = "jdbc:postgresql://localhost:5432/skypro";

    @Override
    public void addEmployee(Employee employee) {

        try(Session session = HibernateConnectUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        }
        System.out.println("Employee was added");
    }

    @Override
    public Employee getEmployeeById(int id) {

        try (Session session = HibernateConnectUtil.getSessionFactory().openSession()){
            return session.get(Employee.class, id);
        }
    }

    @Override
    public List<Employee> getAllEmployee() {
        try(Session session = HibernateConnectUtil.getSessionFactory().openSession()){
            return session.createQuery("FROM Employee").list();
        }
    }

    @Override
    public void updateEmployee(int id, Employee employee) {
        try(Session session = HibernateConnectUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            employee.setId(id);
            session.update(employee);
            transaction.commit();
        }
        System.out.println("Employee was updated");
    }

    @Override
    public void deleteEmployee(int id) {
        try(Session session = HibernateConnectUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();;
            session.delete(getEmployeeById(id));
            transaction.commit();
        }
        System.out.println("Employee was deleted");

    }
}
