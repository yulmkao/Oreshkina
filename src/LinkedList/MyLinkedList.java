package LinkedList;

public class MyLinkedList<T> {

    private class ListNode {
        T value;
        ListNode next;

        ListNode(T value) {
            this.value = value;
        }
    }

    private ListNode firstElement;
    private int size = 0;

    public void add(T item) {
        add(size, item);
    }

    public void add(int index, T item) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        ListNode newNode = new ListNode(item);
        if (index == 0) {
            newNode.next = firstElement;
            firstElement = newNode;
        } else {
            ListNode previousElement = firstElement;
            for (int i = 0; i < index - 1; i++) {
                previousElement = previousElement.next;
            }
            newNode.next = previousElement.next;
            previousElement.next = newNode;
        }
        size++;
    }

    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        ListNode currentElement = firstElement;
        for (int i = 0; i < index; i++) {
            currentElement = currentElement.next;
        }
        return currentElement.value;
    }

    public T remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        T removed;
        if (index == 0) {
            removed = firstElement.value;
            firstElement = firstElement.next;
        } else {
            ListNode previousElement = firstElement;
            for (int i = 0; i < index - 1; i++) {
                previousElement = previousElement.next;
            }
            removed = previousElement.next.value;
            previousElement.next = previousElement.next.next;
        }
        size--;
        return removed;
    }

    public boolean remove(T item) {
        if (firstElement == null) {
            return false;
        }
        if (firstElement.value.equals(item)) {
            firstElement = firstElement.next;
            size--;
            return true;
        }
        ListNode currentElement = firstElement;
        while (currentElement.next != null) {
            if (currentElement.next.value.equals(item)) {
                currentElement.next = currentElement.next.next;
                size--;
                return true;
            }
            currentElement = currentElement.next;
        }
        return false;
    }

    public void clear() {
        firstElement = null;
        size = 0;
    }

    public boolean contains(T item) {
        return indexOf(item) != -1;
    }

    public int indexOf(T item) {
        ListNode currentElement = firstElement;
        int index = 0;
        while (currentElement != null) {
            if (currentElement.value.equals(item)) return index;
            currentElement = currentElement.next;
            index++;
        }
        return -1;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printAll() {
        ListNode currentElement = firstElement;
        while (currentElement != null) {
            System.out.println(currentElement.value);
            currentElement = currentElement.next;
        }
    }
}
