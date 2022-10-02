package main;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    //selectione la taille d'uen tile (en px)
    final int screenSize = ;
    //16px est trop petit il faut donc le scale
    final int Scale = 3; //x3

    public final int TileSize = OriginalTileSize * Scale;

    //le nombre de tile dans un colone
    public final int MaxScreenCol = 30;
    //le nombre de tile dans un ligne
    public final int MaxScreenRow = 15;
    public final int ScreenWidth = TileSize * MaxScreenCol;
    public final int ScreenHeight = TileSize * MaxScreenRow;

    public KeyHandler KeyH = new KeyHandler(this);
    Player player = new Player(this, KeyH);
    Projectile projectile =new Projectile(this);
    Fireball fireball =new Fireball(this);
    Crow crow = new Crow(this);
    colisionCheker cChek = new colisionCheker(this);
    BakgroundSetter bakgroundSetter =new BakgroundSetter(this);
    UI ui = new UI(this);
    Thread gameThread;
    //FPS
    int FPS = 60;
    public int GameState;
    public final int TitleState = 0;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int creditState = 3;
    public final int GameOverState = 4;
    public final int difSeclctState = 5;

    public int titleSelection = 0;
    public int dif = 0;
    public boolean FirstBird = true;

    public int ingameTimer =0;


    public GamePanel() {
        this.setPreferredSize(new Dimension(ScreenWidth, ScreenHeight));
        Color MyGray = new Color(40, 35, 35);
        this.setBackground(MyGray);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.addKeyListener(KeyH);

    }

    public void setUp() {
        GameState = TitleState;
    }

    public void startGameTread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000 / FPS;//0.0166s
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        while (gameThread != null) {

            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;
            if (delta >= 1) {
                //Update : Update information sutch a position and movment
                update();
                //Draw : draw the screen with the new information
                repaint();
                delta--;
            }

        }
    }

    public void update() {
        if (GameState == playState) {
            player.update();
            ingameTimer++;
            if (ingameTimer > 100|| !FirstBird){
                if (dif == 1){
                    if (!crow.alive1){
                        crow.summonCrow();
                        FirstBird = false;
                    }
                }
                if (dif == 2){
                    if (!crow.alive1||!crow.alive2){
                        crow.summonCrow();
                        FirstBird = false;

                    }
                }
                if (dif == 3){
                    if (!crow.alive1||!crow.alive2||!crow.alive3){
                        crow.summonCrow();
                        FirstBird = false;

                    }
                }
                if (dif == 4){
                    if (!crow.alive1||!crow.alive2||!crow.alive3||!crow.alive4){
                        crow.summonCrow();
                        FirstBird = false;

                    }
                }
                if (dif == 0){
                    if (!crow.alive1||!crow.alive2){
                        crow.summonCrow();
                        FirstBird = false;

                    }
                }

            }
            if (crow.alive1 || crow.alive2 || crow.alive3 || crow.alive4){
                cChek.chekfireballcrow();
            }
            if (Crow.LostCountCrow >= 10){
                GameState = GameOverState;
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //def le personage
        Graphics2D g2 = (Graphics2D) g;
        if (GameState == TitleState) {
            bakgroundSetter.draw(g2);
            g2.setFont(new Font("Arial", Font.PLAIN, 30));
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(Color.white);
            g2.drawString("ShootAcrow", 600, 100);
            g2.drawString("ARCADE", 690, 200);
            if (titleSelection <= 0) {
                g2.drawString(">", 650, 200);
                while (titleSelection < 0) {
                    titleSelection++;
                }
                if (KeyH.EPressed == true){
                    GameState = playState;
                    dif = 0;
                    KeyH.EPressed = false;

                }
                }
            g2.drawString("DIFFICULTY", 700, 250);
            if (titleSelection == 1) {
                g2.drawString(">", 650, 250);
                if (KeyH.EPressed == true){
                    GameState = difSeclctState;
                    titleSelection = 0;
                    KeyH.EPressed = false;

                }
            }
            g2.drawString("QUIT", 720, 300);
            if (titleSelection >= 2) {
                g2.drawString(">", 680, 300);
                while (titleSelection > 2) {
                    titleSelection--;
                }
                if (KeyH.EPressed == true){
                    System.exit(0);
                }

            }
        }
        if (GameState == difSeclctState) {
            bakgroundSetter.draw(g2);
            g2.setFont(new Font("Arial", Font.PLAIN, 30));
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(Color.white);

            g2.drawString("NOOB", 700, 200);
            if (titleSelection <= 0) {
                while (titleSelection < 0) {
                    titleSelection++;
                }
                g2.drawString(">", 650, 200);
                if (KeyH.EPressed == true){
                    GameState = playState;
                    dif = 1;
                    KeyH.EPressed = false;
                }
            }

            g2.drawString("NORMAL", 700, 250);
            if (titleSelection == 1) {
                g2.drawString(">", 650, 250);
                if (KeyH.EPressed == true){
                    GameState = playState;
                    dif = 2;
                    KeyH.EPressed = false;
                }
            }

            g2.drawString("HARD", 700, 300);
            if (titleSelection == 2) {
                g2.drawString(">", 650, 300);
                if (KeyH.EPressed == true){
                    GameState = playState;
                    dif = 3;
                    KeyH.EPressed = false;
                }
            }

            g2.drawString("WHAT THE HELL!!!", 700, 350);
            if (titleSelection == 3) {
                g2.drawString(">", 650, 350);
                if (KeyH.EPressed == true){
                    GameState = playState;
                    dif = 4;
                    KeyH.EPressed = false;
                }
            }
            g2.drawString("RETURN", 700, 400);
            if (titleSelection >= 4) {
                g2.drawString(">", 650, 400);
                while (titleSelection > 4) {
                    titleSelection--;
                }
                if (KeyH.EPressed == true){
                    GameState =TitleState;
                    titleSelection = 0;
                    KeyH.EPressed = false;
                }
            }
        }
        if (GameState == playState){
            bakgroundSetter.draw(g2);
            player.draw(g2);
            projectile.draw(g2);
            crow.draw(g2);
            ui.draw(g2);
        }
        if (GameState == GameOverState){
            bakgroundSetter.draw(g2);
            ui.draw(g2);
            g2.drawString("GAME OVER", 650, 200);
            if (KeyH.EPressed == true){
                GameState =TitleState;
                titleSelection = 0;
                KeyH.EPressed = false;
                Crow.killCountCrow = 0;
                Crow.LostCountCrow = 0;
                FirstBird = true;
                ingameTimer = 0;
            }
        }
        if (GameState == pauseState){
            bakgroundSetter.draw(g2);
            player.draw(g2);
            ui.draw(g2);
            crow.draw(g2);


        }
    }
}

