package mysqlcrud;

/**
 *
 * @author Adam Małota
 */
public class MySQLCrud {

    public static void main(String[] args) {

        //DBConnection obj_DBConnection = new DBConnection();
        //System.out.println(obj_DBConnection.get_connection());

        CrudImplement obj = new CrudImplement();
        //insert data
        obj.create_data(1, "jinu", "jinu@gmail.com");
        obj.create_data(2, "jawad", "jawad@gmail.com");
        //read data
        obj.read_data(2);
        //update data
        obj.update_data(2, 22, "jawad2", "jawad2@gmail");
        //delete data
        obj.delete_data(1);

    }

}
