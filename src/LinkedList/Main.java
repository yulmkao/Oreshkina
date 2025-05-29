package LinkedList;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        System.out.println("=== Тестирование MyLinkedList ===");
        System.out.println("пустой список: " + list.isEmpty());

        System.out.println("добавляем элементы:");
        list.add("первый");
        list.add("второй");
        list.add("третий");
        list.add("четвертый");
        list.add(2, "серединка");

        list.printAll();
        System.out.println("размер списка: " + list.size());

        System.out.println("получаем элементы:");
        System.out.println("элемент с индексом 0: " + list.get(0));
        System.out.println("элемент с индексом 2: " + list.get(2));

        System.out.println("проверяем наличие элементов:");
        System.out.println("содержится ли слово второй? " + list.contains("второй"));
        System.out.println("содержится ли слово шестой? " + list.contains("шестой"));
        System.out.println("индекс третьего элемента: " + list.indexOf("третий"));

        System.out.println("удаляем элементы:");
        System.out.println("удаляем элемент с индексом 1: " + list.remove(1));
        System.out.println("удаляем третий элемент" + list.remove("третий"));
        System.out.println("удаляем седьмой элемент" + list.remove("седьмой"));

        list.printAll();
        System.out.println("размер списка после удаления: " + list.size());

        System.out.println("очищаем список:");
        list.clear();
        System.out.println("список пустой? " + list.isEmpty());
        System.out.println("размер списка: " + list.size());

        System.out.println("добавляем элементы после очистки:");
        list.add("новый первый");
        list.add("новый второй");
        list.printAll();
    }
}