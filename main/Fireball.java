package main;

import java.io.IOException;

import static java.util.Objects.requireNonNull;
import static javax.imageio.ImageIO.read;
import static main.Entity.x;

public class Fireball extends Projectile{

    GamePanel gp;
    public Fireball(GamePanel gp) {
        super(gp);
        this.gp =gp;
        name = "Fireball";
        speed = 12;
        maxLifespan = 100;
        lifespan = maxLifespan;
        damage = 2;
        alive = false;
        FireballX = 0;
        FireballY = 0;
        solidAreaP.x = 0;
        solidAreaP.y = 0;
        solidAreaP.width = 68;
        solidAreaP.height = 35;
        getImage();

    }
    public void getImage() {
        try {
            System.out.println("Fireball1");
            Fireball1 = read(requireNonNull(getClass().getResourceAsStream("/Assets/fireball/Fireball1.png")));
            System.out.println("Fireball2");
            Fireball2 = read(requireNonNull(getClass().getResourceAsStream("/Assets/fireball/Fireball2.png")));
            Fireball3 = read(requireNonNull(getClass().getResourceAsStream("/Assets/fireball/Fireball3.png")));
            Fireball4 = read(requireNonNull(getClass().getResourceAsStream("/Assets/fireball/Fireball4.png")));
            Fireball5 = read(requireNonNull(getClass().getResourceAsStream("/Assets/fireball/Fireball5.png")));

            System.out.println("all");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
