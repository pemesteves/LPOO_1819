import java.util.ArrayList;
import java.util.List;

public class Session extends Countable{
    private ATM atm;
    private List<Movement> movementList;

    Session(ATM atm){
        this.atm = atm;
        this.movementList = new ArrayList<>();
    }

    public ATM getATM() {
        return atm;
    }

    public void addTransaction(Movement m){
        for(Movement movement : movementList){
            if(m.equals(movement))
                return;
        }

        this.movementList.add(m);
    }

    @Override
    public int count() {
        return movementList.size();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;

        if(null == obj)
            return false;

        if(obj.getClass() != Session.class)
            return false;

        Session s = (Session)obj;

        return this.atm.equals(s.getATM());
    }
}
