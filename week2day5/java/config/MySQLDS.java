package week2day5.java.config;

import javax.sql.DataSource;
import java.sql.SQLException;

import com.mysql.cj.jdbc.MysqlDataSource;

public class MySQLDS {
    // thread safe
    private static DataSource ds;

    static {
        //Single-responsibility principle
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setServerName("localhost");
        dataSource.setPortNumber(3306);
        dataSource.setDatabaseName("aw");
        dataSource.setUser("root");
        dataSource.setPassword("Aa83907934+");
        try {
            dataSource.setAllowMultiQueries(true);
            dataSource.setServerTimezone("UTC");
            dataSource.setRewriteBatchedStatements(true); // To get the actual benefits of Batch Processing in MySQL
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ds = dataSource;
    }

    private MySQLDS() { }

    public static DataSource getDs() {
        return ds;
    }
}

