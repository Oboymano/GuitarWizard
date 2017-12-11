package slidingbar;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import static slidingbar.SlidingBar.widthBar;

public class Alphabet extends ImgViewMovement{
    
    public Alphabet(String name,double width,double height,double x,double y,double movement){
        img = new ImageView(new Image("file:Alphabet/"+name.charAt(0)+"/"+name+".png"));
        initImage(width, height, x, y);
        this.movement = movement;
        defaultMovement = movement; 
    }
    
}