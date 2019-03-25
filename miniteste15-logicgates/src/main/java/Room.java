import java.util.ArrayList;
import java.util.List;

public class Room implements Facility {

    private Building building;
    private String number;
    private int floor;
    private int capacity;
    private List<User> authorized;

    Room(Building building, String number, int floor) throws DuplicateRoomException {
        this(building, number, floor, 0);

        building.addRoom(this);
    }

    Room(Building building, String number, int floor, int capacity) {
        if(floor < building.getMinFloor() || floor > building.getMaxFloor())
            throw new IllegalArgumentException();

        this.building = building;
        this.number = number;
        this.floor = floor;

        this.capacity = capacity;
        this.building.addCapacity(capacity);

        authorized = new ArrayList<>();
    }

    public Building getBuilding() {
        return building;
    }

    public String getNumber() {
        return number;
    }

    public int getFloor() {
        return floor;
    }

    public String getName(){
        return this.building.getName()+number;
    }

    @Override
    public String toString() {
        return "Room("+this.building.getName()+","+this.number+")";
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    public void authorize(User u) {
        this.authorized.add(u);
    }

    @Override
    public boolean canEnter(User u) {
        for(User user : authorized){
            if(user.equals(u))
                return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;

        if(null == obj)
            return false;

        if(obj.getClass() != Room.class)
            return false;

        Room r = (Room)obj;

        return this.building.equals(r.building) && this.floor == r.getFloor() && this.number.equals(r.getNumber());
    }
}
