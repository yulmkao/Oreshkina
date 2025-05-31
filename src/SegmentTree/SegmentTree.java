package SegmentTree;

public class SegmentTree {
    private int[] tree;
    private int size;
    public int operations;

    public SegmentTree(int[] arr) {
        this.size = arr.length;
        this.tree = new int[2 * size];
        buildTree(arr);
    }

    public void buildTree(int[] arr) {
        operations = 0;
        long buildStart = System.nanoTime();
        for (int i = 0; i < arr.length; i++) {
            tree[size + i] = arr[i];
            operations += 2; // доступ, присваивание
        }
        for (int i = size - 1; i > 0; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
            operations += 3; // 2 доступа + сложение
        }
        long buildEnd = System.nanoTime();
        long buildTime = buildEnd - buildStart;
        System.out.println("построение дерева:");
        System.out.println("время: " + (buildTime / 1000.0) + " мкс");
        System.out.println("количество операций: " + operations);
    }

    public void update(int position, int value) {
        operations = 0;
        position += size;
        tree[position] = value;
        operations += 2;
        while (position > 1) {
            position /= 2;
            int left = position * 2;
            int right = position * 2 + 1;
            tree[position] = tree[left] + tree[right];
            operations += 3;
        }
    }

    public void remove(int index) {
        update(index, 0);
    }

    public int searchSum(int left, int right) {
        operations = 0;
        int sum = 0;
        left += size;
        right += size;
        operations += 2;
        while (left < right) {
            operations++;
            if (left % 2 == 1) {
                sum += tree[left];
                left++;
                operations += 2;
            }
            if (right % 2 == 1) {
                right--;
                sum += tree[right];
                operations += 2;
            }
            left /= 2;
            right /= 2;
            operations += 2;
        }
        return sum;
    }
}
