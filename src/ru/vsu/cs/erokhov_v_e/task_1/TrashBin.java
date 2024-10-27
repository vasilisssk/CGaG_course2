package ru.vsu.cs.erokhov_v_e.task_1;

import java.awt.*;

public class TrashBin {
    // private int width;
    private int height;
    private int startX;
    private int binWidth;
    private int binHeight;
    private int pedalWidth;
    private int pedalHeight;
    private int lidHeight;
    private int mainPartHeight;
    private final Color mainColor = new Color(134, 134, 134);
    private final Color secondColor = new Color(17, 17, 17);
    private boolean isOpened = false;

    public TrashBin(int height, int startX, int binWidth, int binHeight, int pedalWidth, int pedalHeight, int lidHeight, int mainPartHeight) {
        this.height = height;
        this.startX = startX;
        this.binWidth = binWidth;
        this.binHeight = binHeight;
        this.pedalWidth = pedalWidth;
        this.pedalHeight = pedalHeight;
        this.lidHeight = lidHeight;
        this.mainPartHeight = mainPartHeight;
    }

    public void draw(Graphics2D g2d) {
        if (!isOpened) {
            int lineHeight = binHeight-lidHeight-mainPartHeight;
            g2d.setPaint(mainColor);
            g2d.fillRect(startX, height-binHeight, binWidth, lidHeight); //lid
            g2d.fillRect(startX, height-mainPartHeight, binWidth, mainPartHeight); //main part
            g2d.setPaint(Color.BLACK);
            g2d.fillRect(startX, height-binHeight+lidHeight, binWidth, lineHeight); //line
            g2d.setPaint(secondColor);
            g2d.fillRect(startX+((binWidth-pedalWidth)/2), height-binHeight+(binHeight-pedalHeight)-5, pedalWidth, pedalHeight); //pedal
        } else {
            int secondDiameter = (int) (binWidth / 1.1);
            int secondDiameterShift = (binWidth-secondDiameter)/2;

            int lineHeight = binHeight-lidHeight-mainPartHeight;
            g2d.setPaint(mainColor);
            g2d.fillRect(startX, height-mainPartHeight, binWidth, mainPartHeight); //main part
            g2d.setPaint(Color.BLACK);
            g2d.fillRect(startX, height-binHeight+lidHeight, binWidth, lineHeight); //line
            g2d.setPaint(secondColor);
            g2d.fillRect(startX+((binWidth-pedalWidth)/2), height-binHeight+(binHeight-pedalHeight)-5, pedalWidth, pedalHeight); //pedal

            g2d.setPaint(mainColor);
            g2d.fillOval(startX, height-binHeight-binWidth+lidHeight, binWidth, binWidth);
            g2d.setPaint(secondColor);
            g2d.fillOval(startX+secondDiameterShift, height-binHeight-secondDiameterShift-secondDiameter+lidHeight, secondDiameter, secondDiameter);
        }

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

    public int getBinWidth() {
        return binWidth;
    }

    public void setBinWidth(int binWidth) {
        this.binWidth = binWidth;
    }

    public int getBinHeight() {
        return binHeight;
    }

    public void setBinHeight(int binHeight) {
        this.binHeight = binHeight;
    }

    public int getPedalWidth() {
        return pedalWidth;
    }

    public void setPedalWidth(int pedalWidth) {
        this.pedalWidth = pedalWidth;
    }

    public int getPedalHeight() {
        return pedalHeight;
    }

    public void setPedalHeight(int pedalHeight) {
        this.pedalHeight = pedalHeight;
    }

    public Color getMainColor() {
        return mainColor;
    }

    public Color getSecondColor() {
        return secondColor;
    }

    public int getLidHeight() {
        return lidHeight;
    }

    public void setLidHeight(int lidHeight) {
        this.lidHeight = lidHeight;
    }

    public int getMainPartHeight() {
        return mainPartHeight;
    }

    public void setMainPartHeight(int mainPartHeight) {
        this.mainPartHeight = mainPartHeight;
    }

    public boolean isOpened() {
        return isOpened;
    }

    public void setOpened(boolean opened) {
        isOpened = opened;
    }
}
