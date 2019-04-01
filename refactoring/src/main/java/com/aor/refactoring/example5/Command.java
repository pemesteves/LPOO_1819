package com.aor.refactoring.example5;

public abstract class Command {
    protected char direction;

    public abstract void execute();

    public char getDirection(){
        return this.direction;
    }
}
