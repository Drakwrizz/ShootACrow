package main;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static java.lang.Math.*;
import static java.util.Objects.requireNonNull;
import static javax.imageio.ImageIO.read;

public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyH;
    public BufferedImage PlayerSprite1;
    public BufferedImage PlayerSprite2;
    public BufferedImage PlayerSprite3;
    public BufferedImage PlayerSprite4;
    public static boolean jump  = false;
    public static int defautJumpTimer  = 23;
    public static double JumpSpeed = 0.022d;
    public static int JumpTimer;
    private static double g;
    public int AirTime = 0;
    public int R = 2;
    public int L = 1;
    public double angle = 0;
    public double LongVec;
    public double calcAngle,ScalVec;
    public double ratio;

    public static double DifX, DifY;


    public int yorigin;
    
    private Projectile Fireball;


    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        setdefaultValue();
        getPlayerImage();
        JumpTimer =defautJumpTimer;

    }
    public void setdefaultValue(){
        x = 336;
        lastx = 0;
        y = 450;
        lasty = 0;
        yorigin = y;
        speed = 5;
        direction = "nothing";
        maxLife = 10;
        life = maxLife;
        DifX = 0;
        DifY = 0;

    }
    public void getPlayerImage(){
        try {
            PlayerSprite1 = read(requireNonNull(getClass().getResourceAsStream("/Assets/hero/hero1.png")));
            PlayerSprite2 = read(requireNonNull(getClass().getResourceAsStream("/Assets/hero/hero2.png")));
            PlayerSprite3 = read(requireNonNull(getClass().getResourceAsStream("/Assets/hero/hero3.png")));
            PlayerSprite4 = read(requireNonNull(getClass().getResourceAsStream("/Assets/hero/hero4.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void update(){
        DifX = x-lastx;
        DifY = y-lasty;
        LongVec = sqrt(pow((x-lastx),2)+pow((y-lasty),2));
        calcAngle = ((DifX*1)+(DifY*0));
        if (LongVec != 0){
            angle = acos(calcAngle/(LongVec));
            angle = Math.toDegrees(angle);
        }
        if (LongVec == 0){
            if (R == 2){
                angle = 0;
            }
            if (L == 2){
                angle = 0;
            }
        }
        if (angle > 0 && angle <90){//up right
            ratio = 0.5;
        }
        if (angle > 270 && angle <360){//down right
            ratio = -0.5;
        }

        if (angle > 90 && angle <180){//up left
            ratio = 0.5;
        }
        if (angle > 180 && angle <270){//down left
            ratio = -0.5;
        }

        if (angle == 0||angle == 360){
            ratio = 1;
        }
        if (angle == 90||angle == 270){
            ratio = 0;
        }





        if (gp.KeyH.rightPressed){
            lastx = x;
            x+=speed;

        }
        if (gp.KeyH.leftPressed){
            lastx = x;
            x-=speed;
        }
        if (gp.KeyH.upPressed){
            jump = true;
        }
        if (!keyH.rightPressed && !keyH.leftPressed){
            lastx = x;
        }
        if (!keyH.upPressed){
            lasty = y;
        }
        if(jump) {
            lasty = y;
            y -= speed;
            JumpTimer--;

            if(JumpTimer <= 0) {
                jump = false;

            }

        }
        if (y == yorigin){
            AirTime =0;
        }
        if (y < yorigin){
            AirTime++;
            g = AirTime/10;
            lasty = y;
            y += g;
        }
        if (gp.KeyH.attackKey && !Projectile.alive){
            Projectile.setFireball();

        }

    }



    public void draw(Graphics2D g2) {
        BufferedImage image1 = null;
        image1 = PlayerSprite1;
        BufferedImage image2 = null;
        image2 = PlayerSprite2;
        BufferedImage image3 = null;
        image3 = PlayerSprite3;
        BufferedImage image4 = null;
        image4 = PlayerSprite4;

        if (image1 != null && image2 != null){
            if (gp.KeyH.rightPressed){
                g2.drawImage(image3, x, y,gp.TileSize,gp.TileSize, null);
                R = 2;
                L = 1;
            }
            if (gp.KeyH.leftPressed){
                g2.drawImage(image4, x, y,gp.TileSize,gp.TileSize, null);
                R = 1;
                L = 2;
            }
            if (!keyH.rightPressed && !keyH.leftPressed){
                if (R == 2){
                    g2.drawImage(image1, x, y,gp.TileSize,gp.TileSize, null);
                }
                if (L == 2){
                    g2.drawImage(image2, x, y,gp.TileSize,gp.TileSize, null);
                }
            }

        }

    }
}