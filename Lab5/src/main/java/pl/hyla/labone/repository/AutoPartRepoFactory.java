package pl.hyla.labone.repository;

import java.sql.DriverManager;
import java.sql.SQLException;

public class AutoPartRepoFactory {

    public static AutoPartRepository getInstance(){
        try{
            String url = "jdbc:hsqldb:hsql://localhost/testdb";
            return new AutoPartRepoImpl(DriverManager.getConnection(url));
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
