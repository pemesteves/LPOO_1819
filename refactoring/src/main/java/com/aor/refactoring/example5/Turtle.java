package com.aor.refactoring.example5;

public class Turtle {
    private Position position;
    private char direction;

    public Turtle(int row, int column, char direction) {
        this.position = new Position(row, column);
        this.direction = direction;
    }

    public int getRow() {
        return this.position.getRow();
    }

    public int getColumn() {
        return this.position.getColumn();
    }

    public char getDirection() {
        return direction;
    }

    public void execute(char command) {

        Command command1;
        if(command == 'L'){
            command1 = new CommandL(direction);
            command1.execute();
            direction = command1.getDirection();
            return;
        }

        if(command == 'R'){
            command1 = new CommandR(direction);
            command1.execute();
            direction = command1.getDirection();
            return;
        }

        if (command == 'F') {
            command1 = new CommandF(position, direction);
            command1.execute();
        }
    }
}
