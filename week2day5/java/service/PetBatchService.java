package week2day5.java.service;

import week2day5.java.config.MySQLDS;

import javax.sql.DataSource;
import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

public class PetBatchService {
    private DataSource ds;
    private Connection conn;
    private PreparedStatement insertBatchPetPst;

    private static final String INSERT_PET = "INSERT INTO pet(`pet_name`,`pet_age`) VALUES( ?, ?)";

    private PetBatchService() {
        this.ds = MySQLDS.getDs();
    }

    public void insertBatchPets()  {
        try {
            long start = System.currentTimeMillis();
            this.conn = ds.getConnection();
            this.insertBatchPetPst = conn.prepareStatement(INSERT_PET);
            for(int i = 0; i < 1000; i++){
                insertBatchPetPst.setString(1,"Batch");
                insertBatchPetPst.setInt(2,i);
                insertBatchPetPst.addBatch();
             //   insertBatchPetPst.executeUpdate();
            }
           int res[] = insertBatchPetPst.executeBatch();
        //    System.out.println(Arrays.toString(res));
            System.out.println("Time Taken: "+(System.currentTimeMillis()-start));
        } catch (BatchUpdateException e){
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try {
                if(insertBatchPetPst != null) insertBatchPetPst.close();
                if(conn != null) conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        PetBatchService petBatchService = new PetBatchService();
        petBatchService.insertBatchPets();
    }
}
