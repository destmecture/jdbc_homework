import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateConnectUtil {

    private static SessionFactory sessionFactory;
    public HibernateConnectUtil() {}

    public static SessionFactory getSessionFactory(){
        if(sessionFactory==null){
            try{
                sessionFactory =  new Configuration().configure().buildSessionFactory();

            }catch (Exception e){
                e.printStackTrace();
                System.out.println("ffff");
            }
        }
        return sessionFactory;
    }
}
