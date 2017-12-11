package slidingbar;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.commons.io.FileUtils;

public class Download {
    public static void DownloadMusic(String name,String link) throws MalformedURLException, IOException{
        URL url = new URL(link);
        File download = new File("music/"+name+".mp3"); 
        download.deleteOnExit(); 
        FileUtils.copyURLToFile(url, download);
        
    }
    
}
