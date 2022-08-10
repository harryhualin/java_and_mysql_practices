package week2day5;

public class Hotel {
    private String name;
    private String location;
    private Room[] rooms;
    private int occupiedCnt;

    private int numOfRoom;

    public Hotel() {
        this.name = "";
        this.location = "";
        this.rooms = new Room[10];
        this.occupiedCnt = 0;
        this.numOfRoom = 0;
    }

    public Hotel(String name, String location, int occupiedCnt) {
        this.name = name;
        this.location = location;
        this.numOfRoom = 0;
        this.rooms = new Room[10];
        this.occupiedCnt = occupiedCnt;
    }

    public boolean isFull() {
        if (this.occupiedCnt == this.numOfRoom) return true;
        else return false;
    }

    public boolean isEmpty() {
        if (this.occupiedCnt == 0 && this.numOfRoom > 0) return true;
        else return false;
    }

    public void addRoom(int roomNum, String bedType, char isSmoking, double roomRate) {
        Room room = new Room(roomNum, bedType, isSmoking, roomRate);
        this.rooms[this.numOfRoom] = room;
        this.numOfRoom = this.numOfRoom + 1;
    }

    public void addReservation(String name, char isSmoking, String bedType) {
        if (this.isFull()) return;
        for (int i = 0; i < this.numOfRoom; i++) {
            if ((!this.rooms[i].isOccupied()) && (this.rooms[i].getBedType().compareTo(bedType) == 0) && this.rooms[i].getSmoking() == isSmoking) {
                this.rooms[i].setOccupied(true);
                this.rooms[i].setOccupant(name);
                System.out.printf("reservation for %s was made successfully.\n", name);
                return;
            }
        }
        System.out.printf("reservation for %s was failed.\n", name);
    }

    public void cancelReservation(String name) {
        int index = findReservation(name);
        if (index == NOT_FOUND)
            System.out.printf("\nNot founding occupant's name %s for canceling reservation\n", name);

        else {
            rooms[index].setOccupied(false);
            rooms[index].setOccupant("Not occupied");
            System.out.printf("\ncanceled reservation for occupant's name %s\n", name);
        }
    }

    private static final int NOT_FOUND = -1;

    private int findReservation(String name) {
        for (int i = 0; i < this.numOfRoom; i++) {
            if (rooms[i].isOccupied() && rooms[i].getOccupant().compareTo(name) == 0) return i;
        }
        return NOT_FOUND;
    }

    public void printReservationList() {
        for (int i = 0; i < this.numOfRoom; i++)
            if (this.rooms[i].isOccupied()) System.out.println(this.rooms[i]);
    }

    public double getDailySales() {
        double sum = 0.0;
        for (int i = 0; i < this.numOfRoom; i++) {
            if (this.rooms[i].isOccupied()) sum = sum + this.rooms[i].getRoomRate();
        }
        return sum;
    }

    public double occupancyPercentage() {
        return this.occupiedCnt / this.numOfRoom;
    }

    public String toString() {
        String roomString = "";
        for (int i = 0; i < this.numOfRoom; i++) {
            roomString = roomString + this.rooms[i].toString();
        }
        return "\nHotel Name : " + this.getName()
                + "\nLocation : " + this.getLocation()
                + "\nNumber of Rooms : " + this.numOfRoom
                + "\nNumber of Occupied Rooms : " + this.occupiedCnt
                + "\nRoom Details are: " + roomString;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return this.location;
    }


}
