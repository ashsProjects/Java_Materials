public class DoubleTable implements ITable{
    String[] table;
    int numItems;
    public DoubleTable(int numSlots){
        if(numSlots < 7){
            System.out.println("ERROR: the table must have size of at least 7 so it was set automatically!!");
            table = new String[7];
        }else{
            table = new String[numSlots];
        }
        this.numItems = 0;
    }
    /**
     * This function should insert the key at the index given by the hash.
     * @param key - item to insert into the table
     * @return True if the item could be inserted or false if it is a duplicate
     */
    @Override
    public boolean insert(String key) {
        if (numItems >= table.length)
            return false;
        if (search(key))
            return false;

        int index = hash(key) % table.length;
        int orig = index;
        int i = 1;

        while (table[index] != null) {
            index = index > table.length ? 0 : (hash(key) + i * hashTwo(key)) % table.length;
            i++;
            if (index == orig) return false;
        }

        table[index] = key;
        numItems++;
        return true;
    }

    /**
     * This method should return the string or null if there is no matching element
     * To do this following similar steps as insert until you find the key or if you find an empty spot then
     * you know the key is not in the table and you can return false.
     * @param key
     * @return
     */
    @Override
    public boolean search(String key) {
        int index = hash(key) % table.length;
        int i = 1;
        int orig = index;

        while (table[index] != null) {
            if (table[index].equals(key)) return true;
            else {
                index = index > table.length ? 0 : (hash(key) + i * hashTwo(key)) % table.length;
                i++;
                if (index == orig) return false;
            }
        }

        return false;
    }
    /**
     * a hash function which simply uses Java's built in function for hashing strings.
     * @param key
     * @return
     */
    public int hash(String key){
        return Math.abs(key.hashCode());
    }
    /**
     * a second hash function to be used to deal with collisions
     * @param key
     */
    public int hashTwo(String key){
        return 7 - (Math.abs(key.hashCode()) % 7);
    }
    /**
     * Should return a string representation of the table like:
     * slot 1: item or list of items
     * slot 2: item or list of items
     * ...
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        for(int i = 0; i < table.length; i++){
            ret.append(String.format("Bucket %d: %s\n", i, table[i]));
        }
        return ret.toString();
    }
    public static void main(String[] args){
        /* Table tests */
        String[] names = {"Liam", "Noah", "William", "James","Oliver",
                "Benjamin", "Charlotte", "Mia", "Evelyn", "Harper",
                "Lucas", "Mason", "Lucas"};
        DoubleTable table = new DoubleTable(names.length-2);
        for(String name : names){
            table.insert(name);
        }
        System.out.println(table);
        /* search() tests */
        String name = "Liam";
        boolean search = table.search(name);
        System.out.printf("Testing search(%s)...\n", name);
        if(!search){
            System.out.print("FAILURE -> ");
        }else{
            System.out.print("PASSED -> ");
        }
        System.out.printf("Expected: %b, Actual: %b\n", true, search);

        String name2 = "Joshua";
        boolean search2 = table.search(name2);
        System.out.printf("Testing search(%s)...\n", name2);
        if(search2){
            System.out.print("FAILURE -> ");
        }else{
            System.out.print("PASSED -> ");
        }
        System.out.printf("Expected: %b, Actual: %b\n", false, search2);
    }
}
