package slidingbar;

import org.apache.commons.io.FileUtils;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javafx.animation.AnimationTimer;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import Chord.AChord;
import Chord.AllChord;
import Chord.BChord;
import Chord.CChord;
import Chord.DChord;
import Chord.EChord;
import Chord.FChord;
import Chord.GChord;
import Main.Main;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.layout.Background;

public class SlidingBar {
    static double heightBar = 200;
    static double widthBar = 280;
    static double heightEdge = 700;
    static double widthEdge = 700;
    static double widthAlphabet = 175;
    static double heightAlphabet = 125;
    static double widthSoloBar = 35;
    static double gapBar = 280;
    static double gap = 70;
    static double gapSolo = 35;
    int count;
    int time;
    int target;
    int barTarget;
    int state;
    boolean checkSprite;
    boolean checkPause;
    boolean checkMute;
    boolean isGreen;
    boolean endSong;
    
    MusicDisplay song ;
    
    Pane root;
    
    Button up;
    Button down;
    
    Label showTime;
    
    AllChord Aguide;
    AllChord Bguide;
    AllChord Cguide;
    AllChord Dguide;
    AllChord Eguide;
    AllChord Fguide;
    AllChord Gguide;
    
    Arrow arrow;
    
    PauseButton pauseButton;
    
