package mysqlcrud;

/**
 *
 * @author Adam Małota
 */
public class MySQLCrud {

    public static void main(String[] args) {
        
        CrudImplement obj = new CrudImplement();
        //insert data
        obj.create_data(4, "jinu", "jinu@gmail.com");
        obj.create_data(3, "jawad18", "jawad@gmail.com");
        //read data
        obj.read_data(2);
        //update data
        obj.update_data(3, 23, "jawad2", "jawad2@gmail");
        //delete data
        obj.delete_data(33);

    }

}
