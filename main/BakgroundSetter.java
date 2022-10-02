package main;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static java.util.Objects.requireNonNull;
import static javax.imageio.ImageIO.read;

public class BakgroundSetter {
    GamePanel gp;
    public BufferedImage Myimage;
    public BakgroundSetter(GamePanel gp) {
        this.gp = gp;
        getIm();
    }

    private void getIm() {
        try {
            Myimage = read(requireNonNull(getClass().getResourceAsStream("/Assets/Background.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image1 = null;
        image1 = Myimage;
        g2.drawImage(image1, 0, 0,gp.ScreenWidth,gp.ScreenHeight, null);

    }
}
