public class GenericArrayListImplementation <T> {
    private T[] data;
    private int size;

    private void resizeData(int newSize) {
        Object[] newArr = new Object[newSize];
        if (newSize >= size) {
            for (int i = 0; i < data.length; i++) {
                newArr[i] = data[i];
            }
        }
        else {
            for (int i = 0; i < data.length - 1; i++) {
                newArr[i] = data[i];
            } 
        }
        data = (T[]) newArr;
        size = newSize;
    }
    
    public GenericArrayListPt2(int initialCapacity) {
        this.size = initialCapacity;
        data = (T[]) new Object[size];
    }

    public void add(T str) {
        if (data[data.length - 1] != null) {
            resizeData(size() + 1);
        }
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null) {
                data[i] = str;
                break;
            }
        }
    }

    public void add(int index, T str) {
        if (index >= data.length) {
            return;
        }
        if (data[data.length - 1] != null) {
            resizeData(size() + 1);
        }
 
        for (int i = data.length - 1; i > index; i--) {
            data[i] = data[i - 1];

        }
        data[index] = str;
    }

    public T get(int index) {
        if (index >= data.length) return null;
        else return data[index];
    }

    public void remove(int index) {
        if (index >= data.length) {
            return;
        }
        for (int i = index; i < data.length - 1; i++) {
            data[i] = data[i + 1];
        }
        resizeData(size() - 1);
    }

    public int size() {
        return size;
    }

    public boolean contains(T str) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(str)) return true;
        }
        return false;
    }
}

