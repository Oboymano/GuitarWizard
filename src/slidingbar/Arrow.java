package slidingbar;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Arrow extends ImgView{
    
    private static List<Image> imgList;
    
    private int state;

    public Arrow(double width,double height,int imgIndex,double x,double y){
        img = new ImageView(imgList.get(imgIndex));
        initImage(width, height, x, y);
        state = imgIndex;
    }
    
    public void changeImage(){
        if(state==1)
            state--;
        else
            state++;
        img.setImage(imgList.get(state));
    }
    
    private static void addImg(String path) {
        imgList.add(new Image(path));
    }
    
    public static void initialize() {
        imgList = new ArrayList<>();
        addImg("/slidingbar/picture/green_arrow.png");
        addImg("/slidingbar/picture/red_arrow.png");

    }
}
