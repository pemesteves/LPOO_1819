package com.aor.refactoring.example5;

public class Position {
    private int row;
    private int column;

    Position(int row, int column){
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public void move(char direction){
        switch (direction) {
            case 'N':
                row--;
                break;
            case 'S':
                row++;
                break;
            case 'W':
                column--;
                break;
            case 'E':
                column++;
                break;
        }
    }
}
