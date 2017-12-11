package slidingbar;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import static slidingbar.SlidingBar.heightEdge;
import static slidingbar.SlidingBar.widthEdge;

public class PauseButton extends ImgView{

    boolean mute;
    
    public PauseButton() {
        img = new ImageView(new Image("/slidingbar/picture/pause_button_1.png"));
        initImage(100, 100, heightEdge/2-20, (widthEdge/2)-50);
    }
    
    public void muteButton(){
        mute = !mute;
    }
}
