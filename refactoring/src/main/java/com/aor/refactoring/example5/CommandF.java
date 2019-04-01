package com.aor.refactoring.example5;

public class CommandF extends Command {
    private Position position;

    CommandF(Position position, char direction){
        this.position = position;
        this.direction = direction;
    }

    @Override
    public void execute() {
        this.position.move(direction);
    }
}
