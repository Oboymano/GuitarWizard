package Main;

import Database.AllUser;
import Database.Connection;
import Database.Music;
import Database.User;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class Upload {
    
    Music dummyMusic;
    
    List<User> allUser;
    
    public void start(){
        // --------
        dummyMusic = new Music("Versace",AllUser.getOnline());
        dummyMusic.setBpm(132);
        dummyMusic.setChord("-*-*-*-*C*-*-*-*-*-*Em*-*");
        dummyMusic.setLink("http://161.246.6.25/songs/Versace.mp3");
        AllUser.getOnline().setMusic(dummyMusic);
        // -------
        addMusic(dummyMusic);
    }
    
    public void addMusic(Music music){
        
        EntityManager em = Connection.getConnection().createEntityManager();
        em.getTransaction().begin();
        
        em.persist(music);
        
        em.getTransaction().commit();
        em.close();
        
    }
    
    public void init(){
        allUser = AllUser.getAllUser();
    }
    
}


