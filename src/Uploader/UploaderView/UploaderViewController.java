
package Uploader.UploaderView;

import Main.Upload;
import Mode.Mode;
import Uploader.Uploader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;




public class UploaderViewController implements Initializable {
    @FXML
    private TextField songName;
    @FXML
    private TextField bpm;
    @FXML
    private TextField link;
    @FXML
    private TextField chord;
    @FXML
    private Label status;
    @FXML
    private Button upload;
     private static Stage selectStage;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    public void uploader() throws IOException{
        try{
        if(!(songName.getText().equals(""))&&!(bpm.getText().equals(""))&&!(link.getText().equals(""))&&!(chord.getText().equals(""))){
            System.out.println(":)"+songName.getText()+"xx");
            Upload uploader = new Upload();
            uploader.start(songName.getText(), bpm.getText(), link.getText(), chord.getText());
            Mode select = new Mode();
            selectStage = Uploader.getUploaderStage();
            select.start(selectStage);
        }          
       
        }
        catch(NullPointerException|NumberFormatException ex){
           status.setText("Can not upload");
           System.out.println("pp"); 
        }
        
    }
    public void home() throws IOException{
        Mode select = new Mode();
        selectStage = Uploader.getUploaderStage();
        select.start(selectStage);
    }
    
}