    public void play(Stage primaryStage,String songName) {
        
        count = 0;
        time = 0;
        target = 0;
        barTarget =0;
        state = 6;
        
        checkSprite = false;
        checkPause = false;
        checkMute = false;
        isGreen = false;
        endSong = false;
        
        root = new Pane();
        
        up = new Button();
        down = new Button();
        
        showTime = new Label();
        
        Aguide = new AChord(0);
        Bguide = new BChord(0);
        Cguide = new CChord(0);
        Dguide = new DChord(0);
        Eguide = new EChord(0);
        Fguide = new FChord(0);
        Gguide = new GChord(0);
                
        arrow = new Arrow(50,50,1,widthEdge/2-25,heightEdge-heightBar-50);
        
        pauseButton = new PauseButton();
        
        song = new MusicDisplay(songName);
        
        setLabel(showTime, 15, 15);
        showTime.setText(""+time);
        
        setButton(up, 50, 15);
        setButton(down,50,45);
        up.setText("+");
        down.setText("-");
        
        
        root.getChildren().addAll(new Fingerboard().img,Gguide.getImg(),arrow.img,showTime,up,down);

        for(int i=0;i<song.bar.size();i++){
            root.getChildren().add(song.bar.get(i).img);
        }
        
        for(int i=0;i<song.alphabet.size();i++){
            root.getChildren().add(song.alphabet.get(i).img);
        }
        
        for(int i=0;i<song.number.size();i++){
            root.getChildren().add(song.number.get(i).img);
        }
        
        Scene scene = new Scene(root, 700, 700);
        
        primaryStage.setTitle("Guitar Wizard");
        primaryStage.setScene(scene);
        //primaryStage.setResizable(false);
        primaryStage.show();
        
        song.playMusic();
        
        AnimationTimer background = new AnimationTimer() {
            @Override
            public void handle(long now) {
                
                if(song.mediaPlayer.getCurrentTime().equals(song.mediaPlayer.getTotalDuration())&&!endSong){
                    Main main = new Main();
                    Stage mainStage = LogIn.LogIn.getLogInStage();            
                    try {
                        main.start(mainStage);
                    } catch (IOException ex) {
                        Logger.getLogger(SlidingBar.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    //primaryStage.hide();
                    song.mediaPlayer.stop();
                    endSong = true;
                }
                // update label
                showTime.setText("x"+song.normalSpeed);
                // time
                
                if(!checkPause){
                    for(int i=0;i<song.bar.size();i++){
                        song.bar.get(i).slide();
                    }
                    
                    for(int i=0;i<song.alphabet.size();i++){
                        song.alphabet.get(i).slide();
                    }
                    
                    for(int i=0;i<song.number.size();i++){
                        song.number.get(i).slide();
                    }
                }
                
                count++;
                if(count==60){
                   time++;
                   count=0;
                }
                
                if(target<song.chord.size()&&song.bar.get(target).img.getX()<=widthEdge/2){
                    if(isGreen){
                        arrow.changeImage();
                        isGreen = false;
                        
                    }
                    if(!song.chord.get(target).equals("-")&&song.chord.get(target).charAt(0)!='['&&song.chord.get(target).charAt(0)!='$'&&song.chord.get(target).charAt(0)!='&'){
                        isGreen = true;
                        arrow.changeImage();
                        if(state!=0)
                            root.getChildren().remove(Aguide.getImg());
                        if(state!=1)
                            root.getChildren().remove(Bguide.getImg());
                        if(state!=2)
                            root.getChildren().remove(Cguide.getImg());
                        if(state!=3)
                            root.getChildren().remove(Dguide.getImg());
                        if(state!=4)
                            root.getChildren().remove(Eguide.getImg());
                        if(state!=5)
                            root.getChildren().remove(Fguide.getImg());
                        if(state!=6)
                            root.getChildren().remove(Gguide.getImg());
                        
                        changeGuide(song.chord.get(target));
                    }
                    if(song.chord.get(target).charAt(0)=='['){
                        isGreen = true;
                    }
                    if(song.chord.get(target).length()>1&&song.chord.get(target).charAt(1)=='['){
                        isGreen = true;
                    }
                        
                    target++;
                }
                
                // increase and decrease button
                up.setOnAction(new EventHandler<ActionEvent>() {
            
                    @Override
                    public void handle(ActionEvent event) {
                        if(song.mediaPlayer.getVolume()<=1)
                            song.increaseVolume();
                        
                    }
                });
                
                down.setOnAction(new EventHandler<ActionEvent>() {
            
                    @Override
                    public void handle(ActionEvent event) {
                        if(song.mediaPlayer.getVolume()>=0)
                            song.decreaseVolume();
                    }
                });
               
            }
        };
        
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
        
        @Override
        public void handle(KeyEvent keyEvent) {
            
            switch(keyEvent.getCode().toString()){
                case "Q":
                    Main main = new Main();
                    Stage mainStage = LogIn.LogIn.getLogInStage();            
                    try {
                        main.start(mainStage);
                    } catch (IOException ex) {
                        Logger.getLogger(SlidingBar.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    song.mediaPlayer.stop();
                    //primaryStage.hide();
                    endSong = true;
                    break;
                case "P":
                    if(checkMute&&checkPause){
                        checkMute=!checkMute;
                        song.mediaPlayer.setMute(checkMute);
                    }
                    checkPause=!checkPause;
                    if(checkPause){
                        root.getChildren().add(pauseButton.img);
                        song.mediaPlayer.pause();
                    }else if(!checkPause){
                        root.getChildren().remove(pauseButton.img);
                        song.mediaPlayer.play();
                    }
                    break;
                case "X":
                    song.increaseSpeed();
                    break;
                case "Z":
                    song.decreaseSpeed();
                    break;
                case "M":
                    checkMute=!checkMute;
                    song.mediaPlayer.setMute(checkMute);
                    root.getChildren().remove(pauseButton.img);
                    pauseButton.muteButton();
                    root.getChildren().add(pauseButton.img);
                    break;
            }
        }
        });
        
        background.start();
        
        if(endSong){
            background.stop();
        }
        
    }
    
    public void setLabel(Label label,double x,double y){
        label.setLayoutX(x);
        label.setLayoutY(y);
    }
    
    public void setButton(Button button,double x,double y){
        button.setLayoutX(x);
        button.setLayoutY(y);
        button.setMinHeight(30);
        button.setMinWidth(30);
    }
    
    public void changeGuide(String name){
        String newName = "";
        boolean checkDone = false;
        if(name.charAt(0)=='A'){
            if(name.length()>1&&name.charAt(1)=='#'){
                newName = name.substring(0, 1)+"_"+name.substring(2,name.length());
            }else{
                newName = name;
            }
            Aguide = new AChord(AChord.getChord(newName));
            checkDone=true;
            root.getChildren().add(Aguide.getImg());
        }else if(name.charAt(0)=='B'){
            if(name.length()>1&&name.charAt(1)=='#'){
                newName = name.substring(0, 1)+"_"+name.substring(2,name.length());
            }else{
                newName = name;
            }
            Bguide = new BChord(BChord.getChord(newName));
            checkDone=true;
            root.getChildren().add(Bguide.getImg());
        }else if(name.charAt(0)=='C'){
            if(name.length()>1&&name.charAt(1)=='#'){
                newName = name.substring(0, 1)+"_"+name.substring(2,name.length());
            }else{
                newName = name;
            }
            Cguide = new CChord(CChord.getChord(newName));
            checkDone=true;
            root.getChildren().add(Cguide.getImg());
        }else if(name.charAt(0)=='D'){
            if(name.length()>1&&name.charAt(1)=='#'){
                newName = name.substring(0, 1)+"_"+name.substring(2,name.length());
            }else{
                newName = name;
            }
            Dguide = new DChord(DChord.getChord(newName));
            checkDone=true;
            root.getChildren().add(Dguide.getImg());
        }else if(name.charAt(0)=='E'){
            
            if(name.length()>1&&name.charAt(1)=='#'){
                newName = name.substring(0, 1)+"_"+name.substring(2,name.length());
            }else{
                newName = name;
            }
            Eguide = new EChord(EChord.getChord(newName));
            checkDone=true;
            root.getChildren().add(Eguide.getImg());
        }else if(name.charAt(0)=='F'){
            if(name.length()>1&&name.charAt(1)=='#'){
                newName = name.substring(0, 1)+"_"+name.substring(2,name.length());
            }else{
                newName = name;
            }
            Fguide = new FChord(FChord.getChord(newName));
            checkDone=true;
            root.getChildren().add(Fguide.getImg());
        }else if(name.charAt(0)=='G'){
            if(name.length()>1&&name.charAt(1)=='#'){
                newName = name.substring(0, 1)+"_"+name.substring(2,name.length());
            }else{
                newName = name;
            }
            Gguide = new GChord(GChord.getChord(newName));
            checkDone=true;
            root.getChildren().add(Gguide.getImg());
        }else if(name.equals("-")){
            
        }
        if(checkDone){
            root.getChildren().removeAll(up,down,showTime,arrow.img);
            root.getChildren().addAll(up,down,showTime,arrow.img);
        }
            
    }
    /**
     * @param args the command line arguments
     */

}
