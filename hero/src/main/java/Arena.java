import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    private int width;
    private int height;
    private Hero hero;
    private List<Wall> walls;
    private List<Coin> coins;
    private List<Monster> monsters;

    Arena(int width, int height){
        this.width = width;
        this.height = height;
        hero = new Hero(10, 10);
        this.walls = createWalls();
        this.coins = createCoins();
        this.monsters = createMonsters();
    }

    public void processKey(KeyStroke key){
        Position newPosition;
        switch(key.getKeyType()) {
            case ArrowLeft:
                newPosition = hero.moveLeft();
                break;
            case ArrowRight:
                newPosition = hero.moveRight();
                break;
            case ArrowUp:
                newPosition = hero.moveUp();
                break;
            case ArrowDown:
                newPosition = hero.moveDown();
                break;
            default:
                System.out.println(key);
                newPosition = hero.getPosition();
                break;
        }

        moveHero(newPosition);
        moveMonsters();
    }

    public void draw(TextGraphics graphics) throws IOException{
        //screen.setCharacter(hero.getPosition().getX(), hero.getPosition().getY(), new TextCharacter('X'));
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');

        for (Wall wall : walls)
            wall.draw(graphics);

        for(Coin coin : coins)
            coin.draw(graphics);

        hero.draw(graphics);

        for(Monster monster : monsters)
            monster.draw(graphics);

        verifyMonsterCollisions();
    }

    public void moveHero(Position position) {
        if (canMove(position))
            hero.setPosition(position);

        canCollectCoin(hero.getPosition());
    }

    private boolean canMove(Position position) {
        for (Wall wall : walls) {
            if (wall.getPosition().equals(position))
                return false;
        }

        return true;
    }

    private void canCollectCoin(Position position){
        for(Coin coin : coins){
            if(coin.getPosition().equals(position)){
                coins.remove(coin);
                return;
            }
        }
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }

        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }

        return walls;
    }

    private List<Coin> createCoins() {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            coins.add(new Coin(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1));
        return coins;
    }

    private List<Monster> createMonsters(){
        Random random = new Random();
        ArrayList<Monster> monsters = new ArrayList<>();
        for (int i = 0; i < 3; i++)
            monsters.add(new Monster(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1));
        return monsters;
    }

    public void moveMonsters(){
        Position p;
        for(Monster monster : monsters){
            do{
                p = monster.move();
            }while(!canMove(p));

            monster.setPosition(p);
        }
    }

    public void verifyMonsterCollisions(){
        for (Monster monster : monsters) {
            if (monster.getPosition().equals(hero.getPosition())) {
                System.out.println("You died");
                System.exit(0);
            }
        }

    }
}
