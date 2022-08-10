package week2day5;



import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class User {
    private int user_id;
    private String username;
    private String fullname;
    private String email;

    private User(int user_id, String username, String fullname, String email) {
        this.user_id = user_id;
        this.username = username;
        this.fullname= fullname;
        this.email = email;
    }

    public String getName() {
        return this.username;
    }

    public String getemail() {return email;}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("user_id: " + user_id);
        sb.append(", username: " + username);


        if (fullname != null) {
            sb.append(", FullName: " + fullname);

        }

        if (email != null) {
            sb.append(", email: " + email+"\n");
        }

        return sb.toString();
    }
    public static class UserBuilder {
        private int user_id;
        private String username;
        private String fullname;
        private String email;

        public UserBuilder id(int user_id) {
            this.user_id = user_id;
            return this;
        }

        public  UserBuilder username(String username) {
            this.username = username;
            return this;
        }



        public UserBuilder fullname(String fullname) {
            this.fullname = fullname;
            return this;
        }

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public User build() {
            return new User(user_id, username, fullname,  email);
        }
    }
}

class UserService {
    private DataSource ds;
    private Connection conn;

    private static final String SELECT_ALL_USERS = "SELECT * FROM users;";
    private static final String INSERT_User = "INSERT INTO users(`username`, `fullname`, `email`) VALUES (?, ?,?);";
    private static final String DELETE_USER_WITH_USERNAME = "DELETE FROM USERS WHERE username=?;";
    private static final String UPDATE_USERNAME_WITH_USERID = "UPDATE users SET username=? WHERE user_id=?;";

    private static final String GET_USER_WITH_USERNAME="SELECT * FROM users where username=?;";
    private PreparedStatement insertUserPst;
    private Statement st;
    private PreparedStatement deleteUserWithNamePst;
    private PreparedStatement updateUserNameWithIdPst;
    private PreparedStatement getUserWithUserNamePst;

    public UserService() {
        this.ds = MySQLDS.getDs();
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();

        try {

            this.conn = ds.getConnection();
            this.st = conn.createStatement();

            ResultSet rs = st.executeQuery(SELECT_ALL_USERS);//resultset

            while (rs.next()) {
                User user = new User.UserBuilder()
                        .id(rs.getInt("user_id"))
                        .username(rs.getString("username"))
                        .fullname(rs.getString("fullname"))
                        .email(rs.getString("email"))
                        .build();

                users.add(user);
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
        System.out.println(users);
        return users;
    }


    public void addUser(String username, String fullname,String email) {
        try {
            this.conn = ds.getConnection();

            this.insertUserPst = conn.prepareStatement(INSERT_User);
            insertUserPst.setString(1, username);
            insertUserPst.setString(2, fullname);
            insertUserPst.setString(3, email);
            insertUserPst.executeUpdate(); //int -> database rows be affected -> 0 1 2


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (insertUserPst != null) insertUserPst.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteUserWithUserName(String name) {
        try {
            this.conn = ds.getConnection();
            // private static final String DELETE_PET_WITH_NAME = "DELETE FROM pet WHERE pet_name=?;";
            this.deleteUserWithNamePst = conn.prepareStatement(DELETE_USER_WITH_USERNAME);

            deleteUserWithNamePst.setString(1, name);
            deleteUserWithNamePst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (deleteUserWithNamePst != null) deleteUserWithNamePst.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

public void UpdateUserNameWithUserid(String newName,int id) {
    try {
        this.conn = ds.getConnection();
        this.updateUserNameWithIdPst = conn.prepareStatement(UPDATE_USERNAME_WITH_USERID);

        updateUserNameWithIdPst.setString(1, newName);
        updateUserNameWithIdPst.setString(2, Integer.toString(id));
        updateUserNameWithIdPst.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (updateUserNameWithIdPst != null) updateUserNameWithIdPst.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
    public void getUserWithUserName(String Name) {
        try {
            this.conn = ds.getConnection();
            // private static final String DELETE_PET_WITH_NAME = "DELETE FROM pet WHERE pet_name=?;";
            this.getUserWithUserNamePst = conn.prepareStatement(GET_USER_WITH_USERNAME);

            getUserWithUserNamePst.setString(1, Name);
            ResultSet rs=getUserWithUserNamePst.executeQuery();
            if(rs.next()) {User user = new User.UserBuilder()
                    .id(rs.getInt("user_id"))
                    .username(rs.getString("username"))
                    .fullname(rs.getString("fullname"))
                    .email(rs.getString("email"))
                    .build();
            System.out.println(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (getUserWithUserNamePst != null) getUserWithUserNamePst.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}



public class operations {

    public static void main(String[] args)
    {   Scanner stdin=new Scanner(System.in);
        UserService userService=new UserService();
        int input=0;
        while(input!=6) {
            menu();
            input = stdin.nextInt();
            if (input < 1 || input > 6) System.out.println("Wrong input,Try again.....");
            else if (input==1) userService.addUser("aaaa","ad ad","aaaa@gmail.com");
            else if (input==2) userService.deleteUserWithUserName("aaaa");
            else if (input==3) userService.UpdateUserNameWithUserid("bbbb",1);
            else if (input==4) userService.getAllUsers();
            else if (input==5) userService.getUserWithUserName("aaaa");
        }
    }
    public static void menu(){
        System.out.println("Choose the option:\n" +
                "-(1)Insert\n" +
                "-(2)Delete\n" +
                "-(3)Update\n" +
                "-(4)Display all records\n" +
                "-(5)Get\n"+
                "-(6)Quit");
    }


}
