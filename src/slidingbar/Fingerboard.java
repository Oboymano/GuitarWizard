package slidingbar;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import static slidingbar.SlidingBar.heightEdge;

public class Fingerboard extends ImgView{

    public Fingerboard(){
        img = new ImageView(new Image("/slidingbar/picture/fingerboard.jpg"));
        initImage(700, 200, 0, heightEdge-200);
    }
}
