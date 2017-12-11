package slidingbar;

import static slidingbar.SlidingBar.widthBar;

public class ImgViewMovement extends ImgView{
    
    protected double movement = 0;
    protected double defaultMovement = 0;
    
    public void increaseSpeed(int bpm){
        movement=(((bpm/2)*widthBar)/60)/60;
    }
    
    public void decreaseSpeed(int bpm){
        movement=(((bpm/2)*widthBar)/60)/60;
    }
    
    public void slide(){
        img.setX(img.getX()-movement );
        
    }
}
