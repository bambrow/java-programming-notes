package gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.*;

/**
 * Tests for map and set.
 */

public class GsonTest3 {
    public static void main(String[] args) {
        Gson gson = new Gson();
        Map<String, List<String>> students1 = new HashMap<>();
        students1.put("Amy", Arrays.asList("101", "102", "103"));
        students1.put("Bob", Arrays.asList("101", "103"));
        students1.put("Cathy", Arrays.asList("102", "104"));

        System.out.println(gson.toJson(students1));
        // {"Bob":["101","103"],"Cathy":["102","104"],"Amy":["101","102","103"]}

        Type studentMapType = new TypeToken<HashMap<String, ArrayList<String>>>(){}.getType();
        Map<String, List<String>> students2 = gson.fromJson(
                "{\"David\":[\"101\",\"103\"],\"Eva\":[\"102\",\"104\"],\"Fred\":[\"101\",\"102\",\"103\"]}",
                studentMapType
        );
        for (Map.Entry<String, List<String>> entry : students2.entrySet()) {
            System.out.println(entry.getKey() + ": " + Arrays.toString(entry.getValue().toArray()));
        }
        // Eva: [102, 104]
        // David: [101, 103]
        // Fred: [101, 102, 103]

        Set<String> names1 = new HashSet<>();
        names1.add("Amy");
        names1.add("Bob");
        names1.add("Cathy");

        System.out.println(gson.toJson(names1));
        // ["Bob","Cathy","Amy"]

        Type nameSetType = new TypeToken<HashSet<String>>(){}.getType();
        Set<String> names2 = gson.fromJson("[\"David\",\"Eva\",\"Fred\"]", nameSetType);
        System.out.println(Arrays.toString(names2.toArray()));
        // [Eva, David, Fred]
    }
}
