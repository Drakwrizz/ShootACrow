package main;

import java.awt.*;
import java.awt.image.BufferedImage;

import static java.util.Objects.requireNonNull;

public class Entity {
    public static int x;
    public static int y;
    public static int lastx;
    public static int lasty;
    public int speed;

    public BufferedImage PlayerSprite;
    public static BufferedImage right1;
    public BufferedImage right2;
    public BufferedImage left1;
    public BufferedImage left2;
    public static BufferedImage lost1;

    public static Rectangle solidArea = new Rectangle();
    public static Rectangle solidAreaC = new Rectangle();

    public static boolean collision = false;
    public static String direction;
    public int solidAreaDefaultX, solidAreaDefaultY;
    public int maxLife;
    public int life;

}
