public class Triangle implements Shape {
    private float base;
    private float height;

    public Triangle(float base, float height) {
        this.base = base;
        this.height = height;
    }

    public float getBase() {
        return base;
    }

    public void setBase(float base) {
        this.base = base;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    @Override
    public double getArea() {
        return height*base/2;
    }
}
