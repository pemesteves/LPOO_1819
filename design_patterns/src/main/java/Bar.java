import java.util.ArrayList;
import java.util.List;

public class Bar {
    private boolean happyHour;
    private List<BarObserver> observers;

    Bar(){
        this.happyHour = false;
        this.observers = new ArrayList<>();
    }

    public void startHappyHour(){
        this.happyHour = true;
        notifyObservers();
    }

    public void endHappyHour(){
        this.happyHour = false;
        notifyObservers();
    }

    public boolean isHappyHour(){
        return this.happyHour;
    }

    void addObserver(BarObserver observer){
        observers.add(observer);
    }

    void removeObserver(BarObserver observer){
        observers.remove(observer);
    }

    void notifyObservers(){
        for(BarObserver observer : observers){
            if(isHappyHour())
                observer.happyHourStarted(this);
            else
                observer.happyHourEnded(this);
        }
    }
}
