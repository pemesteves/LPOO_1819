import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.io.IOException;
import java.util.Random;

public class Monster extends Element {
    public Monster(int x, int y){
        super(x, y);
    }

    public Position move(){
        Random random = new Random();
        int r = random.nextInt(4);

        switch (r){
            case 0:
                return new Position(position.getX() - 1, position.getY());
            case 1:
                return new Position(position.getX() + 1, position.getY());
            case 2:
                return new Position(position.getX(), position.getY() - 1);
            case 3:
                return new Position(position.getX(), position.getY() + 1);
            default:
                return position;
        }
    }

    public void draw(TextGraphics graphics) throws IOException {
        graphics.setForegroundColor(TextColor.Factory.fromString("#7D2727"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "x");
    }
}
