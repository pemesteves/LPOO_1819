public class Speaker extends Person {
    private int fee;

    Speaker(String name){
        this.name = name;
        this.age = 0;
        this.fee = 0;
    }

    Speaker(String name, int age){
        this.name = name;
        this.age = age;
        this.fee = 0;
    }

    public int getFee(){
        return this.fee;
    }

    @Override
    public String toString() {
        return "Speaker "+this.name+" as a fee value of "+this.fee+".";
    }
}
