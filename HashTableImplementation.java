import java.util.ArrayList;
import java.util.List;

public class HashTableImplementation {
    private ArrayList<List<String>> table;
    private int numBuckets;
    private String hashFunction;

    public HashTable(int numBuckets, String hashFunction){
        this.numElements = 0;
        this.numBuckets = numBuckets;
        table = new ArrayList<List<String>>();
        for(int i = 0; i < numBuckets; i++){
            table.add(new ArrayList<String>());
        }
        this.hashFunction = hashFunction;
    }

    /**
     * This function should insert the key at the index given by the hash.
     * To do this:
     * The hash has been calculated for you, so to get the index take the hash % numBuckets
     * The index is the bucket to insert into.
     *
     * check to make sure that item is not already in the bucket. We don't want to insert a duplicate
     *
     * @param key - item to insert into the table
     * @return True if the item could be inserted or false if it is a duplicate
     */
    public boolean insert(String key){
        int hash;
        switch(hashFunction){
            case "ASCII":
                hash = asciiHash(key);
                break;
            case "PRIME":
                hash = primeHash(key);
                break;
            case "MYHASH":
                hash = myHash(key);
                break;
            default:
                hash = key.hashCode();
        }

        int index = hash % numBuckets;

        for (String k: table.get(index)) 
            if (key.equals(k)) return false;
        
        table.get(index).add(key);
        return true;
    }

    public int asciiHash(String key){
        if (key.length() <= 1) return (int) key.charAt(0);
        return Math.abs((int) key.charAt(0)) + asciiHash(key.substring(1));
    }

    public int primeHash(String key){
        int total = 9;

        for (int i = 0; i < key.length(); i++)
            total += Math.abs((int) key.charAt(i) * 17);
        
        return total;
    }

    public int myHash(String key){
        return (key.charAt(0) * 18);
    }


    public String toString(){
        StringBuilder ret = new StringBuilder("");
        for(int i = 0; i < table.size(); i++){
            List<String> bucket = table.get(i);
            ret.append(String.format("bucket %d: %s\n", i, bucket.toString()));
        }
        return ret.toString();
    }
    public static void main(String[] args){
        HashTable test = new HashTable(7, "ASCII");
        /* Hash Tests */
        System.out.println("Testing asciiHash...");
        int ans = 387;
        int hash1 = test.asciiHash("Liam");
        System.out.printf("Expected: %d, Actual: %d\n", ans, hash1);
        if(ans != hash1){
            System.out.println("FAILURE -> Something is wrong with your asciiHash!");
        }
        System.out.println("");
        HashTable test2 = new HashTable(7, "PRIME");

        int ans2 = 15887;
        int hash2 = test2.primeHash("Charlotte");
        System.out.println("Testing primeHash...");
        System.out.printf("Expected: %d, Actual: %d\n", ans2, hash2);
        if(ans2 != hash2){
            System.out.println("FAILURE -> Something is wrong with your primeHash!");
        }
        System.out.println("");
        HashTable test3 = new HashTable(7, "MYHASH");
        int ans3 = 1296;
        int hash3 = test3.myHash("Harper");
        System.out.println("Testing myHash...");
        System.out.printf("Expected: %d, Actual: %d\n", 1296, test.myHash("Harper"));
        if(ans3 != hash3){
            System.out.println("FAILURE -> Something is wrong with your myHash!");
        }
        System.out.println("");

        /* Table tests */
        String[] names = {"Liam", "Noah", "William", "James","Oliver",
                "Benjamin", "Charlotte", "Mia", "Evelyn", "Harper",
                "Lucas", "Mason", "Lucas"};
        HashTable[] tables = new HashTable[3];
        tables[0] = new HashTable(5, "ASCII");
        tables[1] = new HashTable(5, "PRIME");
        tables[2] = new HashTable(5, "MYHASH");
        for(HashTable table: tables){
            //insert each name in names into the each table in hashtables
            for(String name : names){
                table.insert(name);
            }
        }
        int i = 0;
        for(HashTable table: tables){
            System.out.println("TABLE " + i);
            System.out.println(table);
            i++;
        }
    }
}
