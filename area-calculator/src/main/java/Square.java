public class Square implements Shape{
    private float side;

    Square(float side){
        this.side = side;
    }

    public float getSide() {
        return side;
    }

    public void setSide(float side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return side*side;
    }
}
