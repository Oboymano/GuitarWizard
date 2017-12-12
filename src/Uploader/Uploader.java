
package Uploader;

import Main.Main;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Uploader extends Application {
    private static Stage uploaderStage;
    private Pane uploaderLayout;
    
    @Override
    public void start(Stage primaryStage) throws IOException {      
        
       this.uploaderStage = primaryStage;
       this.uploaderStage.setTitle("Guitar Wizard");
       showModeView();
    }

    private void showModeView() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Uploader.class.getResource("UploaderView/UploaderView.fxml"));
        uploaderLayout = loader.load();
        Scene scene = new Scene(uploaderLayout);
        uploaderStage.setScene(scene);
        uploaderStage.show();
        
    }
    public static Stage getUploaderStage(){
        return uploaderStage;
    }
}
