package ru.vsu.cs.erokhov_v_e.task_1;

import java.awt.*;

public class Wallpaper {
    private final static int HEIGHT = 1080;
    private final static int WIDTH = 1920;
    private final int panelWidth = 1600;
    private final int panelHeight = 900;
    private int linesWidth;
    private int betweenLines;
    private int fontSize;
    private boolean isTextWritten = false;
    private Color mainColor = new Color(188,157,83);
    private Color lineColor = new Color(140, 117, 63);
    private Color floorColor = new Color(115,52,24);

    public Wallpaper(int linesWidth, int betweenLines, int fontSize) {
        this.linesWidth = linesWidth;
        this.betweenLines = betweenLines;
        this.fontSize = fontSize;
    }

    public void draw(Graphics2D g2d) {
        final int textStartX = 1275;
        final int textStartY = 270;
        g2d.setPaint(mainColor);
        g2d.fillRect(0, 0, WIDTH, HEIGHT);
        g2d.setPaint(floorColor);
        g2d.fillRect(0, 900, WIDTH, HEIGHT);
        for (int i = 1; ; i++) {
            g2d.setPaint(lineColor);
            int x = linesWidth * (i-1) + betweenLines * (i-1);
            g2d.fillRect(x, 0, linesWidth, 900);
            if (x > WIDTH) {
                break;
            }
        }
        GradientPaint gradientPaint = new GradientPaint(panelWidth/2, panelHeight/2, new Color(0,0,0,0), panelWidth/2, panelHeight, new Color(0,0,0,100));
        g2d.setPaint(gradientPaint);
        g2d.fillRect(0,0,WIDTH,panelHeight);
        g2d.setPaint(new Color(100,100,100, 255));
        g2d.setFont(new Font("Impact", Font.BOLD, fontSize));
        if (isTextWritten) {
            g2d.drawString("Ding Dong", textStartX, textStartY);
            g2d.drawString("Eat it up", textStartX, textStartY+fontSize);
            g2d.drawString("Eat it well", textStartX, textStartY+fontSize*2);
            g2d.drawString("And mix it up", textStartX, textStartY+fontSize*3);
        }
    }

    public boolean isTextWritten() {
        return isTextWritten;
    }

    public void setTextWritten(boolean textWritten) {
        isTextWritten = textWritten;
    }
}
