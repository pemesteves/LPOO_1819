public class Attendee extends Person{
    private boolean hasPaid;

    Attendee(String name){
        this.name = name;
        this.age = 0;
        this.hasPaid = false;
    }

    Attendee(String name, int age){
        this.name = name;
        this.age = age;
        this.hasPaid = false;
    }

    @Override
    public String toString() {
        return "Attendee "+this.name+(this.hasPaid ? " has":" hasn't")+" paid its registration.";
    }

    public boolean hasPaid(){
        return this.hasPaid;
    }
}
