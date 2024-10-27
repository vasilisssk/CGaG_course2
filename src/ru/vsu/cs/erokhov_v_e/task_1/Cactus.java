package ru.vsu.cs.erokhov_v_e.task_1;

import java.awt.*;
import java.util.Random;

public class Cactus {
    //private int width = 1600;
    private int height;
    //private int tableWidth = 1200;
    private int startX;
    private int cactusWidth;
    private int cactusHeight;
    private int potWidth;
    private int bottomPotWidth;
    private int potHeight;
    private final static Color potColor = new Color(92,0,0);
    private final static Color cactusColor = new Color(0,156,21);
    private static final Color[] spikesColors = {Color.RED, Color.ORANGE, Color.PINK, new Color (1, 50, 32)};
    private final Color spikesColor = spikesColors[rnd.nextInt(0, 4)];
    private final static Random rnd = new Random();
    private SurfaceInfoProvider sip;

    public Cactus(int height, int startX, int cactusWidth, int cactusHeight, int potWidth, int bottomPotWidth, int potHeight, SurfaceInfoProvider sip) throws HeadlessException {
        this.height = height;
        this.startX = startX;
        this.cactusWidth = cactusWidth;
        this.cactusHeight = cactusHeight;
        this.potWidth = potWidth;
        this.bottomPotWidth = bottomPotWidth;
        this.potHeight = potHeight;
        this.sip = sip;
    }

    public void draw(Graphics2D g2d) {
        g2d.setPaint(potColor);
        g2d.fillPolygon(new int[]{startX, startX+potWidth, startX+(potWidth-bottomPotWidth)/2+bottomPotWidth, startX+(potWidth-bottomPotWidth)/2}, new int[]{height-sip.getY()-potHeight, height-sip.getY()-potHeight, height-sip.getY(), height-sip.getY()}, 4);
        g2d.setPaint(cactusColor);
        g2d.fillRect(startX+(potWidth-cactusWidth)/2, height-sip.getY()-potHeight-cactusHeight, cactusWidth, cactusHeight);
        g2d.fillOval(startX+(potWidth-cactusWidth)/2, height-sip.getY()-potHeight-cactusHeight-cactusWidth/2, cactusWidth, cactusWidth);

        g2d.setPaint(spikesColor);
        for (int i = startX+(potWidth-cactusWidth)/2; i <= startX+cactusWidth+(potWidth-cactusWidth)/2; i+=5) {
            for (int j = height-sip.getY()-potHeight-cactusHeight; j <= height-sip.getY()-potHeight; j+=5) {
                if (i > startX+(potWidth-cactusWidth)/2+cactusWidth/2) {
                    g2d.drawLine(i,j,i+3,j-3);
                } else {
                    g2d.drawLine(i,j,i-3,j-3);
                }
            }
        }
        for (int i = startX+(potWidth-cactusWidth)/2; i < startX+cactusWidth+(potWidth-cactusWidth)/2; i+=3) {
            for (int j = height-sip.getY()-potHeight-cactusHeight-cactusWidth/2; j < height-sip.getY()-potHeight-cactusHeight; j+=6) {
                if (Math.pow((i-(startX+(potWidth-cactusWidth)/2+cactusWidth/2)),2)+Math.pow((j-(height-sip.getY()-potHeight-cactusHeight)),2) < Math.pow(cactusWidth/2,2)) {
                    if (i >= startX+(potWidth-cactusWidth)/2+cactusWidth/2) {
                        g2d.drawLine(i,j,i+3,j-3);
                    } else {
                        g2d.drawLine(i,j,i-3,j-3);
                    }
                }
            }
        }
    }

    public void grow(int diff) {
        cactusHeight+=diff;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getCactusWidth() {
        return cactusWidth;
    }

    public void setCactusWidth(int cactusWidth) {
        this.cactusWidth = cactusWidth;
    }

    public int getCactusHeight() {
        return cactusHeight;
    }

    public void setCactusHeight(int cactusHeight) {
        this.cactusHeight = cactusHeight;
    }

    public int getPotWidth() {
        return potWidth;
    }

    public void setPotWidth(int potWidth) {
        this.potWidth = potWidth;
    }

    public int getBottomPotWidth() {
        return bottomPotWidth;
    }

    public void setBottomPotWidth(int bottomPotWidth) {
        this.bottomPotWidth = bottomPotWidth;
    }

    public int getPotHeight() {
        return potHeight;
    }

    public void setPotHeight(int potHeight) {
        this.potHeight = potHeight;
    }
}
