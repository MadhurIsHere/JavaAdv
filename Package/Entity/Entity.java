package Entity;

import java.awt.image.BufferedImage;
import java.nio.Buffer;

// this class will have all the variables of the player
public class Entity {
    public int x,y;
    public int speed;

    public BufferedImage up1,up2,down1,down2,right1,right2,left1,left2;
    public String direction;
    public int spriteNum=1;
    public int spriteCounter=0;
}
