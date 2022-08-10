package week2day5.java.domain;

public class Visit {
    private String date;
    private String procedure;

    public Visit(String date, String procedure) {
        this.date = date;
        this.procedure = procedure;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getProcedure() {
        return procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

    @Override
    public String toString() {
        return "Visit: " + date + " " + procedure;
    }
}

