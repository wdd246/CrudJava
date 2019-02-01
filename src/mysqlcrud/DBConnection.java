package mysqlcrud;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Adam Małota
 */
public class DBConnection {

    private String DB;
    private String USERNAME;
    private String PASSWORD;

    DBConnection(String DB, String USERNAME, String PASSWORD) {
        setUrl(DB);
        setUsername(USERNAME);
        setPassword(PASSWORD);
    }

    Connection get_connection() {

        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            //(DB, USERNAME, PASSWORD)
            connection = DriverManager.getConnection(getUrl(), getUsername(), getPassword());
        } catch (Exception e) {
            System.err.print(e);
        }

        return connection;
    }

    void setUrl(String DB) {
        if(DB!=null && !DB.equals("")){
            this.DB = DB;
        }
        else{
            throw new IllegalArgumentException("Url is empty!");
        }
    }

    String getUrl() {
        return DB;
    }

    void setUsername(String USERNAME) {
        if(USERNAME!=null && !USERNAME.equals("")){
            this.USERNAME = USERNAME;
        }
        else{
            throw new IllegalArgumentException("Username is empty!");
        }
    }

    String getUsername() {
        return USERNAME;
    }
    
    void setPassword(String PASSWORD) {
        if(PASSWORD!=null){
            this.PASSWORD = PASSWORD;
        }
        else{
            throw new IllegalArgumentException("Password is empty!");
        }
    }

    String getPassword() {
        return PASSWORD;
    }

}
