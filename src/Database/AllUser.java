package Database;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class AllUser {
    
    private static List<User> allUser;
    
    private static User userOnline;
    
    public static void initialize(){
        allUser = new ArrayList<User>();
        EntityManager em = Connection.getConnection().createEntityManager();
        try {
            TypedQuery<User> q = em.createQuery("SELECT FROM User", User.class);
            for (User user : q.getResultList()) {
                allUser.add(user);
            }
        } finally {
            em.close();
        }
    }
    
    public static List<User> getAllUser(){
        return allUser;
    }
    
    public static User getOnline(){
        return userOnline;
    }
    
    public static void setOnline(long id){
        EntityManager em = Connection.emf.createEntityManager();
        try {
            TypedQuery<User> q = em.createQuery("SELECT FROM User", User.class);
            for (User user : q.getResultList()) {
                if(user.getId()==id){
                    userOnline = user;
                    break;
                }
                    
            }
        } finally {
            em.close();
        }
    }
}
