package com.aor.refactoring.example5;

public class CommandR extends Command {
    CommandR(Character direction){
        this.direction = direction;
    }

    @Override
    public void execute() {
        switch (direction){
            case 'N':
                direction = 'E';
                break;
            case 'W':
                direction = 'N';
                break;
            case 'S':
                direction = 'W';
                break;
            case 'E':
                direction = 'S';
                break;
        }
    }
}
