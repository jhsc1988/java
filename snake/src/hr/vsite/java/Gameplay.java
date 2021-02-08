package hr.vsite.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.net.URL;
import java.util.Properties;
import java.util.Random;

public class Gameplay extends JPanel implements KeyListener, ActionListener {

    private final int[] snakexLength = new int[750];
    private final int[] snakeyLength = new int[750];

    private final Timer timer;

    private final int[] enemyxpos = {25, 50, 75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400, 425, 450, 475, 500, 525, 550, 575, 600, 625, 650, 675, 700, 725, 750, 775, 800, 825, 850};
    private final int[] enemyypos = {75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400, 425, 450, 475, 500, 525, 550, 575, 600, 625};
    private final Random random = new Random();
    private final String highscoreFile = "highscore";
    private final String highscorePropertie = "highscore";
    Properties props = new Properties();
    private boolean left = false;
    private boolean right = false;
    private boolean up = false;
    private boolean down = false;
    private int lengthofsnake = 3;
    private int xpos = random.nextInt(34); // total xpos
    private int ypos = random.nextInt(23); // total ypos
    private int score = 0;
    private int highscore;
    private int moves = 0;
    private int delay;
    private int gameover = 0;
    private Graphics g;

    public Gameplay() {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        delay = 100;
        timer = new Timer(delay, this);
        timer.start();

        highscore = getHighScore();
    }

