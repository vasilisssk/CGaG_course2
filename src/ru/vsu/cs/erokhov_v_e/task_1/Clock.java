package ru.vsu.cs.erokhov_v_e.task_1;

import java.awt.*;

public class Clock {
    private int dimensions = 200;
    private int startX;
    private int startY;
    private int minuteStartAngle;
    private int hourStartAngle;
    private int minuteArcAngle;
    private int hourArcAngle;
    private final static Color mainColor = new Color(192,64,0);
    private final static Color secondColor = Color.DARK_GRAY;

    public Clock(int startX, int startY, int minuteStartAngle, int hourStartAngle, int minuteArcAngle, int hourArcAngle) {
        this.startX = startX;
        this.startY = startY;
        this.minuteStartAngle = minuteStartAngle;
        this.hourStartAngle = hourStartAngle;
        this.minuteArcAngle = minuteArcAngle;
        this.hourArcAngle = hourArcAngle;
    }

    public void draw(Graphics2D g2d) {
        g2d.setPaint(mainColor);
        g2d.fillOval(startX, startY, dimensions,dimensions);
        g2d.setPaint(Color.WHITE);
        g2d.fillOval(startX+20, startY+20, dimensions-40, dimensions-40);
        g2d.setPaint(secondColor);
        g2d.fillOval(startX+90, startY+90, dimensions-180, dimensions-180);
        g2d.setPaint(Color.BLACK);
        g2d.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        g2d.drawString("3", startX+dimensions-20-15, startY+dimensions/2+6);
        g2d.drawString("6",startX+dimensions/2-2, startY+dimensions-20-10);
        g2d.drawString("9", startX+20+9, startY+dimensions/2+6);
        g2d.drawString("12",startX+dimensions/2-10, startY+20+20);
        g2d.fillArc(startX+25, startY+25, 150,150,minuteStartAngle,minuteArcAngle);
        g2d.fillArc(startX+50, startY+50, 100,100,hourStartAngle,hourArcAngle);
//        g2d.fillPolygon(new int[]{startX+dimensions/2, startX+dimensions/2+49, startX+dimensions/2+53}, new int[] {startY+dimensions/2, startY+dimensions/2+60,startY+dimensions/2+57}, 3);
//        g2d.fillPolygon(new int[]{startX+dimensions/2, startX+dimensions/2-10, startX+dimensions/2-13}, new int[] {startY+dimensions/2, startY+dimensions/2-55, startY+dimensions/2-53}, 3);
    }

    public int getDimensions() {
        return dimensions;
    }

    public void setDimensions(int dimensions) {
        this.dimensions = dimensions;
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

    public int getMinuteStartAngle() {
        return minuteStartAngle;
    }

    public void setMinuteStartAngle(int minuteStartAngle) {
        this.minuteStartAngle = minuteStartAngle;
    }

    public int getHourStartAngle() {
        return hourStartAngle;
    }

    public void setHourStartAngle(int hourStartAngle) {
        this.hourStartAngle = hourStartAngle;
    }

    public int getMinuteArcAngle() {
        return minuteArcAngle;
    }

    public void setMinuteArcAngle(int minuteArcAngle) {
        this.minuteArcAngle = minuteArcAngle;
    }

    public int getHourArcAngle() {
        return hourArcAngle;
    }

    public void setHourArcAngle(int hourArcAngle) {
        this.hourArcAngle = hourArcAngle;
    }
}
