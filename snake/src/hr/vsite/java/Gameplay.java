package hr.vsite.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Gameplay extends JPanel implements KeyListener, ActionListener {


    private final int[] snakexLength = new int[750];
    private final int[] snakeyLength = new int[750];
    private Timer timer;
    private final int[] enemyxpos = {25, 50, 75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400, 425, 450, 475, 500, 525, 550, 575, 600, 625, 650, 675, 700, 725, 750, 775, 800, 825, 850};
    private final int[] enemyypos = {75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400, 425, 450, 475, 500, 525, 550, 575, 600, 625};
    private final Random random = new Random();
    private boolean left = false;
    private boolean right = false;
    private boolean up = false;
    private boolean down = false;
    private int lengthofsnake = 3;
    private int xpos = random.nextInt(34); // total xpos
    private int ypos = random.nextInt(23); // total ypos

    private int score = 0;
    private int moves = 0;
    private int delay = 0;
    private int gameover = 0;

    private Graphics g;

    public Gameplay() {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        delay = 100;
        timer = new Timer(delay, this);
        timer.start();
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
        // draw title image border
        g.setColor(Color.darkGray);
        g.fillRect(24, 10, 851, 55);

        // draw the title image
        ImageIcon titleImage = new ImageIcon("fold.png");
        titleImage.paintIcon(this, g, 25, 11);

        // draw border for gameplay
        g.setColor(Color.BLACK);
        g.drawRect(24, 74, 851, 577);

        // draw background for the gameplay
        g.setColor(Color.darkGray);
        g.fillRect(25, 75, 850, 575);

        // draw scores
        g.setColor(new Color(150, 209, 91));
        g.setFont(new Font("minecrafter", Font.PLAIN, 14));
        g.drawString("Scores: " + score, 780, 30);

        // draw length
        g.setColor(new Color(150, 209, 91));
        g.setFont(new Font("minecrafter", Font.PLAIN, 14));
        g.drawString("Length: " + lengthofsnake, 780, 50);

        ImageIcon rightmouth = new ImageIcon("head.png");
        rightmouth.paintIcon(this, g, snakexLength[0], snakeyLength[0]);

        for (int a = 0; a < lengthofsnake; a++) {

            if (a == 0 && right) {
                rightmouth = new ImageIcon("head.png");
                rightmouth.paintIcon(this, g, snakexLength[a], snakeyLength[a]);
            }
            if (a == 0 && left) {
                ImageIcon leftmouth = new ImageIcon("head.png");
                leftmouth.paintIcon(this, g, snakexLength[a], snakeyLength[a]);
            }
            if (a == 0 && down) {
                ImageIcon downmouth = new ImageIcon("head.png");
                downmouth.paintIcon(this, g, snakexLength[a], snakeyLength[a]);
            }
            if (a == 0 && up) {
                ImageIcon upmouth = new ImageIcon("head.png");
                upmouth.paintIcon(this, g, snakexLength[a], snakeyLength[a]);
            }
            if (a != 0) {
                ImageIcon snakeimage = new ImageIcon("body.png");
                snakeimage.paintIcon(this, g, snakexLength[a], snakeyLength[a]);
            }

        }

        ImageIcon enemyimage = new ImageIcon("enemy.png");
        if (enemyxpos[xpos] == snakexLength[0] && enemyypos[ypos] == snakeyLength[0]) {
            score++;
            if (score % 5 == 0){
                this.delay = delay - 5;
                timer.setDelay(delay);
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

                g.setColor(new Color(150, 209, 91));
                g.setFont(new Font("minecrafter", Font.BOLD, 50));
                g.drawString("Game Over", 300, 300);

                g.setFont(new Font("minecrafter", Font.BOLD, 20));
                g.drawString("Any key to RESTART", 350, 340);


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
    public void keyTyped(KeyEvent e) {

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
            repaint();
        }
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
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
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
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
        }

        else if (e.getKeyCode() == KeyEvent.VK_UP) {
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
        }

        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
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
    public void keyReleased(KeyEvent e) {

    }
}
