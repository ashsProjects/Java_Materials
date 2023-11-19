import java.util.HashMap;

public class Hash_Map {
    public static void main(String[] args) {
        HashMap<String, String> countryCapital = new HashMap<String, String>();
        countryCapital.put("USA", "Washington DC");
        countryCapital.put("India", "New Dehli");
        countryCapital.put("Thailand", "Bangkok");
        countryCapital.put("China", "Beijing");

        System.out.println("Before removal: ");
        System.out.println(countryCapital);

        countryCapital.remove("China");
        System.out.println("After removal: ");
        System.out.println(countryCapital);

        // countryCapital.clear();
        // System.out.println("After clear: ");
        // System.out.println(countryCapital);

        System.out.println(countryCapital.size());
        countryCapital.replace("India", "Bombay");
        System.out.println(countryCapital.get("India"));

        System.out.println("Does the map contain Japan?");
        System.out.println(countryCapital.containsKey("Japan"));

        for (String i: countryCapital.keySet()) {
            System.out.print(i + "\t" + "= ");
            System.out.println(countryCapital.get(i));
        }

    }
    

}