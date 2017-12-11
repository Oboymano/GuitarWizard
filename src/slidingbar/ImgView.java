package slidingbar;

import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class ImgView {

    protected ImageView img;
    
    protected void initImage(double width,double height,double x,double y){
        img.setFitHeight(height);
        img.setFitWidth(width);
        img.setY(y);
        img.setX(x);
    }
    
    public ImageView getImg(){
        return img;
    }
    
}
