import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.io.IOException;

public abstract class Element {
    protected Position position;

    public Element(int x, int y){
        position = new Position(x, y);
    }

    public abstract void draw(TextGraphics graphics) throws IOException;

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
