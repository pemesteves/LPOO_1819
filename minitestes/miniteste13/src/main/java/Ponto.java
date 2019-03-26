public class Ponto implements Comparable{
    private int x;
    private int y;

    Ponto(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "("+x+", "+y+")";
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;

        if(null == obj)
            return false;

        if(obj.getClass() != Ponto.class)
            return false;

        Ponto p = (Ponto)obj;

        return p.getX() == x && p.getY() == y;
    }

    @Override
    public int compareTo(Object o) {
        Ponto p = (Ponto)o;
        Integer i = ((Integer)x).compareTo((Integer)p.getX());

        if(i != 0)
            return i;

        return ((Integer)y).compareTo((Integer)p.getY());
    }
}
