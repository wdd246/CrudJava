package mysqlcrud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Adam Małota
 */
public class CrudImplement {
    
    DBConnection obj_DBConnection = new DBConnection("jdbc:mysql://localhost:3306/crud", "root", "");
    Connection connection = obj_DBConnection.get_connection();

    public void create_data(int id, String name, String email) {
        
        
        PreparedStatement ps = null;
        try {
            String query = "insert into user(id,name,email) values (?,?,?)";
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, email);
            System.out.println(ps);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void read_data(int id) {
        //DBConnection obj_DBConnection = new DBConnection();
        //Connection connection = obj_DBConnection.get_connection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "select * from user";
            ps = connection.prepareStatement(query);
            //ps.setString(1, id);
            System.out.println(ps);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("Sl no -" + rs.getInt("id"));
                System.out.println("name -" + rs.getString("name"));
                System.out.println("email -" + rs.getString("email"));
                System.out.println("---------------");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void update_data(int id, int new_id, String name, String email) {
        //DBConnection obj_DBConnection = new DBConnection();
        //Connection connection = obj_DBConnection.get_connection();
        PreparedStatement ps = null;
        try {
            String query = "update user set id=?,name=?,email=? where id=?";
            ps = connection.prepareStatement(query);
            ps.setInt(1, new_id);
            ps.setString(2, name);
            ps.setString(3, email);
            ps.setInt(4, id);
            System.out.println(ps);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void delete_data(int id) {
        //DBConnection obj_DBConnection = new DBConnection();
        //Connection connection = obj_DBConnection.get_connection();
        PreparedStatement ps = null;
        try {
            String query = "delete from user where id=?";
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            System.out.println(ps);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