    public int getHighScore() {

        FileInputStream is = null;

        try {
            File f = new File(highscoreFile);
            is = new FileInputStream(f);
        } catch (FileNotFoundException e) {
            saveHighScore(0);
        }
        try {
            props.load(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Integer.parseInt(props.getProperty(highscorePropertie, "0"));
    }

    public void saveHighScore(int newHighScore) {
        try {
            props.setProperty(highscorePropertie, String.valueOf(newHighScore));
            File f = new File(highscoreFile);
            OutputStream out = new FileOutputStream(f);
            props.store(out, "Snakey HighScore");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void paint(Graphics g) {

        if (moves == 0) {
            snakexLength[2] = 50;
            snakexLength[1] = 75;
            snakexLength[0] = 100;

            snakeyLength[2] = 100;
            snakeyLength[1] = 100;
            snakeyLength[0] = 100;
        }

        // title
        g.setColor(Color.darkGray);
        g.fillRect(24, 10, 851, 55);

        // gameplay border
        g.setColor(new Color(150, 209, 91));
        g.drawRect(24, 74, 851, 577);

        // gameplay background
        g.setColor(Color.darkGray);
        g.fillRect(25, 75, 850, 575);



        // snakey
        g.setColor(Color.darkGray);
        g.setFont(new Font("minecrafter", Font.PLAIN, 24));
        g.drawString("SNAKEY", 183, 43);

        g.setColor(new Color(150, 209, 91));
        g.setFont(new Font("minecrafter", Font.PLAIN, 24));
        g.drawString("SNAKEY", 180, 40);

        // scores
        g.setColor(Color.darkGray);
        g.setFont(new Font("minecrafter", Font.PLAIN, 14));
        g.drawString("Score: " + score, 523, 33);

        g.setColor(new Color(150, 209, 91));
        g.setFont(new Font("minecrafter", Font.PLAIN, 14));
        g.drawString("Score: " + score, 520, 30);

        // length
        g.setColor(Color.darkGray);
        g.setFont(new Font("minecrafter", Font.PLAIN, 14));
        g.drawString("Length: " + lengthofsnake, 523, 53);

        g.setColor(new Color(150, 209, 91));
        g.setFont(new Font("minecrafter", Font.PLAIN, 14));
        g.drawString("Length: " + lengthofsnake, 520, 50);

        // highscore
        g.setColor(Color.darkGray);
        g.setFont(new Font("minecrafter", Font.PLAIN, 14));
        g.drawString("Highscore: " + highscore, 683, 33);

        g.setColor(new Color(150, 209, 91));
        g.setFont(new Font("minecrafter", Font.PLAIN, 14));
        g.drawString("Highscore: " + highscore, 680, 30);

        // resources - needed for .jar
        URL headUrl = ClassLoader.getSystemResource("head.png");
        URL bodyUrl = ClassLoader.getSystemResource("body.png");
        URL body1Url = ClassLoader.getSystemResource("body1.png");
        URL body2Url = ClassLoader.getSystemResource("body2.png");
        URL body3Url = ClassLoader.getSystemResource("body3.png");
        URL body4Url = ClassLoader.getSystemResource("body4.png");
        URL enemyUrl = ClassLoader.getSystemResource("enemy.png");

        ImageIcon head = new ImageIcon(headUrl);
        head.paintIcon(this, g, snakexLength[0], snakeyLength[0]);

        if (lengthofsnake <= 4) {
            for (int a = 1; a < lengthofsnake; a++) {
                ImageIcon snakeimage = new ImageIcon(bodyUrl);
                snakeimage.paintIcon(this, g, snakexLength[a], snakeyLength[a]);
            }
        } else {
            for (int a = 1; a < lengthofsnake - 4; a++) {

                ImageIcon snakeimage = new ImageIcon(bodyUrl);
                snakeimage.paintIcon(this, g, snakexLength[a], snakeyLength[a]);
            }
            ImageIcon body1 = new ImageIcon(body1Url);
            body1.paintIcon(this, g, snakexLength[lengthofsnake - 1], snakeyLength[lengthofsnake - 1]);

            ImageIcon body2 = new ImageIcon(body2Url);
            body2.paintIcon(this, g, snakexLength[lengthofsnake - 2], snakeyLength[lengthofsnake - 2]);

            ImageIcon body3 = new ImageIcon(body3Url);
            body3.paintIcon(this, g, snakexLength[lengthofsnake - 3], snakeyLength[lengthofsnake - 3]);

            ImageIcon body4 = new ImageIcon(body4Url);
            body4.paintIcon(this, g, snakexLength[lengthofsnake - 4], snakeyLength[lengthofsnake - 4]);
        }

        ImageIcon enemyimage = new ImageIcon(enemyUrl);
        if (enemyxpos[xpos] == snakexLength[0] && enemyypos[ypos] == snakeyLength[0]) {
            score++;
            if (score % 5 == 0) {
                if (delay - 5 > 0) {
                    this.delay = delay - 5;
                    timer.setDelay(delay);
                }
            }
            if (score > highscore) {

                highscore = score;
                saveHighScore(score);
            }

            lengthofsnake++;
            xpos = random.nextInt(34);
            ypos = random.nextInt(23);
        }

        enemyimage.paintIcon(this, g, enemyxpos[xpos], enemyypos[ypos]);

        for (int b = 1; b < lengthofsnake; b++) {
            if (snakexLength[b] == snakexLength[0] && snakeyLength[b] == snakeyLength[0]) {

                gameover = 1;

                right = false;
                left = false;
                down = false;
                up = false;

                // Game Over
                g.setColor(Color.darkGray);
                g.setFont(new Font("minecrafter", Font.BOLD, 50));
                g.drawString("Game Over", 305, 305);

                g.setColor(new Color(237, 87, 130));
                g.setFont(new Font("minecrafter", Font.BOLD, 50));
                g.drawString("Game Over", 300, 300);

                // any key to restart
                g.setColor(Color.darkGray);
                g.setFont(new Font("minecrafter", Font.BOLD, 20));
                g.drawString("Any key to RESTART", 355, 345);

                g.setColor(new Color(237, 87, 130));
                g.setFont(new Font("minecrafter", Font.BOLD, 20));
                g.drawString("Any key to RESTART", 350, 340);

                // SNAKEY
                g.setColor(new Color(237, 87, 130));
                g.setFont(new Font("minecrafter", Font.PLAIN, 24));
                g.drawString("SNAKEY", 180, 40);

                g.setColor(new Color(237, 87, 130));
                g.drawRect(24, 74, 851, 577);

                //Score
                g.setColor(new Color(237, 87, 130));
                g.setFont(new Font("minecrafter", Font.PLAIN, 14));
                g.drawString("Score: " + score, 520, 30);

                // length
                g.setColor(new Color(237, 87, 130));
                g.setFont(new Font("minecrafter", Font.PLAIN, 14));
                g.drawString("Length: " + lengthofsnake, 520, 50);

                //highscore
                g.setColor(new Color(237, 87, 130));
                g.setFont(new Font("minecrafter", Font.PLAIN, 14));
                g.drawString("Highscore: " + highscore, 680, 30);
            }
        }
        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        if (right) {
            if (lengthofsnake - 1 + 1 >= 0) System.arraycopy(snakeyLength, 0, snakeyLength, 1, lengthofsnake - 1 + 1);
            for (int r = lengthofsnake; r >= 0; r--) {
                if (r == 0) {
                    snakexLength[r] = snakexLength[r] + 25;
                } else {
                    snakexLength[r] = snakexLength[r - 1];
                }
                if (snakexLength[r] > 850) {
                    snakexLength[r] = 25;
                }
            }
            repaint();
        }
        if (left) {
            if (lengthofsnake - 1 + 1 >= 0) System.arraycopy(snakeyLength, 0, snakeyLength, 1, lengthofsnake - 1 + 1);
            for (int r = lengthofsnake; r >= 0; r--) {
                if (r == 0) {
                    snakexLength[r] = snakexLength[r] - 25;
                } else {
                    snakexLength[r] = snakexLength[r - 1];
                }
                if (snakexLength[r] < 25) {
                    snakexLength[r] = 850;
                }
            }
            repaint();
        }
        if (down) {

            if (lengthofsnake - 1 + 1 >= 0) System.arraycopy(snakexLength, 0, snakexLength, 1, lengthofsnake - 1 + 1);
            for (int r = lengthofsnake; r >= 0; r--) {
                if (r == 0) {
                    snakeyLength[r] = snakeyLength[r] + 25;
                } else {
                    snakeyLength[r] = snakeyLength[r - 1];
                }
                if (snakeyLength[r] > 625) {
                    snakeyLength[r] = 75;
                }
            }
            repaint();
        }
        if (up) {
            if (lengthofsnake - 1 + 1 >= 0) System.arraycopy(snakexLength, 0, snakexLength, 1, lengthofsnake - 1 + 1);
            for (int r = lengthofsnake; r >= 0; r--) {
                if (r == 0) {
                    snakeyLength[r] = snakeyLength[r] - 25;
                } else {
                    snakeyLength[r] = snakeyLength[r - 1];
                }
                if (snakeyLength[r] < 75) {
                    snakeyLength[r] = 625;
                }
            }
            repaint();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() != 0 && gameover == 1) {
            gameover = 0;
            moves = 0;
            score = 0;
            lengthofsnake = 3;
            delay = 100;
            timer.setDelay(delay);
            highscore = getHighScore();
            repaint();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            moves++;
            right = true;
            if (!left) {
                right = true;
            } else {
                right = false;
                left = true;
            }
            down = false;
            up = false;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            moves++;
            left = true;
            if (!right) {
                left = true;
            } else {
                left = false;
                right = true;
            }
            down = false;
            up = false;
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            moves++;
            up = true;
            if (!down) {
                up = true;
            } else {
                up = false;
                down = true;
            }
            left = false;
            right = false;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            moves++;
            down = true;
            if (!up) {
                down = true;
            } else {
                down = false;
                up = true;
            }
            left = false;
            right = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
