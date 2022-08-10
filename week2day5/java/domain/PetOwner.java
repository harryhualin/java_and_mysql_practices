package week2day5.java.domain;

public class PetOwner {
    private String firstName;
    private String lastName;

    public PetOwner(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Owner: " + firstName + " " + lastName;
    }
}

