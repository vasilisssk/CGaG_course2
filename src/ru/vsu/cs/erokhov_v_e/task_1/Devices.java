package ru.vsu.cs.erokhov_v_e.task_1;

import java.awt.*;

public class Devices {
    private int height;
    //private int tableWidth = 1200;
    private int betweenKeys;
    private int keysWidth;
    private int keysUpperWidth;
    private int keysHeight;
    private int keyboardHeight;
    private int startX;
    private int mouseWidth;
    private int mouseShift;
    private final static Color mainColor = Color.BLACK;
    private final static Color keysColor = new Color(60,60,60);
    private SurfaceInfoProvider sip;

    public Devices(int height, int betweenKeys, int keysWidth, int keysUpperWidth, int keysHeight, int keyboardHeight, int startX, int mouseWidth, int mouseShift, SurfaceInfoProvider sip) {
        this.height = height;
        this.betweenKeys = betweenKeys;
        this.keysWidth = keysWidth;
        this.keysUpperWidth = keysUpperWidth;
        this.keysHeight = keysHeight;
        this.keyboardHeight = keyboardHeight;
        this.startX = startX;
        this.mouseWidth = mouseWidth;
        this.mouseShift = mouseShift;
        this.sip = sip;
    }

    public void draw(Graphics2D g2d) {
        final int spaceBarWidth = 5*getKeysWidth();
        final int keyboardWidth = (2+8)*getBetweenKeys()+8*getKeysWidth()+spaceBarWidth;
        final int upperShift = (keysWidth-keysUpperWidth)/2;
        g2d.setPaint(mainColor);
        g2d.fillRect(startX, height-sip.getY()-keyboardHeight, keyboardWidth, keyboardHeight);
        int upperShiftCount = 1;
        g2d.setPaint(keysColor);
        for (int i = 1; i <= 4; i++) {
            if (i <= 3) {
                g2d.fillPolygon(new int[]{startX+betweenKeys*i+keysWidth*(i-1), startX+betweenKeys*i+keysWidth*i, startX+betweenKeys*i+upperShift*upperShiftCount+keysUpperWidth*i, startX+betweenKeys*i+upperShift*upperShiftCount+keysUpperWidth*(i-1)}, new int[]{height-sip.getY()-keyboardHeight, height-sip.getY()-keyboardHeight, height-sip.getY()-keyboardHeight-keysHeight, height-sip.getY()-keyboardHeight-keysHeight}, 4);
                upperShiftCount+=2;
            }
            if (i == 4) {
                g2d.fillPolygon(new int[]{startX+betweenKeys*i+keysWidth*(i-1), startX+betweenKeys*i+keysWidth*(i-1)+spaceBarWidth, startX+betweenKeys*i+upperShift*upperShiftCount+keysUpperWidth*(i-1)+spaceBarWidth-upperShiftCount, startX+betweenKeys*i+upperShift*upperShiftCount+keysUpperWidth*(i-1)}, new int[]{height-sip.getY()-keyboardHeight, height-sip.getY()-keyboardHeight, height-sip.getY()-keyboardHeight-keysHeight, height-sip.getY()-keyboardHeight-keysHeight}, 4);
            }
        }
        int nextPos = startX+betweenKeys*4+keysWidth*(4-1)+spaceBarWidth;
        int upperShiftCount2 = 1;
        for (int i = 1; i <= 5; i++) {
            g2d.fillPolygon(new int[]{nextPos+betweenKeys*i+keysWidth*(i-1), nextPos+betweenKeys*i+keysWidth*i, nextPos+betweenKeys*i+upperShift*upperShiftCount2+keysUpperWidth*i, nextPos+betweenKeys*i+upperShift*upperShiftCount2+keysUpperWidth*(i-1)}, new int[]{height-sip.getY()-keyboardHeight, height-sip.getY()-keyboardHeight, height-sip.getY()-keyboardHeight-keysHeight, height-sip.getY()-keyboardHeight-keysHeight}, 4);
            upperShiftCount2+=2;
        }
        g2d.setColor(Color.BLACK);
        g2d.fillArc(startX+keyboardWidth+mouseShift, height-sip.getY()-mouseWidth/2, mouseWidth, mouseWidth, 0,180);
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getBetweenKeys() {
        return betweenKeys;
    }

    public void setBetweenKeys(int betweenKeys) {
        this.betweenKeys = betweenKeys;
    }

    public int getKeysWidth() {
        return keysWidth;
    }

    public void setKeysWidth(int keysWidth) {
        this.keysWidth = keysWidth;
    }

    public int getKeysUpperWidth() {
        return keysUpperWidth;
    }

    public void setKeysUpperWidth(int keysUpperWidth) {
        this.keysUpperWidth = keysUpperWidth;
    }

    public int getKeysHeight() {
        return keysHeight;
    }

    public void setKeysHeight(int keysHeight) {
        this.keysHeight = keysHeight;
    }

    public int getKeyboardHeight() {
        return keyboardHeight;
    }

    public void setKeyboardHeight(int keyboardHeight) {
        this.keyboardHeight = keyboardHeight;
    }

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getMouseWidth() {
        return mouseWidth;
    }

    public void setMouseWidth(int mouseWidth) {
        this.mouseWidth = mouseWidth;
    }

    public int getMouseShift() {
        return mouseShift;
    }

    public void setMouseShift(int mouseShift) {
        this.mouseShift = mouseShift;
    }

    public SurfaceInfoProvider getSip() {
        return sip;
    }

    public void setSip(SurfaceInfoProvider sip) {
        this.sip = sip;
    }
}
