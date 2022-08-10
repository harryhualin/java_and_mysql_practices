package week2day5;
import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Scanner;

public class FileToDB {
    public static void main(String[] args)
    {

        Statement st;
        try
        {   DataSource ds = MySQLDS.getDs();

            Connection conn=ds.getConnection();
            st=conn.createStatement();
            String sql="";
            FileInputStream fin=new FileInputStream("src/week2day5/test1.txt");
            Scanner sc=new Scanner(fin);
            String[] arrayList;
            String a="";
            int i=0;
            while(sc.hasNext())
            {
                a=sc.nextLine();
                arrayList =a.split("\\s+");
                String INSERT_User = "INSERT INTO users(`username`, `fullname`, `email`) VALUES (?, ?,?);";
                PreparedStatement insertUserPst = conn.prepareStatement(INSERT_User);
                insertUserPst.setString(1,arrayList[0]);
                insertUserPst.setString(2,arrayList[1]);
                insertUserPst.setString(3,arrayList[2]);
                insertUserPst.executeUpdate(); //int -> database rows be affected -> 0 1 2
                i++;

            }
            System.out.println(i+" Records are inserted");
            st.close();
            conn.close();
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
