
package Howto.howto;

import Howto.Howto;
import Mode.Mode;
import Uploader.Uploader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.stage.Stage;


public class HowtoViewController implements Initializable {
    
    private static Stage selectStage;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    public void home() throws IOException{
        Mode select = new Mode();
        selectStage = Howto.getUploaderStage();
        select.start(selectStage);
    }
    
    
}
