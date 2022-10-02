package main;

import java.awt.*;

public class colisionCheker {
    GamePanel gp;
    int crowX1 = Crow.xC1;
    int crowY1 = Crow.yC1;
    int crowX2 = Crow.xC2;
    int crowY2 = Crow.yC2;
    int crowX3 = Crow.xC3;
    int crowY3 = Crow.yC3;
    int crowX4 = Crow.xC4;
    int crowY4 = Crow.yC4;
    int crowWidth = Crow.solidAreaC.width;
    int crowheight = Crow.solidAreaC.height;
    int Fireballx = (int) Projectile.FireballX;
    int FireballY = (int) Projectile.FireballY;
    int FireballWidth = Fireball.solidAreaP.width;
    int Fireballheight = Fireball.solidAreaP.height;

    public Rectangle FireballBounds() {
        return new Rectangle(Fireballx,FireballY,FireballWidth,Fireballheight);
    }
    public Rectangle CrowBounds1() {
        return new Rectangle(crowX1, crowY1,crowWidth,crowheight);
    }
    public Rectangle CrowBounds2() {
        return new Rectangle(crowX2, crowY2,crowWidth,crowheight);
    }
    public Rectangle CrowBounds3() {
        return new Rectangle(crowX3, crowY3,crowWidth,crowheight);
    }
    public Rectangle CrowBounds4() {
        return new Rectangle(crowX4, crowY4,crowWidth,crowheight);
    }

    public colisionCheker(GamePanel gp){
        this.gp =gp;
    }
    public void chekfireballcrow(){
        crowX1 = Crow.xC1;
        crowY1 = Crow.yC1;
        crowX2 = Crow.xC2;
        crowY2 = Crow.yC2;
        crowX3 = Crow.xC3;
        crowY3 = Crow.yC3;
        crowX4 = Crow.xC4;
        crowY4 = Crow.yC4;
        crowWidth = Crow.solidAreaC.width;
        crowheight = Crow.solidAreaC.height;
        Fireballx = (int) Projectile.FireballX;
        FireballY = (int) Projectile.FireballY;
        FireballWidth = Fireball.solidAreaP.width;
        Fireballheight = Fireball.solidAreaP.height;

        Rectangle fireballB = FireballBounds();
        Rectangle crowB1 = CrowBounds1();
        Rectangle crowB2 = CrowBounds2();
        Rectangle crowB3 = CrowBounds3();
        Rectangle crowB4 = CrowBounds4();

        if(fireballB.intersects(crowB1)){
            if (gp.crow.alive1){
                System.out.println("crow hit");
                gp.crow.alive1 = false;
                Crow.killCountCrow +=1;
            }

        }
        if(fireballB.intersects(crowB2)){
            if (gp.crow.alive2) {
                System.out.println("crow hit");
                gp.crow.alive2 = false;
                Crow.killCountCrow +=1;
            }

        }
        if(fireballB.intersects(crowB3)){
            if (gp.crow.alive3) {
                System.out.println("crow hit");
                gp.crow.alive3 = false;
                Crow.killCountCrow +=1;
            }
        }
        if(fireballB.intersects(crowB4)){
            if (gp.crow.alive4) {
                System.out.println("crow hit");
                gp.crow.alive4 = false;
                Crow.killCountCrow +=1;
            }

        }
    }
}
