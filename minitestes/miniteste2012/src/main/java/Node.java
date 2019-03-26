public abstract class Node {
    private static int sequential_number = 0;
    private int number;

    Node(){
        this.number = ++sequential_number;
    }

    public static void resetNumbering(int sequential_number ){
        Node.sequential_number = sequential_number ;
    }

    public int getNumber() {
        return number;
    }

    public abstract Node getParent();
    public abstract String getName();
    public abstract int getSize();
}
