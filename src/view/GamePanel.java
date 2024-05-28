package view;

import model.GridNumber;

import javax.swing.*;
import java.awt.*;


public class GamePanel extends ListenerPanel {
    private final int COUNT = 4;
    private GridComponent[][] grids;

    private GridNumber model;
    private JLabel stepLabel;
    public int steps;
    private final int GRID_SIZE;

    public GamePanel(int size) {
        this.setVisible(true);
        this.setFocusable(true);
        this.setLayout(null);
        this.setBackground(Color.DARK_GRAY);
        this.setSize(size, size);
        this.GRID_SIZE = size / COUNT;
        this.grids = new GridComponent[COUNT][COUNT];
        this.model = new GridNumber(COUNT, COUNT);
        initialGame();

    }

    public GridNumber getModel() {
        return model;
    }

    public void initialGame() {
        this.steps = 0;
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                grids[i][j] = new GridComponent(i, j, model.getNumber(i, j), this.GRID_SIZE);
                grids[i][j].setLocation(j * GRID_SIZE, i * GRID_SIZE);
                this.add(grids[i][j]);
            }
        }
        model.printNumber();//check the 4*4 numbers in game
        this.repaint();
    }

    public void updateGridsNumber() {
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                grids[i][j].setNumber(model.getNumber(i, j));
            }
        }
        repaint();
    }

    @Override
    public void doMoveRight() {
        System.out.println("Click VK_RIGHT");
        this.model.moveRight();
        if (GridNumber.ischanged) {
            this.afterMove();
            this.model.creatgrid();
            this.updateGridsNumber();
        }
        if(!this.model.checkgrids()){

        }
    }

    public void doMoveLeft() {
        System.out.println("Click VK_LEFT");
        this.model.moveLeft();
        if (GridNumber.ischanged) {
            this.afterMove();
            this.model.creatgrid();
            this.updateGridsNumber();
        }
        if(!this.model.checkgrids()){

        }
    }

    public void doMoveUp() {
        System.out.println("Click VK_UP");
        this.model.moveUp();
        if (GridNumber.ischanged) {
            this.afterMove();
            this.model.creatgrid();
            this.updateGridsNumber();
        }
        if(!this.model.checkgrids()){

        }
    }

    public void doMoveDown() {
        System.out.println("Click VK_DOWN");
        this.model.moveDown();
        if (GridNumber.ischanged) {
            this.afterMove();
            this.model.creatgrid();
            this.updateGridsNumber();
        }
        if(!this.model.checkgrids()){

        }
    }

    public void afterMove() {
        this.stepLabel.setText(String.format("Score: %d", model.score));
    }

    public void setStepLabel(JLabel stepLabel) {
        this.stepLabel = stepLabel;
    }
}
