import java.util.ArrayList;
import java.util.List;

public class Party extends Event{

    private List<Event> eventList;

    Party(String title, String date, String description) {
        super(title, date, description);
        this.eventList= new ArrayList<>();
    }

    public void addEvent(Event e){
        List<Person> persons = e.getPersonList();
        for(Person p : persons){
            boolean foundPerson = false;
            for(Person p1 : this.personList){
                if(p.equals(p1)){
                    foundPerson = true;
                    break;
                }
            }
            if(!foundPerson){
                this.addPerson(p);
            }
        }
    }
}
