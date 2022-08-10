package week2day5.java.domain;

import java.util.List;

public class Pet {
    private String petName;
    private String petAge;
    private PetType petType;
    private List<Visit> visits;
    private PetOwner petOwner;

    private Pet(String petName, String petAge, PetType petType, List<Visit> visits, PetOwner petOwner) {
        this.petName = petName;
        this.petAge = petAge;
        this.petType = petType;
        this.visits = visits;
        this.petOwner = petOwner;
    }

    public String getPetName() {
        return petName;
    }

    public String getPetAge() {
        return petAge;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: " + petName);
        sb.append(", Age: " + petAge);
        if (petType != null) sb.append("," + petType);

        if (visits != null) {
            sb.append(", [\n");

            for (Visit v : visits) {
                sb.append("\t" + v + "\n");
            }

            sb.append("]\n");
        }

        if (petOwner != null) {
            sb.append(", " + petOwner);
        }

        return sb.toString();
    }

    public static class PetBuilder {
        private String name;
        private String age;
        private PetType petType;
        private List<Visit> visits;
        private PetOwner petOwner;

        public PetBuilder name(String petName) {
            this.name = petName;
            return this;
        }

        public PetBuilder age(String petAge) {
            this.age = petAge;
            return this;
        }

        public PetBuilder type(PetType petType) {
            this.petType = petType;
            return this;
        }

        public PetBuilder visits(List<Visit> visits) {
            this.visits = visits;
            return this;
        }

        public PetBuilder owner(PetOwner petOwner) {
            this.petOwner = petOwner;
            return this;
        }

        public Pet build() {
            return new Pet(name, age, petType, visits, petOwner);
        }
    }
}
