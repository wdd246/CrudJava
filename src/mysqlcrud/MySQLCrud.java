package mysqlcrud;

/**
 *
 * @author Adam Małota
 */
public class MySQLCrud {

    public static void main(String[] args) {
        
        CrudImplement obj = new CrudImplement();
        //insert data
        obj.insert(16, "jinu", "jinu@gmail.com");
        obj.insert(17, "jawad18", "jawad@gmail.com");
        //read data
        obj.read(16);
        //update data
        obj.update(16, 18, "jawad2", "jawad2@gmail");
        //delete data
        obj.delete(17);
        
        obj.print();

    }

}
