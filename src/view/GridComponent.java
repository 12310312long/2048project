package view;

import util.ColorMap;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;

public class GridComponent extends JComponent {
    private int row;
    private int col;
    private int number;
    static Font font = new Font("Serif", Font.BOLD, 42);

    public GridComponent(int row, int col, int gridSize) {
        this.setSize(gridSize, gridSize);
        this.row = row;
        this.col = col;
        this.number = 0;
    }

    public GridComponent(int row, int col, int number, int gridSize) {
        this.setSize(gridSize, gridSize);
        this.row = row;
        this.col = col;
        this.number = number;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // 修正方法名为 paintComponent
        Color color0=new Color(205,194,181);
        Color color2=new Color(238,226,213);
        Color color4=new Color(238,222,197);
        Color color8=new Color(238,178,115);
        Color color16=new Color(246,149,98);
        Color color32=new Color(246,125,90);
        Color color64=new Color(246,93,49);
        Color color128=new Color(238,206,106);

        if (number == 0) {
            g.setColor(color0);
            g.fillRect(1, 1, getWidth() - 2, getHeight() - 2);
        } else {
            switch (number) {
                case 2:
                    g.setColor(color2);
                    break;
                case 4:
                    g.setColor(color4);
                    break;
                case 8:
                    g.setColor(color8);
                    break;
                case 16:
                    g.setColor(color16);
                    break;
                case 32:
                    g.setColor(color32);
                    break;
                case 64:
                    g.setColor(color64);
                    break;
                default:
                    // 可以在这里处理未知的 number 值
                    break;
            }
            g.fillRect(1, 1, getWidth() - 2, getHeight() - 2); // 填充整个组件区域
            g.setColor(Color.BLACK); // 假设我们想要黑色文本
            g.setFont(font);
            FontMetrics metrics = g.getFontMetrics(g.getFont());
            int textWidth = metrics.stringWidth(String.valueOf(number));
            int x = (getWidth() - textWidth) / 2;
            int y = (getHeight() - metrics.getHeight()) / 2 + metrics.getAscent();
            g.drawString(String.valueOf(number), x, y);
        }
    }


    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
