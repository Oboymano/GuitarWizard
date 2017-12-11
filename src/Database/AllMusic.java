package Database;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class AllMusic {
    
    private static List<Music> allMusic;
    
    public static void initialize(){
        allMusic = new ArrayList<Music>();
        EntityManager em = Connection.getConnection().createEntityManager();
        try {
            TypedQuery<Music> q = em.createQuery("SELECT FROM Music", Music.class);
            for (Music music : q.getResultList()) {
                allMusic.add(music);
            }
        } finally {
            em.close();
        }
    }
    
    public static List<Music> getAllMusic(){
        return allMusic;
    }
    
}
