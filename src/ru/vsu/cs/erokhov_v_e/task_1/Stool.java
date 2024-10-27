package ru.vsu.cs.erokhov_v_e.task_1;

import java.awt.*;

public class Stool {
    private int height;
    private int startX;
    private int stoolWidth;
    private int legWidth;
    private int legShift;
    private int carpetHeight;
    private final static Color mainColor = new Color (166, 110, 49);
    private final static Color secondColor = Color.BLUE;
    private SurfaceInfoProvider sip;

    public Stool(int height, int startX, int stoolWidth, int legWidth, int legShift, int carpetHeight, SurfaceInfoProvider sip) {
        this.height = height;
        this.startX = startX;
        this.stoolWidth = stoolWidth;
        this.legWidth = legWidth;
        this.legShift = legShift;
        this.carpetHeight = carpetHeight;
        this.sip = sip;
    }

    public void draw(Graphics2D g2d) {
        final int stoolHeight = (int) (sip.getY() / 1.75);
        g2d.setPaint(mainColor);
        g2d.fillRect(startX, height - stoolHeight, stoolWidth, legWidth);
        g2d.fillRect(startX+legShift, height - stoolHeight + legWidth, legWidth, stoolHeight - legWidth);
        g2d.fillRect(startX+legShift+(stoolWidth-2*legShift-legWidth), height - stoolHeight + legWidth, legWidth, stoolHeight - legWidth);
        g2d.fillRect(startX+legShift+legWidth, height - stoolHeight + stoolHeight / 2, stoolWidth-2*legShift-legWidth, legWidth);
        g2d.setPaint(secondColor);
        g2d.fillRect(startX, height - stoolHeight - carpetHeight, stoolWidth-5, carpetHeight);
        g2d.fillPolygon(new int[]{startX, startX + legShift + 5, startX + stoolWidth/2}, new int[]{height-stoolHeight, height-stoolHeight+50, height-stoolHeight}, 3);
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

    public int getStoolWidth() {
        return stoolWidth;
    }

    public void setStoolWidth(int stoolWidth) {
        this.stoolWidth = stoolWidth;
    }

    public int getLegWidth() {
        return legWidth;
    }

    public void setLegWidth(int legWidth) {
        this.legWidth = legWidth;
    }

    public int getLegShift() {
        return legShift;
    }

    public void setLegShift(int legShift) {
        this.legShift = legShift;
    }

    public int getCarpetHeight() {
        return carpetHeight;
    }

    public void setCarpetHeight(int carpetHeight) {
        this.carpetHeight = carpetHeight;
    }
}
