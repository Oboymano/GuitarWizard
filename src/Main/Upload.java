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
    
    String song;
    String speed;
    String url;
    String chordprogess;
    
    Music dummyMusic;
    
    List<User> allUser;
    
    public void start(String songName,String bpm,String link,String chord){
        // --------
        song = songName;
        speed = bpm;
        url = link;
        chordprogess = chord;
        dummyMusic = new Music(song,AllUser.getOnline());
        dummyMusic.setBpm(Integer.parseInt(speed));
        dummyMusic.setChord(chordprogess);
        dummyMusic.setLink(url);
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


