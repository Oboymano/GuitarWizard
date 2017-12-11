package slidingbar;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import static slidingbar.SlidingBar.widthBar;

public class Number extends ImgViewMovement{
    
    private static List<Image> imgList;

    public Number(double width,double height,int imgIndex,double x,double y,double movement){
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
        addImg("file:Number/1.png");
        addImg("file:Number/2.png");
        addImg("file:Number/3.png");
        
        addImg("file:Number/4.png");
        addImg("file:Number/5.png");
        addImg("file:Number/6.png");
        
        addImg("file:Number/7.png");
        addImg("file:Number/8.png");
        addImg("file:Number/9.png");
        
        addImg("file:Number/10.png");
        addImg("file:Number/11.png");
        addImg("file:Number/12.png");
        
        addImg("file:Number/13.png");
        addImg("file:Number/14.png");
        addImg("file:Number/15.png");
        
        addImg("file:Number/16.png");
        addImg("file:Number/17.png");
        addImg("file:Number/18.png");
        
        addImg("file:Number/19.png");
        addImg("file:Number/20.png");
        addImg("file:Number/21.png");
        
        addImg("file:Number/22.png");  
        
    }
}
