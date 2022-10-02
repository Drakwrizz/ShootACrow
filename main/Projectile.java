package main;

import java.awt.*;
import java.awt.image.BufferedImage;

import static main.Entity.*;

public class Projectile {
    private static GamePanel gp;
    public String name;
    public int speed;
    public static int lifespan;
    public static int maxLifespan;
    public int damage;
    public static boolean alive;
    public static double FireballX;
    public static double FireballY;
    public static boolean  lastFireballR,lastFireballL,lastFireballU, lastFireballSR, lastFireballSL;
    public static double ratioPX;
    public static double ratioPY;
    public static Rectangle solidAreaP = new Rectangle();

    public BufferedImage Fireball1, Fireball2,Fireball3, Fireball4, Fireball5;

    public Projectile(GamePanel gp) {
        this.gp = gp;
    }

    public static void setFireball() {
        Fireball.lifespan = 50;
        System.out.println("Start");
        FireballX = x;
        FireballY = y;
        lastFireballR = false;
        lastFireballL = false;
        lastFireballU = false;
        Fireball.alive = true;
        ratioPX = gp.player.ratio;
        ratioPY = 1-ratioPX;
        System.out.println("ratioPX = " +ratioPX);
        System.out.println("ratioPY = " +ratioPY);

    }

    public void draw(Graphics2D g2) {
        BufferedImage FireballR;
        FireballR = gp.fireball.Fireball1;
        BufferedImage FireballL;
        FireballL = gp.fireball.Fireball2;
        BufferedImage FireballU;
        FireballU = gp.fireball.Fireball3;
        BufferedImage FireballRU;
        FireballRU = gp.fireball.Fireball4;
        BufferedImage FireballLU;
        FireballLU = gp.fireball.Fireball5;

        if(gp.KeyH.shiftKey || lastFireballSR ||lastFireballSL){
            if (!lastFireballL && !lastFireballR && !lastFireballU){
                if (gp.player.R == 2 ||lastFireballSR){
                    if (!lastFireballSL){
                        if (Fireball.alive) {
                            lastFireballSR = true;
                            g2.drawImage(FireballR, (int)FireballX, (int)FireballY, 88, 35, null);
                            FireballX = FireballX + gp.fireball.speed;
                            Fireball.lifespan -= 1;
                            if (Fireball.lifespan <= 0) {
                                Fireball.alive = false;
                                lastFireballSR = false;
                            }
                        }
                    }
                }
                if (gp.player.L == 2 ||lastFireballSL){
                    if (!lastFireballSR){
                        if (Fireball.alive) {
                            lastFireballSL = true;
                            g2.drawImage(FireballL, (int)FireballX, (int)FireballY, 88, 35, null);
                            FireballX = FireballX - gp.fireball.speed;
                            Fireball.lifespan -= 1;
                            if (Fireball.lifespan <= 0) {
                                Fireball.alive = false;
                                lastFireballSL = false;
                            }
                        }
                    }
                }
            }
        }

        if (!gp.KeyH.shiftKey && !lastFireballSR && !lastFireballSL || lastFireballU ||lastFireballR||lastFireballL){
            if (gp.player.angle == 90 || gp.player.angle == 270 || lastFireballU){
                if (!lastFireballL && !lastFireballR){
                    if (Fireball.alive) {
                        lastFireballU = true;
                        g2.drawImage(FireballU, (int)FireballX, (int)FireballY, 35, 88, null);
                        FireballX += gp.fireball.speed*ratioPX;
                        FireballY += gp.fireball.speed*(-ratioPY);
                        Fireball.lifespan -= 1;
                        if (Fireball.lifespan <= 0) {
                            Fireball.alive = false;
                            lastFireballU = false;
                        }
                    }
                }
            }
            if (!lastFireballU || lastFireballL || lastFireballR){
                if (gp.player.R == 2 || lastFireballR)  {
                    if (!lastFireballL){
                        if (Fireball.alive) {
                            lastFireballR = true;
                            if (ratioPX == 0.5){
                                g2.drawImage(FireballRU, (int)FireballX, (int)FireballY, 88, 88, null);

                            }else {
                                g2.drawImage(FireballR, (int)FireballX, (int)FireballY, 88, 35, null);

                            }
                            FireballX += gp.fireball.speed*ratioPX;
                            FireballY += gp.fireball.speed*(-ratioPY);
                            Fireball.lifespan -= 1;
                            if (Fireball.lifespan <= 0) {
                                Fireball.alive = false;
                                lastFireballR = false;
                            }
                        }
                    }
                }
                if (gp.player.L == 2 || lastFireballL) {
                    if (!lastFireballR){
                        if (Fireball.alive) {
                            lastFireballL = true;
                            if (ratioPX == 0.5){
                                g2.drawImage(FireballLU, (int)FireballX, (int)FireballY, 88, 88, null);

                            }else {
                                g2.drawImage(FireballL, (int)FireballX, (int)FireballY, 88, 35, null);

                            }
                            FireballX += gp.fireball.speed*(-ratioPX);
                            FireballY += gp.fireball.speed*(-ratioPY);
                            Fireball.lifespan -= 1;
                            if (Fireball.lifespan <= 0) {
                                Fireball.alive = false;
                                lastFireballL = false;
                            }
                        }
                    }
                }
            }
        }

    }
}
