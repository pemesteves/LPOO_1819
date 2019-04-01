package com.aor.refactoring.example5;

public class CommandL extends Command {
    CommandL(Character direction){
        this.direction = direction;
    }

    @Override
    public void execute() {
        switch (direction){
            case 'N':
                direction = 'W';
                break;
            case 'W':
                direction = 'S';
                break;
            case 'S':
                direction = 'E';
                break;
            case 'E':
                direction = 'N';
                break;
        }
    }
}
