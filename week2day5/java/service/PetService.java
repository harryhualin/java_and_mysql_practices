package week2day5.java.service;

import week2day5.java.config.MySQLDS;
import week2day5.java.domain.Pet;
import week2day5.java.domain.PetType;

import javax.sql.DataSource;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class PetService {
    private DataSource ds;
    private Connection conn;

    private static final String SELECT_ALL_PETS = "SELECT * FROM pet;";
    private static final String INSERT_PET = "INSERT INTO pet(`pet_name`, `pet_age`) VALUES (?, ?);";
    private static final String SELECT_ALL_PETS_WITH_TYPE = "SELECT * FROM pet p INNER JOIN pet_type t ON p.pet_id=t.pet_id;";
    private static final String CALL_GET_PET_VISITED_BEFORE_DATE = "CALL getPetVisitedBeforeDate(?)";
    private static final String DELETE_PET_WITH_NAME = "DELETE FROM pet WHERE pet_name=?;";

    private PreparedStatement insertPetPst;
    private Statement st;
    private CallableStatement getPetVisitedBeforeDateCst;
    private PreparedStatement deletePetWithNamePst;

    public PetService() {
        this.ds = MySQLDS.getDs();
    }

    public List<Pet> getAllPets() {
        List<Pet> pets = new ArrayList<>();

        try {
            /*
            1. Class.forName();
             */
          //  Class.forName("com.mysql.cj.jdbc.Driver");
            /*
            2.DriverManager.registerDriver()
             */
//            Driver myDriver = new com.mysql.cj.jdbc.Driver();
//            DriverManager.registerDriver(myDriver);
//            this.conn =
//                    DriverManager.getConnection("jdbc:mysql://localhost:3306/pet_example?serverTimezone=UTC","root","testtest");
            /*
            3.Data source.
             */
            this.conn = ds.getConnection();
            this.st = conn.createStatement();

            //boolean isResultSet = st.execute(SELECT_ALL_PETS);
            //ResultSet rs = st.getResultSet();
            ResultSet rs = st.executeQuery(SELECT_ALL_PETS);//resultset
            /*
            +++++++++++++++++++
             */

            /*
            Result set meta data
             */

//            ResultSetMetaData rsmd = rs.getMetaData();
//            System.out.println("Column in result set " + rsmd.getColumnCount());
//            for(int i =1; i <= rsmd.getColumnCount();i++){
//                System.out.println("Column name: " + rsmd.getColumnName(i));
//                System.out.println("Column type: " + rsmd.getColumnTypeName(i));
//            }

            /*
            ++++++++++++++++++++
             */
            while (rs.next()) {
                Pet pet = new Pet.PetBuilder()
                        .name(rs.getString("pet_name"))
                        .age(rs.getString("pet_age"))
                        .build();

                pets.add(pet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null) st.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return pets;
    }

    public List<Pet> getAllPetsWithType() {
        //  private static final String SELECT_ALL_PETS_WITH_TYPE = "SELECT * FROM pet p INNER JOIN pet_type t ON p.pet_id=t.pet_id;";
        List<Pet> pets = new ArrayList<>();

        try {
            this.conn = ds.getConnection();
            this.st = conn.createStatement();

            ResultSet rs = st.executeQuery(SELECT_ALL_PETS_WITH_TYPE);
            while (rs.next()) {
                PetType petType = new PetType(rs.getString("pet_type"));

                Pet pet = new Pet.PetBuilder()
                        .name(rs.getString("pet_name"))
                        .age(rs.getString("pet_age"))
                        .type(petType)
                        .build();

                pets.add(pet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null) st.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return pets;
    }

    public List<String> getAllPetsVisitedBefore(String aDate) {
        List<String> petNames = new ArrayList<>();

        try {
            this.conn = ds.getConnection();
            // private static final String CALL_GET_PET_VISITED_BEFORE_DATE = "CALL getPetVisitedBeforeDate(?)";
            this.getPetVisitedBeforeDateCst = conn.prepareCall(CALL_GET_PET_VISITED_BEFORE_DATE);

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = sdf.parse(aDate);
            java.sql.Date d = new java.sql.Date(date.getTime());
            getPetVisitedBeforeDateCst.setDate("aDate", d);
            ResultSet rs = getPetVisitedBeforeDateCst.executeQuery();

            while (rs.next()) {
                petNames.add(rs.getString("petName"));
            }
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        } finally {
            try {
                if (getPetVisitedBeforeDateCst != null) getPetVisitedBeforeDateCst.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return petNames;
    }

    public void addPet(String name, int age) {
        try {
            this.conn = ds.getConnection();
            // private static final String INSERT_PET = "INSERT INTO pet(`pet_name`, `pet_age`) VALUES (?, ?);";
            this.insertPetPst = conn.prepareStatement(INSERT_PET);
            /*
            String query = "select * from pet where name = " + name;
            statement instead of prepared
            SQL injection
             */
            insertPetPst.setString(1, name);
            insertPetPst.setInt(2, age);
            insertPetPst.executeUpdate(); //int -> database rows be affected -> 0 1 2
            //System.out.println("++++++ " + insertPetPst.execute() + " " + insertPetPst.getUpdateCount());

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (insertPetPst != null) insertPetPst.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void deletePetWithName(String name) {
        try {
            this.conn = ds.getConnection();
            // private static final String DELETE_PET_WITH_NAME = "DELETE FROM pet WHERE pet_name=?;";
            this.deletePetWithNamePst = conn.prepareStatement(DELETE_PET_WITH_NAME);

            deletePetWithNamePst.setString(1, name);
            deletePetWithNamePst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (deletePetWithNamePst != null) deletePetWithNamePst.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        PetService petService = new PetService();
        petService.deletePetWithName("Batch");
        System.out.println(petService.getAllPets());

        petService.addPet("Boba", 2);

        System.out.println(petService.getAllPets());

        System.out.println(petService.getAllPetsWithType());

        System.out.println(petService.getAllPetsVisitedBefore("2002-03-04"));

         petService.deletePetWithName("Boba");

        System.out.println(petService.getAllPets());
    }
}
