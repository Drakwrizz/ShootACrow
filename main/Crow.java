package main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

import static java.util.Objects.requireNonNull;

public class Crow extends Entity {
    GamePanel gp;
    static int xC,xC1,xC2,xC3,xC4;
    static int yC1,yC2,yC3,yC4;
    int count11,count12,count13,count14;
    int count21,count22,count23,count24;
    boolean alive1,alive2,alive3,alive4;
    public static int LostCountCrow = 0;
    public static int killCountCrow = 0;
    public Crow(GamePanel gp) {
        this.gp=gp;
        speed = 8;
        maxLife = 5;
        life = maxLife;
        collision = false;
        xC = gp.ScreenWidth;
        getIm();
        alive1 = false;
        alive2 = false;
        alive3 = false;
        alive4 = false;
        solidAreaC.x = 0;
        solidAreaC.y = 0;
        solidAreaC.width = 68;
        solidAreaC.height = 35;


    }
    public void getIm(){
        try {
            right1 = ImageIO.read(requireNonNull(getClass().getResourceAsStream("/Assets/Crow/crow1.png")));
            right2 = ImageIO.read(requireNonNull(getClass().getResourceAsStream("/Assets/Crow/crow2.png")));

            left1 = ImageIO.read(requireNonNull(getClass().getResourceAsStream("/Assets/Crow/crow3.png")));
            left2 = ImageIO.read(requireNonNull(getClass().getResourceAsStream("/Assets/Crow/crow4.png")));

            lost1 = ImageIO.read(requireNonNull(getClass().getResourceAsStream("/Assets/Crow/crowLost.png")));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void summonCrow(){
        if (gp.dif == 1){
            alive1 = true;
            int random_int = (int)Math.floor(Math.random()*(450-1+1)+1);
            xC1 = xC;
            yC1 = random_int;
            count11 = 0;
            count21 = 0;
        }
        if (gp.dif == 2){
            if (!alive1){
                alive1 = true;
                int random_int1 = (int)Math.floor(Math.random()*(450-1+1)+1);
                xC1 = xC;
                yC1 = random_int1;
                count11 = 0;
                count21 = 0;
            }
            if (!alive2){
                alive2 = true;
                int random_int2 = (int)Math.floor(Math.random()*(450-1+1)+1);

                xC2 = xC;
                yC2 = random_int2;

                count12 = 0;
                count22 = 0;
            }


        }
        if (gp.dif == 3){
            if (!alive1){
                alive1 = true;
                int random_int1 = (int)Math.floor(Math.random()*(450-1+1)+1);
                xC1 = xC;
                yC1 = random_int1;
                count11 = 0;
                count21 = 0;
            }
            if (!alive2){
                alive2 = true;
                int random_int2 = (int)Math.floor(Math.random()*(450-1+1)+1);

                xC2 = xC;
                yC2 = random_int2;

                count12 = 0;
                count22 = 0;
            }
            if (!alive3){
                alive3 = true;

                int random_int3 = (int)Math.floor(Math.random()*(450-1+1)+1);

                xC3 = xC;
                yC3 = random_int3;

                count13 = 0;
                count23 = 0;
            }

        }
        if (gp.dif == 4){
            if (!alive1){
                alive1 = true;
                int random_int1 = (int)Math.floor(Math.random()*(450-1+1)+1);
                xC1 = xC;
                yC1 = random_int1;
                count11 = 0;
                count21 = 0;
            }
            if (!alive2){
                alive2 = true;
                int random_int2 = (int)Math.floor(Math.random()*(450-1+1)+1);

                xC2 = xC;
                yC2 = random_int2;

                count12 = 0;
                count22 = 0;
            }
            if (!alive3){
                alive3 = true;

                int random_int3 = (int)Math.floor(Math.random()*(450-1+1)+1);

                xC3 = xC;
                yC3 = random_int3;

                count13 = 0;
                count23 = 0;
            }
            if (!alive4){
                alive4 = true;

                int random_int4 = (int)Math.floor(Math.random()*(450-1+1)+1);

                xC4 = xC;
                yC4 = random_int4;

                count14 = 0;
                count24 = 0;
            }



        }
        if (gp.dif == 0){
            if (!alive1){
                alive1 = true;
                int random_int1 = (int)Math.floor(Math.random()*(450-1+1)+1);
                xC1 = xC;
                yC1 = random_int1;
                count11 = 0;
                count21 = 0;
            }
            if (!alive2){
                alive2 = true;
                int random_int2 = (int)Math.floor(Math.random()*(450-1+1)+1);

                xC2 = xC;
                yC2 = random_int2;

                count12 = 0;
                count22 = 0;
            }


        }

    }
    public void draw(Graphics2D g2) {
        if (gp.dif == 1){
            if (gp.GameState == gp.playState){
                if (alive1){
                    if (count21 > 10){
                        count21 = 0;
                    }
                    if (count11 <= 10 && count21 == 0){
                        xC1 -= speed;
                        count11 += 1;
                        g2.drawImage(right1,xC1 ,yC1, 68, 35, null);
                    }

                    if (count11 > 10 || count21 > 0){
                        xC1 -= speed;
                        count11 = 0;
                        count21 += 1;
                        g2.drawImage(right2,xC1 ,yC1, 68, 35, null);

                    }
                    if (xC1<0){
                        alive1= false;
                        LostCountCrow++;
                    }
                }
            }
            if (gp.GameState != gp.playState){
                g2.drawImage(right1,xC1 ,yC1, 68, 35, null);
            }


        }
        if (gp.dif == 2){
            if (gp.GameState == gp.playState){
                if (alive1){
                    if (count21 > 10){
                        count21 = 0;
                    }
                    if (count11 <= 10 && count21 == 0){
                        xC1 -= speed;
                        count11 += 1;
                        g2.drawImage(right1,xC1 ,yC1, 68, 35, null);
                    }

                    if (count11 > 10 || count21 > 0){
                        xC1 -= speed;
                        count11 = 0;
                        count21 += 1;
                        g2.drawImage(right2,xC1 ,yC1, 68, 35, null);

                    }
                    if (xC1<0){
                        alive1= false;
                        LostCountCrow++;
                    }
                }
                if (alive2){
                    if (count22 > 10){
                        count22 = 0;
                    }
                    if (count12 <= 10 && count22 == 0){
                        xC2 -= speed;
                        count12 += 1;
                        g2.drawImage(right1,xC2 ,yC2, 68, 35, null);
                    }

                    if (count12 > 10 || count22 > 0){
                        xC2 -= speed;
                        count12 = 0;
                        count22 += 1;
                        g2.drawImage(right2,xC2 ,yC2, 68, 35, null);

                    }
                    if (xC2<0){
                        alive2= false;
                        LostCountCrow++;
                    }
                }
            }
            if (gp.GameState != gp.playState){
                g2.drawImage(right1,xC1 ,yC1, 68, 35, null);
                g2.drawImage(right1,xC2 ,yC2, 68, 35, null);
            }

        }
        if (gp.dif == 3){
            if (gp.GameState == gp.playState){
                if (alive1){
                    if (count21 > 10){
                        count21 = 0;
                    }
                    if (count11 <= 10 && count21 == 0){
                        xC1 -= speed;
                        count11 += 1;
                        g2.drawImage(right1,xC1 ,yC1, 68, 35, null);
                    }

                    if (count11 > 10 || count21 > 0){
                        xC1 -= speed;
                        count11 = 0;
                        count21 += 1;
                        g2.drawImage(right2,xC1 ,yC1, 68, 35, null);

                    }
                    if (xC1<0){
                        alive1= false;
                        LostCountCrow++;
                    }
                }
                if (alive2){
                    if (count22 > 10){
                        count22 = 0;
                    }
                    if (count12 <= 10 && count22 == 0){
                        xC2 -= speed;
                        count12 += 1;
                        g2.drawImage(right1,xC2 ,yC2, 68, 35, null);
                    }

                    if (count12 > 10 || count22 > 0){
                        xC2 -= speed;
                        count12 = 0;
                        count22 += 1;
                        g2.drawImage(right2,xC2 ,yC2, 68, 35, null);

                    }
                    if (xC2<0){
                        alive2= false;
                        LostCountCrow++;
                    }
                }
                if (alive3){
                    if (count23 > 10){
                        count23 = 0;
                    }
                    if (count13 <= 10 && count23 == 0){
                        xC3 -= speed;
                        count13 += 1;
                        g2.drawImage(right1,xC3 ,yC3, 68, 35, null);
                    }

                    if (count13 > 10 || count23 > 0){
                        xC3 -= speed;
                        count13 = 0;
                        count23 += 1;
                        g2.drawImage(right2,xC3 ,yC3, 68, 35, null);

                    }
                    if (xC3<0){
                        alive3= false;
                        LostCountCrow++;
                    }
                }
            }
            if (gp.GameState != gp.playState){
                g2.drawImage(right1,xC1 ,yC1, 68, 35, null);
                g2.drawImage(right1,xC2 ,yC2, 68, 35, null);
                g2.drawImage(right1,xC3 ,yC3, 68, 35, null);
            }

        }
        if (gp.dif == 4){
            if (gp.GameState == gp.playState) {
                if (alive1){
                    if (count21 > 10){
                        count21 = 0;
                    }
                    if (count11 <= 10 && count21 == 0){
                        xC1 -= speed;
                        count11 += 1;
                        g2.drawImage(right1,xC1 ,yC1, 68, 35, null);
                    }

                    if (count11 > 10 || count21 > 0){
                        xC1 -= speed;
                        count11 = 0;
                        count21 += 1;
                        g2.drawImage(right2,xC1 ,yC1, 68, 35, null);

                    }
                    if (xC1<0){
                        alive1= false;
                        LostCountCrow++;
                    }
                }
                if (alive2){
                    if (count22 > 10){
                        count22 = 0;
                    }
                    if (count12 <= 10 && count22 == 0){
                        xC2 -= speed;
                        count12 += 1;
                        g2.drawImage(right1,xC2 ,yC2, 68, 35, null);
                    }

                    if (count12 > 10 || count22 > 0){
                        xC2 -= speed;
                        count12 = 0;
                        count22 += 1;
                        g2.drawImage(right2,xC2 ,yC2, 68, 35, null);

                    }
                    if (xC2<0){
                        alive2= false;
                        LostCountCrow++;
                    }
                }
                if (alive3){
                    if (count23 > 10){
                        count23 = 0;
                    }
                    if (count13 <= 10 && count23 == 0){
                        xC3 -= speed;
                        count13 += 1;
                        g2.drawImage(right1,xC3 ,yC3, 68, 35, null);
                    }

                    if (count13 > 10 || count23 > 0){
                        xC3 -= speed;
                        count13 = 0;
                        count23 += 1;
                        g2.drawImage(right2,xC3 ,yC3, 68, 35, null);

                    }
                    if (xC3<0){
                        alive3= false;
                        LostCountCrow++;
                    }
                }
                if (alive4){
                    if (count24 > 10){
                        count24 = 0;
                    }
                    if (count14 <= 10 && count24 == 0){
                        xC4 -= speed;
                        count14 += 1;
                        g2.drawImage(right1,xC4 ,yC4, 68, 35, null);
                    }

                    if (count14 > 10 || count24 > 0){
                        xC4 -= speed;
                        count14 = 0;
                        count24 += 1;
                        g2.drawImage(right2,xC4 ,yC4, 68, 35, null);

                    }
                    if (xC4<0){
                        alive4= false;
                        LostCountCrow++;
                    }
                }
            }
            if (gp.GameState != gp.playState){
                g2.drawImage(right1,xC1 ,yC1, 68, 35, null);
                g2.drawImage(right1,xC2 ,yC2, 68, 35, null);
                g2.drawImage(right1,xC3 ,yC3, 68, 35, null);
                g2.drawImage(right1,xC4 ,yC4, 68, 35, null);
            }



            }
        if (gp.dif == 0){
            if (gp.GameState == gp.playState){
                if (alive1){
                    if (count21 > 10){
                        count21 = 0;
                    }
                    if (count11 <= 10 && count21 == 0){
                        xC1 -= speed;
                        count11 += 1;
                        g2.drawImage(right1,xC1 ,yC1, 68, 35, null);
                    }

                    if (count11 > 10 || count21 > 0){
                        xC1 -= speed;
                        count11 = 0;
                        count21 += 1;
                        g2.drawImage(right2,xC1 ,yC1, 68, 35, null);

                    }
                    if (xC1<0){
                        alive1= false;
                        LostCountCrow++;
                    }
                }
                if (alive2){
                    if (count22 > 10){
                        count22 = 0;
                    }
                    if (count12 <= 10 && count22 == 0){
                        xC2 -= speed;
                        count12 += 1;
                        g2.drawImage(right1,xC2 ,yC2, 68, 35, null);
                    }

                    if (count12 > 10 || count22 > 0){
                        xC2 -= speed;
                        count12 = 0;
                        count22 += 1;
                        g2.drawImage(right2,xC2 ,yC2, 68, 35, null);

                    }
                    if (xC2<0){
                        alive2= false;
                        LostCountCrow++;
                    }
                }
            }
            if (gp.GameState != gp.playState){
                g2.drawImage(right1,xC1 ,yC1, 68, 35, null);
                g2.drawImage(right1,xC2 ,yC2, 68, 35, null);
            }
            speed = killCountCrow/5+8;

        }


    }
}
