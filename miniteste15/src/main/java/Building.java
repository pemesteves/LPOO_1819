import java.util.ArrayList;
import java.util.List;

public class Building implements Facility {
    private String name;
    private int minFloor;
    private int maxFloor;
    private int capacity;
    private List<Room> roomList;

    Building(String name, int minFloor, int maxFloor){
        if(minFloor > maxFloor)
            throw new IllegalArgumentException();

        this.name = name;
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
        this.capacity = 0;

        roomList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getMinFloor() {
        return minFloor;
    }

    public int getMaxFloor() {
        return maxFloor;
    }

    @Override
    public String toString() {
        return "Building("+this.name+")";
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public boolean canEnter(User u) {
        for(Room room : roomList){
            if(room.canEnter(u))
                return true;
        }
        return false;
    }

    public void addCapacity(int capacity){
        this.capacity += capacity;
    }

    public void addRoom(Room room) throws DuplicateRoomException {
        for(Room r : roomList){
            if(r.equals(room))
                throw new DuplicateRoomException();
        }

        roomList.add(room);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;

        if(null == obj)
            return false;

        if(obj.getClass() != Building.class)
            return false;

        Building b = (Building)obj;
        return this.name.equals(b.getName())&& this.minFloor == b.getMinFloor() && this.maxFloor == b.getMaxFloor();
    }
}
