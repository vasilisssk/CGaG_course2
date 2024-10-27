package ru.vsu.cs.erokhov_v_e.task_1;

import java.awt.*;

public class SysBlock {
    //private int width = 1600;
    private int height;
    private int blockWidth;
    private int blockHeight;
    private int startX;
    private int betweenLines;
    private int linesWidth;
    private boolean isSwitchedOn = false;
    private Color lampColor;
    private final static Color mainColor = Color.BLACK;
    private final static Color secondColor = new Color(60, 60, 60); // серый

    public SysBlock(int height, int blockWidth, int blockHeight, int startX, int betweenLines, int linesWidth) {
        this.height = height;
        this.blockWidth = blockWidth;
        this.blockHeight = blockHeight;
        this.startX = startX;
        this.betweenLines = betweenLines;
        this.linesWidth = linesWidth;
    }

    public void draw(Graphics2D g2d) {
        if (isSwitchedOn) {
            lampColor = Color.GREEN;
        } else {
            lampColor = secondColor;
        }
        g2d.setPaint(mainColor);
        g2d.fillRect(startX, height-blockHeight, blockWidth, blockHeight);
        g2d.setPaint(secondColor);
        g2d.fillRect(startX+((blockWidth-betweenLines-2*linesWidth)/2), height-blockHeight, linesWidth, blockHeight);
        g2d.fillRect(startX + linesWidth + betweenLines+(blockWidth-betweenLines-2*linesWidth)/2, height-blockHeight, linesWidth, blockHeight);
        g2d.fillRect(startX+((blockWidth-betweenLines-2*linesWidth)/2)+linesWidth, height-blockHeight+40, betweenLines, linesWidth);
        g2d.fillRect(startX+((blockWidth-betweenLines-2*linesWidth)/2)+linesWidth, height-blockHeight+80, betweenLines, linesWidth);

        g2d.setPaint(Color.GRAY);
        g2d.fillOval(startX+((blockWidth-betweenLines-2*linesWidth)/2)+linesWidth+70,height-blockHeight+200,20,20); // кнопка включения
        g2d.setPaint(lampColor);
        g2d.fillRect(startX+((blockWidth-betweenLines-2*linesWidth)/2)+linesWidth+70,height-blockHeight+190,20,5); // лампа
        g2d.setPaint(Color.DARK_GRAY);
        g2d.fillRect(startX+((blockWidth-betweenLines-2*linesWidth)/2)+linesWidth+10,height-blockHeight+140,10,5);
        g2d.fillRect(startX+((blockWidth-betweenLines-2*linesWidth)/2)+linesWidth+30,height-blockHeight+140,10,5);
        g2d.fillRect(startX+((blockWidth-betweenLines-2*linesWidth)/2)+linesWidth+80,height-blockHeight+140,10,5);
        g2d.setPaint(Color.RED);
        g2d.drawOval(startX+((blockWidth-betweenLines-2*linesWidth)/2)+linesWidth+50,height-blockHeight+140,5,5);
        g2d.setPaint(Color.GREEN);
        g2d.drawOval(startX+((blockWidth-betweenLines-2*linesWidth)/2)+linesWidth+60,height-blockHeight+140,5,5);
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getBlockWidth() {
        return blockWidth;
    }

    public void setBlockWidth(int blockWidth) {
        this.blockWidth = blockWidth;
    }

    public int getBlockHeight() {
        return blockHeight;
    }

    public void setBlockHeight(int blockHeight) {
        this.blockHeight = blockHeight;
    }

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getBetweenLines() {
        return betweenLines;
    }

    public void setBetweenLines(int betweenLines) {
        this.betweenLines = betweenLines;
    }

    public int getLinesWidth() {
        return linesWidth;
    }

    public void setLinesWidth(int linesWidth) {
        this.linesWidth = linesWidth;
    }

    public boolean isSwitchedOn() {
        return isSwitchedOn;
    }

    public void setSwitchedOn(boolean switchedOn) {
        isSwitchedOn = switchedOn;
    }

    public Color getLampColor() {
        return lampColor;
    }

    public void setLampColor(Color lampColor) {
        this.lampColor = lampColor;
    }
}
