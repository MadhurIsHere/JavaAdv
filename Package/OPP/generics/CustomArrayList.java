package OPP.generics;

public class CustomArrayList<T> {
    private Object[] data;
    private static final int DEFAULT_SIZE = 1;
    private int size = -1;

    public CustomArrayList() {
        this.data = new Object[DEFAULT_SIZE];
        this.size = 0;
    }

    public void add(int num) {
        if (isFull()) {
            resize();
        }
        data[size++] = num;
    }

    private void resize() {
        Object[] temp = new Object[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    private boolean isFull() {
        return size == data.length;
    }

    public Object remove() {
        return data[--size];
    }

    public Object get(int index) {
        if (index < size) {
            return data[index];
        }
        return null;
    }

    public int size() {
        return size;
    }

    public void set(T val, int index) {
        if (index >= size) {
            resizeInd(index);
        }
        data[index] = val;
    }

    private void resizeInd(int index) {
        Object[] temp = new Object[index + 1];
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    public void display() {
        System.out.print('[');
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + ", ");
        }
        System.out.println(']');
    }

    public static void main(String[] args) {
        CustomArrayList<Character> list = new CustomArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add((char) (i - '0'));
        }
        System.out.println(list.size);
        list.display();
        System.out.println(list.remove());
        System.out.println(list.get(8));
        list.set('1', 110);
        list.display();
    }
}
