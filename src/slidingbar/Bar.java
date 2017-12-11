package slidingbar;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Bar extends ImgViewMovement{
    
    private static List<Image> imgList;

    public Bar(double width,double height,int imgIndex,double x,double y,double movement){
        img = new ImageView(imgList.get(imgIndex));
        initImage(width, height, x, y);
        this.movement = movement;
        defaultMovement = movement; 
    }
    
    private static void addImg(String path) {
        imgList.add(new Image(path));
    }
    
    public static void initialize() {
        imgList = new ArrayList<>();
        addImg("/slidingbar/picture/red_front.png");
        addImg("/slidingbar/picture/red_mid.png");
        addImg("/slidingbar/picture/red_end.png");
        
        addImg("/slidingbar/picture/green_front.png");
        addImg("/slidingbar/picture/green_mid.png");
        addImg("/slidingbar/picture/green_end.png");
        
        addImg("/slidingbar/picture/solo_front.png");
        addImg("/slidingbar/picture/solo_mid.png");
        addImg("/slidingbar/picture/solo_end.png");
        
        
    }
}
