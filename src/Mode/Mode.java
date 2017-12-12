
package Mode;

import Main.Main;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Mode extends Application {
    private static Stage modeStage;
    private Pane modeLayout;
    
    @Override
    public void start(Stage primaryStage) throws IOException {      
       this.modeStage = primaryStage;
       this.modeStage.setTitle("Guitar Wizard");
       showModeView();
    }

    private void showModeView() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Mode.class.getResource("modeView/modeView.fxml"));
        modeLayout = loader.load();
        Scene scene = new Scene(modeLayout);
        modeStage.setScene(scene);
        modeStage.show();
        
    }
    public static Stage getModeStage(){
        return modeStage;
    }
    public static void main(String[] args) {
        launch(args);
    }
}
