package ru.vsu.cs.erokhov_v_e.task_1;

import java.awt.*;

public class Monitor {
    // private int width = 1600;
    private int height;
    // private int tableWidth = 1200; // то же что и в Table
    private int monitorWidth;
    private int monitorHeight;
    private boolean isHorizontal;
    private int startX;
    private int frameWidth;
    private int legWidth;
    private int legHeight;
    private int restWidth;
    private int loadingIndicatorRadius;
    private int loadingIndicatorWidth;
    private  int startAngle;
    private  int arcAngle;
    private final Color LOADING_INDICATOR_COLOR = new Color(18,47,50); //тёмно-серый
    private final Color THIRD_COLOR = new Color(40,40,40); //серый
    private final Color SECOND_COLOR = new Color(18,47,170); //синий
    private final Color MAIN_COLOR = Color.BLACK;
    private Color monitorColor;
    private boolean isSwitchedOn = false;
    private SurfaceInfoProvider sip;

    public Monitor(int height, int startX, boolean isHorizontal, int monitorWidth, int monitorHeight, int frameWidth, int legWidth, int legHeight, int restWidth, int loadingIndicatorRadius, int loadingIndicatorWidth, int startAngle, int arcAngle, SurfaceInfoProvider sip) {
        this.height = height;
        this.startX = startX;
        this.isHorizontal = isHorizontal;
        this.monitorWidth = monitorWidth;
        this.monitorHeight = monitorHeight;
        this.frameWidth = frameWidth;
        this.legWidth = legWidth;
        this.legHeight = legHeight;
        this.restWidth = restWidth;
        this.loadingIndicatorRadius = loadingIndicatorRadius;
        this.loadingIndicatorWidth = loadingIndicatorWidth;
        this.startAngle = startAngle;
        this.arcAngle = arcAngle;
        this.sip = sip;
    }

