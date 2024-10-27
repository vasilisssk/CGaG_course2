package ru.vsu.cs.erokhov_v_e.task_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class MyPanel extends JPanel {
    private final static int WIDTH = 1600;
    private final static int HEIGHT = 900;
    private final Wallpaper wallpaper = new Wallpaper(4, 25,54);
    private final Table table = new Table(WIDTH, HEIGHT, 1200, 450, 10, 150);
    private final Stool stool = new Stool(HEIGHT, 800, 200, 20, 30, 2, table);
    private final BookShelf bookShelf = new BookShelf(300, 100, 10, 1200, 100, 10, 25, 40, 150);
    private final SysBlock sysBlock = new SysBlock(HEIGHT, 145, 300, 155, 100, 5);
    private final TrashBin trashBin = new TrashBin(HEIGHT, 1350, 150, 200, 50, 15, 20, 175);
    private final Clock clock = new Clock(50, 30,0,90,6,6);
    private final Monitor horizontalMonitor = new Monitor(HEIGHT, 500, true, 450, 250, 8, 30, 30, 100,15,4,0,45, table);
    private final Monitor verticalMonitor = new Monitor(HEIGHT, 900, false, 350, 250, 4, 30, 30, 150,15,4,0,45, table);
    private final Cactus cactus = new Cactus(HEIGHT, 300, 50, 150, 100, 80, 70, table);
    private final Devices devices = new Devices(HEIGHT, 2, 15, 9, 3, 8, 800, 25,50, table);
    private final static String openChestFile = "openChest.wav";
    private final static String closeChestFile = "closeChest.wav";
    private final static String enterWindowsFile = "enterWindows.wav";
    private final static String closeWindowsFile = "closeWindows.wav";
    private final static String dingDong = "dingdong.wav";
    private final static String CLICK_SOUND = "click.wav";
    private final static String ERROR_SOUND = "error.wav";
    private final static String CLOCK_SOUND = "clockClick.wav";
    private int clicksOnSysBlock = 0;
    private int clicksOnTrashBin = 0;
    private int clicksOnMouse = 0;
    private int time = 0;
    public Timer timer = new Timer(10, e -> {
        time++;
        if (time % 100 == 0 || time == 0) {
            clock.setMinuteStartAngle(clock.getMinuteStartAngle()-6);
            StolenClassSound.playSound(CLOCK_SOUND);
        }
        if (time % 6000 == 0) {
            clock.setHourStartAngle(clock.getHourStartAngle()-6);
            StolenClassSound.playSound(CLOCK_SOUND);
        }
        if (time % 100 == 0) { // раз в 5 сек
            cactus.grow(1);
        }
        horizontalMonitor.setStartAngle(horizontalMonitor.getStartAngle()-5);
        verticalMonitor.setStartAngle(verticalMonitor.getStartAngle()-5);
        repaint();
    });

    public MyPanel() {
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        wallpaper.draw((Graphics2D) g);
        table.draw((Graphics2D) g);
        stool.draw((Graphics2D) g);
        bookShelf.draw((Graphics2D) g);
        sysBlock.draw((Graphics2D) g);
        trashBin.draw((Graphics2D) g);
        clock.draw((Graphics2D) g);
        cactus.draw((Graphics2D) g);
        verticalMonitor.draw((Graphics2D) g);
        horizontalMonitor.draw((Graphics2D) g);
        devices.draw((Graphics2D) g);
    }

    public void mouseListeners() {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                final int x = e.getX();
                final int y = e.getY();
                final int spaceBarWidth = 5*devices.getKeysWidth();
                final int keyboardWidth = (2+8)*devices.getBetweenKeys()+8*devices.getKeysWidth()+spaceBarWidth;
                if (Math.pow((x - (sysBlock.getStartX() + ((sysBlock.getBlockWidth() - sysBlock.getBetweenLines() - 2 * sysBlock.getLinesWidth()) / 2) + sysBlock.getLinesWidth() + 70 + 10)), 2) + Math.pow((y - (sysBlock.getHeight() - sysBlock.getBlockHeight() + 200 + 10)), 2) <= Math.pow(10, 2)) {
                    clicksOnSysBlock++;
                    if (clicksOnSysBlock % 2 == 1) {
                        horizontalMonitor.setSwitchedOn(true);
                        verticalMonitor.setSwitchedOn(true);
                        sysBlock.setSwitchedOn(true);
                        horizontalMonitor.setStartAngle(0);
                        horizontalMonitor.setStartAngle(45);
                        verticalMonitor.setStartAngle(0);
                        verticalMonitor.setStartAngle(45);
                        StolenClassSound.playSound(enterWindowsFile);
                    } else {
                        horizontalMonitor.setSwitchedOn(false);
                        verticalMonitor.setSwitchedOn(false);
                        sysBlock.setSwitchedOn(false);
                        StolenClassSound.playSound(closeWindowsFile);
                    }
                    repaint();
                } else if (x >= trashBin.getStartX() + ((trashBin.getBinWidth() - trashBin.getPedalWidth()) / 2) && x <= trashBin.getStartX() + ((trashBin.getBinWidth() - trashBin.getPedalWidth()) / 2) + trashBin.getPedalWidth() &&
                        y >= trashBin.getHeight() - trashBin.getBinHeight() + (trashBin.getBinHeight() - trashBin.getPedalHeight()) - 5 && y <= trashBin.getHeight() - trashBin.getBinHeight() + (trashBin.getBinHeight() - trashBin.getPedalHeight()) - 5 + trashBin.getPedalHeight()) {
                    clicksOnTrashBin++;
                    if (clicksOnTrashBin % 2 == 1) {
                        trashBin.setOpened(true);
                        StolenClassSound.playSound(openChestFile);
                    } else {
                        trashBin.setOpened(false);
                        StolenClassSound.playSound(closeChestFile);
                    }
                    repaint();
                } else if (Math.pow((x - (devices.getStartX()+keyboardWidth+devices.getMouseShift()+devices.getMouseWidth()/2)), 2) + Math.pow((y - (devices.getHeight()-devices.getSip().getY())), 2) <= Math.pow((devices.getMouseWidth()), 2) && y <= devices.getSip().getY()) {

                    if (clicksOnMouse < 1) {
                        StolenClassSound stolenClassSound = new StolenClassSound(new File(dingDong));
                        stolenClassSound.setVolume((float) 0.75);
                        stolenClassSound.play();
                    }
                    if (verticalMonitor.isSwitchedOn()) {
                        StolenClassSound.playSound(ERROR_SOUND);
                    }
                    wallpaper.setTextWritten(true);
                    StolenClassSound.playSound(CLICK_SOUND);
                    clicksOnMouse++;
                    repaint();
                }
            }
        });
    }
}
