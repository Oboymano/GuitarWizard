package Mode.modeView;

import Howto.Howto;
import Main.Main;
import Mode.Mode;
import Uploader.Uploader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.stage.Stage;


public class ModeViewController implements Initializable {

    private static Stage selectSongStage;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    public void Play() throws IOException{
        Main selectSong = new Main();
        selectSongStage = Mode.getModeStage();
        selectSong.start(selectSongStage);
    }
    
    public void Upload() throws IOException{
        Uploader selectSong = new Uploader();
        selectSongStage = Mode.getModeStage();
        selectSong.start(selectSongStage);
    }
    public void Howto() throws IOException{
        Howto selectSong = new Howto();
        selectSongStage = Mode.getModeStage();
        selectSong.start(selectSongStage);
    }
    
}
