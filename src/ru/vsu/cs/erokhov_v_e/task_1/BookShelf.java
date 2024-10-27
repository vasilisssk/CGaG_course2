package ru.vsu.cs.erokhov_v_e.task_1;

import java.awt.*;
import java.util.Random;

public class BookShelf { //кто прочитал, тот умрёт (или нет)
    private int shelfWidth;
    private int shelfHeight;
    private int wallWidth;
    private int startX;
    private int startY;
    private int firstBookWidth;
    private int secondBookWidth;
    private int thirdBookWidth;
    private int forthBookHeight;
    private final static Color mainColor = new Color(149, 77, 0);
    private final static Color secondColor = new Color(103, 53, 0);
    private final static Random rnd = new Random();
    private final Color[] basicColors = {Color.BLUE, Color.BLACK, Color.GRAY, Color.GREEN, Color.ORANGE, Color.MAGENTA, Color.WHITE};
    private final Color firstBookColor = basicColors[rnd.nextInt(0,7)];
    private final Color secondBookColor = basicColors[rnd.nextInt(0,7)];
    private final Color thirdBookColor = basicColors[rnd.nextInt(0,7)];
    private final Color forthBookColor = basicColors[rnd.nextInt(0,7)];

    public BookShelf(int shelfWidth, int shelfHeight, int wallWidth, int startX, int startY, int firstBookWidth, int secondBookWidth, int thirdBookWidth, int forthBookHeight) {
        this.shelfWidth = shelfWidth;
        this.shelfHeight = shelfHeight;
        this.wallWidth = wallWidth;
        this.startX = startX;
        this.startY = startY;
        this.firstBookWidth = firstBookWidth;
        this.secondBookWidth = secondBookWidth;
        this.thirdBookWidth = thirdBookWidth;
        this.forthBookHeight = forthBookHeight;
    }

    public void draw(Graphics2D g2d) {
        g2d.setPaint(mainColor);
        g2d.fillRect(startX + wallWidth, startY, shelfWidth-wallWidth, shelfHeight-wallWidth);
        g2d.setPaint(secondColor);
        g2d.fillRect(startX, startY, wallWidth, shelfHeight);
        g2d.fillRect(startX+wallWidth+(shelfWidth-2*wallWidth), startY, wallWidth, shelfHeight);
        g2d.fillRect(startX+wallWidth, startY+shelfHeight-wallWidth, shelfWidth-wallWidth, wallWidth);
        g2d.setPaint(firstBookColor);
        g2d.fillRect(startX+wallWidth, startY, firstBookWidth, shelfHeight-wallWidth);
        g2d.setPaint(secondBookColor);
        g2d.fillRect(startX+wallWidth+firstBookWidth, startY+20, secondBookWidth, shelfHeight-wallWidth-20);
        g2d.setPaint(thirdBookColor);
        g2d.fillRect(startX+wallWidth+firstBookWidth+secondBookWidth, startY-15, thirdBookWidth, shelfHeight-wallWidth+15);
        g2d.setPaint(forthBookColor);
        g2d.fillRect(startX+wallWidth+firstBookWidth+secondBookWidth+thirdBookWidth+30, startY+50, forthBookHeight, shelfHeight-wallWidth-50);

        g2d.setPaint(Color.BLACK);
        g2d.drawRect(startX+wallWidth, startY, firstBookWidth, shelfHeight-wallWidth);
        g2d.drawRect(startX+wallWidth+firstBookWidth, startY+20, secondBookWidth, shelfHeight-wallWidth-20);
        g2d.drawRect(startX+wallWidth+firstBookWidth+secondBookWidth, startY-15, thirdBookWidth, shelfHeight-wallWidth+15);
        g2d.drawRect(startX+wallWidth+firstBookWidth+secondBookWidth+thirdBookWidth+30, startY+50, forthBookHeight, shelfHeight-wallWidth-50);
    }

    public int getShelfWidth() {
        return shelfWidth;
    }

    public void setShelfWidth(int shelfWidth) {
        this.shelfWidth = shelfWidth;
    }

    public int getShelfHeight() {
        return shelfHeight;
    }

    public void setShelfHeight(int shelfHeight) {
        this.shelfHeight = shelfHeight;
    }

    public int getWallWidth() {
        return wallWidth;
    }

    public void setWallWidth(int wallWidth) {
        this.wallWidth = wallWidth;
    }

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public int getFirstBookWidth() {
        return firstBookWidth;
    }

    public void setFirstBookWidth(int firstBookWidth) {
        this.firstBookWidth = firstBookWidth;
    }

    public int getSecondBookWidth() {
        return secondBookWidth;
    }

    public void setSecondBookWidth(int secondBookWidth) {
        this.secondBookWidth = secondBookWidth;
    }

    public int getThirdBookWidth() {
        return thirdBookWidth;
    }

    public void setThirdBookWidth(int thirdBookWidth) {
        this.thirdBookWidth = thirdBookWidth;
    }

    public int getForthBookHeight() {
        return forthBookHeight;
    }

    public void setForthBookHeight(int forthBookHeight) {
        this.forthBookHeight = forthBookHeight;
    }

    public Color[] getBasicColors() {
        return basicColors;
    }

    public Color getFirstBookColor() {
        return firstBookColor;
    }

    public Color getSecondBookColor() {
        return secondBookColor;
    }

    public Color getThirdBookColor() {
        return thirdBookColor;
    }

    public Color getForthBookColor() {
        return forthBookColor;
    }
}
