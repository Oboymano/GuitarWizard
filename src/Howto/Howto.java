
package Howto;

import Uploader.Uploader;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Howto extends Application {
    private static Stage howtoStage;
    private Pane howtoLayout;
    
    @Override
    public void start(Stage primaryStage) throws IOException {      
        
       this.howtoStage = primaryStage;
       this.howtoStage.setTitle("Guitar Wizard");
       showModeView();
    }

    private void showModeView() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Howto.class.getResource("howto/howtoView.fxml"));
        howtoLayout = loader.load();
        Scene scene = new Scene(howtoLayout);
        howtoStage.setScene(scene);
        howtoStage.show();
        
    }
    public static Stage getUploaderStage(){
        return howtoStage;
    }
}
