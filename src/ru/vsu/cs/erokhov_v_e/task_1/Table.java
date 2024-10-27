package ru.vsu.cs.erokhov_v_e.task_1;

import java.awt.*;

public class Table implements SurfaceInfoProvider {
    private int width;
    private int height;
    private int tableWidth;
    private int tableHeight;
    private int legWidth;
    private int legShift;
    private final static Color mainColor = Color.BLACK;
    private final static Color secondColor = new Color(220, 0,0);

    public Table(int width, int height, int tableWidth, int tableHeight, int legWidth, int legShift) {
        this.width = width;
        this.height = height;
        this.tableWidth = tableWidth;
        this.tableHeight = tableHeight;
        this.legWidth = legWidth;
        this.legShift = legShift;
    }

    public void draw(Graphics2D g2d) {
        g2d.setPaint(mainColor);
        int tableShift = (width - tableWidth) / 2;
        g2d.fillRect(tableShift + legShift + legWidth, height-tableHeight+legWidth, tableWidth - 2*legWidth - 2*legShift, tableHeight-legWidth);
        g2d.setPaint(secondColor);
        g2d.fillRect(tableShift, height-tableHeight, tableWidth, legWidth);
        g2d.fillRect(tableShift + legShift, height-tableHeight+legWidth, legWidth, tableHeight-legWidth);
        g2d.fillRect(tableShift + legShift + legWidth + tableWidth - 2*legWidth - 2*legShift, height-tableHeight+legWidth, legWidth, tableHeight-legWidth);
    }

    @Override
    public int getY() {
        return tableHeight;
    }

    @Override
    public int getLeft() {
        return width - (width-tableWidth)/2;
    }

    @Override
    public int getRight() {
        return (width-tableWidth)/2;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getTableWidth() {
        return tableWidth;
    }

    public void setTableWidth(int tableWidth) {
        this.tableWidth = tableWidth;
    }

    public int getTableHeight() {
        return tableHeight;
    }

    public void setTableHeight(int tableHeight) {
        this.tableHeight = tableHeight;
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
}
