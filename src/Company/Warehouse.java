package Company;

import java.util.ArrayList;
import java.util.List;

public class Warehouse<T extends Product> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public void removeItem(T item) {
        items.remove(item);
    }

    public T getItem(int index) {
        if (index >= 0 && index < items.size()) {
            return items.get(index);
        }
        return null;
    }

    public int getItemCount() {
        return items.size();
    }

    public void printAllItems() {
        for (T item : items) {
            System.out.println(item.getInfo());
        }
    }
}
