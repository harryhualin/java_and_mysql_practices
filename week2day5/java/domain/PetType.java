package week2day5.java.domain;



public class PetType {
    private String type;

    public PetType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Type: " + type;
    }
}
