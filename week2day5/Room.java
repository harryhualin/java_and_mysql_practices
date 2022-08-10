package week2day5;

public class Room {
    private boolean occupied;
    private int roomNum;
    private String bedType;
    private char smoking;
    private double rate;
    private String occupantName;

    public Room() {
    }

    ;

    public Room(int roomNum, String bedType, char isSmoking, double roomrate) {
        this.occupantName = "Not Occupied";
        this.setRoomNum(roomNum);
        this.setBedType(bedType);
        this.setSmoking(isSmoking);
        this.setRate(roomrate);
        this.occupied = false;
    }

    public String getBedType() {
        return this.bedType;
    }

    public char getSmoking() {
        return this.smoking;
    }

    public int getRoomNum() {
        return this.roomNum;
    }

    public double getRoomRate() {
        return this.rate;
    }

    public String getOccupant() {
        return this.occupantName;
    }

    public void setOccupied(boolean a) {
        this.occupied = a;
    }

    public void setRoomNum(int a) {
        this.roomNum = a;
    }

    public void setOccupant(String name) {
        this.occupantName = name;
    }

    public void setBedType(String a) {
        this.bedType = a;
    }

    public void setRate(double a) {
        this.rate = a;
    }

    public void setSmoking(char a) {
        this.smoking = a;
    }

    public boolean isOccupied() {
        return this.occupied;
    }

    public String toString() {
        return "\nRoom Number: " + this.getRoomNum()
                + "\nOccupant name: " + this.getOccupant()
                + "\nSmoking room: " + this.getSmoking()
                + "\nBed Type: " + this.getBedType()
                + "\nRate: " + this.getRoomRate()
                ;
    }
}
