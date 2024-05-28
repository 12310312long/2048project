package model;

import view.ListenerPanel;

import java.util.Arrays;
import java.util.Random;



public class GridNumber {
    private final int X_COUNT;
    private final int Y_COUNT;

    private int[][] numbers;

    public static int score = 0;
    static Random random = new Random();
    public static boolean ischanged=false;
    public GridNumber(int xCount, int yCount) {
        this.X_COUNT = xCount;
        this.Y_COUNT = yCount;
        this.numbers = new int[this.X_COUNT][this.Y_COUNT];
        this.initialNumbers();
    }

    public void initialNumbers() {
        //todo:随机生成一个2和一个4
        int colorrowfor2 = random.nextInt(numbers.length);
        int colorcolfor2 = random.nextInt(numbers.length);
        numbers[colorrowfor2][colorcolfor2] = 2;
        while (true) {
            int colorrowfor4 = random.nextInt(numbers.length);
            int colorcolfor4 = random.nextInt(numbers.length);
            if (numbers[colorrowfor4][colorcolfor4] == 0) {
                numbers[colorrowfor4][colorcolfor4] = 4;
                break;
            }
        }
    }

    public void moveRight() {
        int n = numbers.length;
        boolean ischangedTemp = false; // 使用一个临时变量来记录移动过程中是否有方块位置发生改变
        for (int i = 0; i < n; i++) {
            int mergeIndex = n - 1; // 合并位置的索引
            for (int j = n - 2; j >= 0; j--) {
                if (numbers[i][j] != 0) {
                    int k = j + 1;
                    // 寻找合适的合并位置
                    while (k <= mergeIndex) {
                        if (numbers[i][k] == 0) {
                            k++;
                        } else if (numbers[i][k] == numbers[i][j]) {
                            // 合并相同数字
                            numbers[i][k] *= 2;
                            numbers[i][j] = 0;
                            score += numbers[i][k];
                            mergeIndex = k - 1; // 更新合并位置
                            ischangedTemp = true; // 发生了合并，标记临时变量为true
                            break;
                        } else {
                            break;
                        }
                    }
                    // 移动数字到合适的位置
                    if (k - 1 != j) {
                        numbers[i][k - 1] = numbers[i][j];
                        numbers[i][j] = 0;
                        ischangedTemp = true; // 数字位置发生了移动，标记临时变量为true
                    }
                }
            }
        }
        // 更新ischanged，如果在移动过程中有方块位置发生改变，则将ischanged设置为true
        ischanged = ischangedTemp;
    }

    public void moveLeft() {
        int n = numbers.length;
        boolean ischangedTemp = false;
        for (int i = 0; i < n; i++) {
            int mergeIndex = 0; // 合并位置的索引
            for (int j = 1; j < n; j++) {
                if (numbers[i][j] != 0) {
                    int k = j - 1;
                    // 寻找合适的合并位置
                    while (k >= mergeIndex) {
                        if (numbers[i][k] == 0) {
                            k--;
                        } else if (numbers[i][k] == numbers[i][j]) {
                            // 合并相同数字
                            numbers[i][k] *= 2;
                            numbers[i][j] = 0;
                            score += numbers[i][k];
                            mergeIndex = k + 1; // 更新合并位置
                            ischangedTemp = true;
                            break;
                        } else {
                            break;
                        }
                    }
                    // 移动数字到合适的位置
                    if (k + 1 != j) {
                        numbers[i][k + 1] = numbers[i][j];
                        numbers[i][j] = 0;
                        ischangedTemp = true;
                    }
                }
            }
        }
        ischanged = ischangedTemp;
    }

    public void moveUp() {
        int n = numbers.length;
        boolean ischangedTemp = false;
        for (int j = 0; j < n; j++) {
            int mergeIndex = 0; // 合并位置的索引
            for (int i = 1; i < n; i++) {
                if (numbers[i][j] != 0) {
                    int k = i - 1;
                    // 寻找合适的合并位置
                    while (k >= mergeIndex) {
                        if (numbers[k][j] == 0) {
                            k--;
                        } else if (numbers[k][j] == numbers[i][j]) {
                            // 合并相同数字
                            numbers[k][j] *= 2;
                            numbers[i][j] = 0;
                            score += numbers[k][j];
                            mergeIndex = k + 1; // 更新合并位置
                            ischangedTemp = true;
                            break;
                        } else {
                            break;
                        }
                    }
                    // 移动数字到合适的位置
                    if (k + 1 != i) {
                        numbers[k + 1][j] = numbers[i][j];
                        numbers[i][j] = 0;
                        ischangedTemp = true;
                    }
                }
            }
        }
        ischanged = ischangedTemp;
    }

    public void moveDown() {
        int n = numbers.length;
        boolean ischangedTemp = false;
        for (int j = 0; j < n; j++) {
            int mergeIndex = n - 1; // 合并位置的索引
            for (int i = n - 2; i >= 0; i--) {
                if (numbers[i][j] != 0) {
                    int k = i + 1;
                    // 寻找合适的合并位置
                    while (k <= mergeIndex) {
                        if (numbers[k][j] == 0) {
                            k++;
                        } else if (numbers[k][j] == numbers[i][j]) {
                            // 合并相同数字
                            numbers[k][j] *= 2;
                            numbers[i][j] = 0;
                            score += numbers[k][j];
                            mergeIndex = k - 1; // 更新合并位置
                            ischangedTemp = true;
                            break;
                        } else {
                            break;
                        }
                    }
                    // 移动数字到合适的位置
                    if (k - 1 != i) {
                        numbers[k - 1][j] = numbers[i][j];
                        numbers[i][j] = 0;
                        ischangedTemp = true;
                    }
                }
            }
        }
        ischanged = ischangedTemp;
    }

    public void creatgrid() {
        int n = numbers.length;
        int randomnumber = random.nextInt(2);
        int add = (randomnumber == 0) ? 2 : 4;
        while (true) {
            int rownumber = random.nextInt(n);
            int colnumber = random.nextInt(n);
            if (numbers[rownumber][colnumber] == 0) {
                numbers[rownumber][colnumber] = add;
                break;
            }
        }
    }

    public boolean checkgrids() {
        int n = numbers.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-1; j++) {
                if (numbers[i][j]==numbers[i][j+1])return true;
            }
        }
        for (int i=0;i<n-1;i++){
            for (int j=0;j<n;j++){
                if(numbers[i][j]==numbers[i+1][j])return true;
            }
        }
        return false;
    }

    public int getNumber(int i, int j) {
        return numbers[i][j];
    }

    public void printNumber() {
        for (int[] line : numbers) {
            System.out.println(Arrays.toString(line));
        }
    }
}
