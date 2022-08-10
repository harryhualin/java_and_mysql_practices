package week2day5.java.service;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class PetTransactionService {
    private static final String UPDATE_AGE_WITH_NAME = "UPDATE pet SET pet_age=? WHERE pet_name=?;";
    private static final int MAX_AGE = 20;

    private Connection conn = null;
    private PreparedStatement updateAgeWithNamePst;

    public PetTransactionService(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public void updateMultiplePetAgeWithPetNameTransaction(Map<String,Integer> map) {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/aw?serverTimezone=UTC", "root", "Aa83907934+");
            this.updateAgeWithNamePst = conn.prepareStatement(UPDATE_AGE_WITH_NAME);

            // The way to allow two or more statements to be grouped into a transaction is to disable the auto-commit mode.
            conn.setAutoCommit(false);

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                int newAge = entry.getValue();
                if (newAge > MAX_AGE) {
                    conn.rollback();
                    System.out.println("rollback");
                    break;
                }

                updateAgeWithNamePst.setInt(1, newAge);
                updateAgeWithNamePst.setString(2, entry.getKey());
                // one query is one transaction
                //1000 query in one transaction -> turn off the auto commit -> execute -> call commit
                // execute -> commit
                updateAgeWithNamePst.executeUpdate();
            }

            // All statements executed after the previous call to the method commit are included in the current transaction and committed together as a unit.
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.setAutoCommit(true);
                if (updateAgeWithNamePst != null) conn.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


        public static void main(String[] args) {
            PetTransactionService petTransactionService = new PetTransactionService();
            Map<String, Integer> newAgeForName = new HashMap<>() {
                {put("Rover", 7);}
                {put("Spot", 23);}
            };

            petTransactionService.updateMultiplePetAgeWithPetNameTransaction(newAgeForName);
        }
}
