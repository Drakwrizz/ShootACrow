package main;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UI {
    GamePanel gp;
    Graphics2D g2;
    Font arial_30;
    BufferedImage Rcrow;

    BufferedImage heartFull,heartHalf,heartEmpty;
    BufferedImage Lcrow;
    public UI(GamePanel gp){
        this.gp = gp;
        arial_30 = new Font("Arial",Font.PLAIN,30);
        Rcrow = Crow.right1;
        Lcrow = Crow.lost1;

    }
    public void draw(Graphics2D g2){
        this.g2 = g2;
        g2.setFont(arial_30);
        g2.setColor(Color.white);
        if (gp.GameState == gp.playState){
            g2.drawImage(Rcrow, 10,0 , gp.TileSize, gp.TileSize, null);
            g2.drawString("X " +Crow.killCountCrow, 60, 35);

            g2.drawImage(Lcrow, 130,0 , gp.TileSize, gp.TileSize, null);
            g2.drawString("X " +Crow.LostCountCrow, 180, 35);
        }
        if (gp.GameState == gp.pauseState){
            g2.drawImage(Rcrow, 10,0 , gp.TileSize, gp.TileSize, null);
            g2.drawString("X " +Crow.killCountCrow, 60, 35);

            g2.drawImage(Lcrow, 130,0 , gp.TileSize, gp.TileSize, null);
            g2.drawString("X " +Crow.LostCountCrow, 180, 35);
        }
        if (gp.GameState == gp.GameOverState){
            g2.drawImage(Rcrow, gp.ScreenWidth/2 - 100,250 , gp.TileSize, gp.TileSize, null);
            g2.drawString("X " +Crow.killCountCrow, gp.ScreenWidth/2 -50, 285);

            g2.drawImage(Lcrow, gp.ScreenWidth/2+50,250 , gp.TileSize, gp.TileSize, null);
            g2.drawString("X " +Crow.LostCountCrow, gp.ScreenWidth/2 +100, 285);
        }

        }
}