import java.util.ArrayList;
import java.util.List;

public interface ITable {

    /**
     * This function should insert the key at the index given by the hash.
     *
     * @param key - item to insert into the table
     * @return True if the item could be inserted or false if it is a duplicate
     */
    public boolean insert(String key);

    /**
     * This method should return the string or null if there is no matching element
     *
     * @param key
     * @return
     */
    public boolean search(String key);
}
