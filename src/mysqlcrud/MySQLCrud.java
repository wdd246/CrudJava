package mysqlcrud;

/**
 *
 * @author Adam Małota
 */
public class MySQLCrud {

    public static void main(String[] args) {
        
        CrudImplement obj = new CrudImplement();
        //insert data
        obj.insert("jinu", "jinu@gmail.com");
        obj.insert("jawad18", "jawad@gmail.com");
        //read row data
            //obj.read(16);
        //update data
            //obj.update(38, "jawad2", "jawad2@gmail");
        //delete data
            //obj.delete(17);
        //print all data
        obj.print();

    }

}
