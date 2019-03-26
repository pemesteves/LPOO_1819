import java.util.ArrayList;
import java.util.List;

public class Event {
    private String date;
    private String description;
    private String title;

    protected List<Person> personList;

    Event(String title){
        this.title = title;
        this.date = "";
        this.description = "";
        this.personList = new ArrayList<>();
    }

    Event(String title, String date){
        this.title = title;
        this.date = date;
        this.description = "";
        this.personList = new ArrayList<>();
    }

    Event(String title, String date, String description){
        this.title = title;
        this.date = date;
        this.description = description;
        this.personList = new ArrayList<>();
    }

    Event(Event e){
        this.date = e.getDate();
        this.title = e.getTitle();
        this.description = e.getDescription();
        this.personList = e.personList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return this.title+" is a "+this.description+" and will be held at "+this.date+".";
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;

        if(obj == null)
            return false;

        if(obj.getClass() != Event.class)
            return false;

        Event e = (Event)obj;

        return this.title.equals(e.getTitle()) && this.date.equals(e.getDate()) && this.description.equals(this.getDescription());
    }

    public void addPerson(Person p){
        for(Person person : personList){
            if(person.equals(p))
                return;
        }

        personList.add(p);
    }

    public int getAudienceCount(){
        return personList.size();
    }

    public List<Person> getPersonList(){
        return this.personList;
    }
}
