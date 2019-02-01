package mysqlcrud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Adam Małota
 */
public class CrudImplement {

    static String DB = "jdbc:mysql://localhost:3306/crud";
    static String USERNAME = "root";
    static String PASSWORD = "";
    static String TABLE = "user";

    DBConnection obj_DBConnection = new DBConnection(DB, USERNAME, PASSWORD);
    Connection connection = obj_DBConnection.get_connection();

    public boolean existID(int id) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "select id from " + TABLE;
            ps = connection.prepareStatement(query);
            //System.out.println(ps);
            rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getInt("id") == id) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public int incInt() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        int inc;
        try {
            String query = "select id from " + TABLE + " order by id desc limit 1";
            ps = connection.prepareStatement(query);
            //System.out.println(ps);
            rs = ps.executeQuery();
            rs.next();
            inc = rs.getInt("id");
            return inc += 1;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    public void insert(String name, String email) {
        int id = incInt();
        if (!existID(id)) {
            PreparedStatement ps = null;
            try {
                String query = "insert into " + TABLE + "(id,name,email) values (?,?,?)";
                ps = connection.prepareStatement(query);
                ps.setInt(1, id);
                ps.setString(2, name);
                ps.setString(3, email);
                //System.out.println(ps);
                ps.executeUpdate();
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            throw new IllegalArgumentException("ID to insert data is exist");
        }
    }

    public void read(int id) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (existID(id)) {
            try {
                String query = "select * from " + TABLE + " where id=" + id;
                ps = connection.prepareStatement(query);
                //System.out.println(ps);
                rs = ps.executeQuery();
                while (rs.next()) {
                    System.out.print("[ ID=" + rs.getInt("id"));
                    System.out.print(", name=" + rs.getString("name"));
                    System.out.print(", email=" + rs.getString("email") + " ]");
                    System.out.println();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            throw new IllegalArgumentException("ID to read data is not exist");
        }
    }

    public void print() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "select * from " + TABLE + " order by id";
            ps = connection.prepareStatement(query);
            //System.out.println(ps);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.print("[ ID=" + rs.getInt("id"));
                System.out.print(", name=" + rs.getString("name"));
                System.out.print(", email=" + rs.getString("email") + " ]");
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void update(int id, String name, String email) {
        int new_id = incInt();
        if (!existID(new_id) && existID(id)) {
            PreparedStatement ps = null;
            try {
                String query = "update " + TABLE + " set id=?,name=?,email=? where id=?";
                ps = connection.prepareStatement(query);
                ps.setInt(1, new_id);
                ps.setString(2, name);
                ps.setString(3, email);
                ps.setInt(4, id);
                //System.out.println(ps);
                ps.executeUpdate();
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            throw new IllegalArgumentException("ID to update data is exist");
        }
    }

    public void delete(int id) {
        if (existID(id)) {
            PreparedStatement ps = null;
            try {
                String query = "delete from " + TABLE + " where id=?";
                ps = connection.prepareStatement(query);
                ps.setInt(1, id);
                //System.out.println(ps);
                ps.executeUpdate();
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            throw new IllegalArgumentException("ID to delete data is not exist");
        }
    }
}
