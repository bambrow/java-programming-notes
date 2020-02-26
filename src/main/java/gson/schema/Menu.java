package gson.schema;

import java.util.Arrays;
import java.util.List;

public class Menu {
    private String name;
    private List<MenuItem> items;
    // alternative implementation
    // private MenuItem[] items;

    public Menu(String name, List<MenuItem> items) {
        this.name = name;
        this.items = items;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "name='" + name + '\'' +
                ", items=" + Arrays.toString(items.toArray()) +
                '}';
    }
}
