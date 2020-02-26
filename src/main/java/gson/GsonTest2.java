package gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import gson.schema.Menu;
import gson.schema.MenuItem;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Tests for array and list.
 */

public class GsonTest2 {
    public static void main(String[] args) {
        Gson gson = new Gson();
        Menu m1 = new Menu("menu1", Arrays.asList(
                new MenuItem("Milk", 2.75),
                new MenuItem("Coffee", 3.25),
                new MenuItem("Salad", 6.25)
        ));
        System.out.println(gson.toJson(m1));
        // {"name":"menu1","items":[{"name":"Milk","price":2.75},{"name":"Coffee","price":3.25},{"name":"Salad","price":6.25}]}

        Menu m2 = gson.fromJson(
                "{\"name\":\"menu2\",\"items\":[{\"name\":\"Burger\",\"price\":5.75},{\"name\":\"Donut\",\"price\":3.25},{\"name\":\"Fries\",\"price\":4.25}]}",
                Menu.class
        );
        System.out.println(m2);
        // Menu{name='menu2', items=[MenuItem{name='Burger', price=5.75}, MenuItem{name='Donut', price=3.25}, MenuItem{name='Fries', price=4.25}]}

        List<MenuItem> mi1 = Arrays.asList(
                new MenuItem("Milk", 2.75),
                new MenuItem("Coffee", 3.25),
                new MenuItem("Salad", 6.25)
        );
        MenuItem[] mi2 = new MenuItem[] {
                new MenuItem("Milk", 2.75),
                new MenuItem("Coffee", 3.25),
                new MenuItem("Salad", 6.25)
        };
        System.out.println(gson.toJson(mi1));
        System.out.println(gson.toJson(mi2));
        // [{"name":"Milk","price":2.75},{"name":"Coffee","price":3.25},{"name":"Salad","price":6.25}]

        Type menuListType = new TypeToken<ArrayList<MenuItem>>(){}.getType();
        List<MenuItem> mi3 = gson.fromJson(
                "[{\"name\":\"Burger\",\"price\":5.75},{\"name\":\"Donut\",\"price\":3.25},{\"name\":\"Fries\",\"price\":4.25}]",
                menuListType
        );
        MenuItem[] mi4 = gson.fromJson(
                "[{\"name\":\"Burger\",\"price\":5.75},{\"name\":\"Donut\",\"price\":3.25},{\"name\":\"Fries\",\"price\":4.25}]",
                MenuItem[].class
        );
        System.out.println(Arrays.toString(mi3.toArray()));
        System.out.println(Arrays.toString(mi4));
        // [MenuItem{name='Burger', price=5.75}, MenuItem{name='Donut', price=3.25}, MenuItem{name='Fries', price=4.25}]
    }
}
