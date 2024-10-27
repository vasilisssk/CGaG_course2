package ru.vsu.cs.erokhov_v_e.task_1;

import javax.swing.*;

public class MainFrame extends JDialog {
    private JPanel contentPane;
    private JPanel panelPaintArea;

    public MainFrame() {
        setContentPane(contentPane);
        setTitle("ООП - таск №1");
        setModal(true);
        MyPanel myPanel = new MyPanel();
        panelPaintArea.add(myPanel);
        myPanel.mouseListeners();
    }

    public static void main(String[] args) {
        MainFrame dialog = new MainFrame();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
