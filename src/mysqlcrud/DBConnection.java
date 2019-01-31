package mysqlcrud;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Adam Małota
 */
public class DBConnection {

    private String url;
    private String username;
    private String password;

    public DBConnection(String url, String username, String password) {
        setUrl(url);
        setUsername(username);
        setPassword(password);
    }

    public Connection get_connection() {

        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            //(url, username, password)
            connection = DriverManager.getConnection(getUrl(), getUsername(), getPassword());
        } catch (Exception e) {
            System.err.print(e);
        }

        return connection;
    }

    void setUrl(String url) {
        if(url!=null && !url.equals("")){
            this.url = url;
        }
        else{
            throw new IllegalArgumentException("Url is empty!");
        }
    }

    String getUrl() {
        return url;
    }

    void setUsername(String username) {
        if(username!=null && !username.equals("")){
            this.username = username;
        }
        else{
            throw new IllegalArgumentException("Username is empty!");
        }
    }

    String getUsername() {
        return username;
    }
    
    void setPassword(String password) {
        if(password!=null){
            this.password = password;
        }
        else{
            throw new IllegalArgumentException("Password is empty!");
        }
    }

    String getPassword() {
        return password;
    }

}
