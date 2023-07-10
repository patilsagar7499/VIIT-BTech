public class Assignment6 {
    private int[] table;
    private int capacity;
    private int size;

    public Assignment6(int capacity) {
        this.capacity = capacity;
        this.table = new int[capacity];
        this.size = 0;
    }

    public int hash(int key) {
        return key % capacity;
    }

    public void put(int key, int value) {
        int index = hash(key);

        while (table[index] != 0) {
            if (table[index] == key) {
                table[index] = value;
                return;
            }
            index = (index + 1) % capacity;
        }

        table[index] = key;
        size++;
    }

    public int get(int key) {
        int index = hash(key);

        while (table[index] != 0) {
            if (table[index] == key) {
                return table[index];
            }
            index = (index + 1) % capacity;
        }

        return 0;
    }

    public void remove(int key) {
        int index = hash(key);

        while (table[index] != 0) {
            if (table[index] == key) {
                table[index] = 0;
                size--;
                return;
            }
            index = (index + 1) % capacity;
        }
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        Assignment6 table = new Assignment6(10);

        table.put(1, 10);
        table.put(11, 20);
        table.put(21, 30);
        table.put(31, 40);
        table.put(41, 50);

        System.out.println(table.get(1)); // Output: 10
        System.out.println(table.get(11)); // Output: 20
        System.out.println(table.get(21)); // Output: 30
        System.out.println(table.get(31)); // Output: 40
        System.out.println(table.get(41)); // Output: 50

        table.remove(21);

        System.out.println(table.get(21)); // Output: 0
    }
}