    public void draw(Graphics2D g2d) {
        int monitorMiddleX = startX+monitorWidth/2;
        int monitorMiddleY = (height-sip.getY()-frameWidth-legHeight-2*frameWidth-((monitorHeight-3*frameWidth)/2));
        int monitorMiddleXH = startX+monitorHeight/2;
        int monitorMiddleYH = (height-sip.getY()-frameWidth-legHeight-2*frameWidth-((monitorWidth-3*frameWidth)/2));
        if (isSwitchedOn) {
            monitorColor = SECOND_COLOR;
        } else {
            monitorColor = THIRD_COLOR;
        }
        g2d.setPaint(MAIN_COLOR);
        if (isHorizontal) {
            g2d.fillRect(startX, height-sip.getY()-legHeight-monitorHeight-frameWidth, monitorWidth, monitorHeight);
            g2d.fillRect(startX+(monitorWidth-legWidth)/2, height-sip.getY()-frameWidth-legHeight, legWidth, legHeight);
            g2d.fillRect(startX+(monitorWidth-restWidth)/2, height-sip.getY()-frameWidth, restWidth, frameWidth);
            g2d.setPaint(monitorColor);
            g2d.fillRect(startX+frameWidth, height-sip.getY()-legHeight-monitorHeight, monitorWidth-2*frameWidth, monitorHeight-3*frameWidth);
        } else {
            g2d.fillPolygon(new int[]{startX+monitorHeight/2, startX+monitorHeight+50, startX+monitorHeight+80}, new int[]{height-sip.getY()-frameWidth-legHeight-(monitorWidth/2), height-sip.getY(), height-sip.getY()}, 3);
            g2d.fillRect(startX, height-sip.getY()-legHeight-monitorWidth-frameWidth, monitorHeight, monitorWidth);
            g2d.setPaint(monitorColor);
            g2d.fillRect(startX+frameWidth, height-sip.getY()-legHeight-monitorWidth, monitorHeight-2*frameWidth, monitorWidth-3*frameWidth);
        }
        if (isSwitchedOn && !isHorizontal) {
            g2d.setPaint(LOADING_INDICATOR_COLOR);
            g2d.fillArc(monitorMiddleXH-loadingIndicatorRadius, monitorMiddleYH-loadingIndicatorRadius, loadingIndicatorRadius*2, loadingIndicatorRadius*2, startAngle, arcAngle);
            g2d.setPaint(monitorColor);
            g2d.fillOval(monitorMiddleXH-loadingIndicatorRadius+loadingIndicatorWidth, monitorMiddleYH-loadingIndicatorRadius+loadingIndicatorWidth, (loadingIndicatorRadius-loadingIndicatorWidth)*2, (loadingIndicatorRadius-loadingIndicatorWidth)*2);
        }
        if (isSwitchedOn && isHorizontal) {
            g2d.setPaint(LOADING_INDICATOR_COLOR);
            g2d.fillArc(monitorMiddleX-loadingIndicatorRadius, monitorMiddleY-loadingIndicatorRadius, loadingIndicatorRadius*2, loadingIndicatorRadius*2, startAngle, arcAngle);
            g2d.setPaint(monitorColor);
            g2d.fillOval(monitorMiddleX-loadingIndicatorRadius+loadingIndicatorWidth, monitorMiddleY-loadingIndicatorRadius+loadingIndicatorWidth, (loadingIndicatorRadius-loadingIndicatorWidth)*2, (loadingIndicatorRadius-loadingIndicatorWidth)*2);
        }
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getMonitorWidth() {
        return monitorWidth;
    }

    public void setMonitorWidth(int monitorWidth) {
        this.monitorWidth = monitorWidth;
    }

    public int getMonitorHeight() {
        return monitorHeight;
    }

    public void setMonitorHeight(int monitorHeight) {
        this.monitorHeight = monitorHeight;
    }

    public boolean isHorizontal() {
        return isHorizontal;
    }

    public void setHorizontal(boolean horizontal) {
        isHorizontal = horizontal;
    }

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getFrameWidth() {
        return frameWidth;
    }

    public void setFrameWidth(int frameWidth) {
        this.frameWidth = frameWidth;
    }

    public int getLegWidth() {
        return legWidth;
    }

    public void setLegWidth(int legWidth) {
        this.legWidth = legWidth;
    }

    public int getLegHeight() {
        return legHeight;
    }

    public void setLegHeight(int legHeight) {
        this.legHeight = legHeight;
    }

    public int getRestWidth() {
        return restWidth;
    }

    public void setRestWidth(int restWidth) {
        this.restWidth = restWidth;
    }

    public SurfaceInfoProvider getSip() {
        return sip;
    }

    public void setSip(SurfaceInfoProvider sip) {
        this.sip = sip;
    }

    public Color getTHIRD_COLOR() {
        return THIRD_COLOR;
    }

    public Color getSECOND_COLOR() {
        return SECOND_COLOR;
    }

    public Color getMAIN_COLOR() {
        return MAIN_COLOR;
    }

    public boolean isSwitchedOn() {
        return isSwitchedOn;
    }

    public void setSwitchedOn(boolean switchedOn) {
        isSwitchedOn = switchedOn;
    }

    public Color getMonitorColor() {
        return monitorColor;
    }

    public void setMonitorColor(Color monitorColor) {
        this.monitorColor = monitorColor;
    }

    public int getLoadingIndicatorRadius() {
        return loadingIndicatorRadius;
    }

    public void setLoadingIndicatorRadius(int loadingIndicatorRadius) {
        this.loadingIndicatorRadius = loadingIndicatorRadius;
    }

    public int getLoadingIndicatorWidth() {
        return loadingIndicatorWidth;
    }

    public void setLoadingIndicatorWidth(int loadingIndicatorWidth) {
        this.loadingIndicatorWidth = loadingIndicatorWidth;
    }

    public Color getLOADING_INDICATOR_COLOR() {
        return LOADING_INDICATOR_COLOR;
    }

    public int getStartAngle() {
        return startAngle;
    }

    public void setStartAngle(int startAngle) {
        this.startAngle = startAngle;
    }

    public int getArcAngle() {
        return arcAngle;
    }

    public void setArcAngle(int arcAngle) {
        this.arcAngle = arcAngle;
    }
}
