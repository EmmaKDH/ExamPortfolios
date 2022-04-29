import java.util.ArrayList;
import java.util.HashMap;

public class MinHeap<T extends Comparable<T>> {
    HashMap<T, Integer> positionTable = new HashMap<>();        //Creates a new HashMap

    // root is at index 0
    ArrayList<T> minheap;
    private int size;
//Defines MinHeap
    public MinHeap() {
        this.minheap = new ArrayList<T>();
        this.size = 0;
    }

    public int getPosition(T item) {
        return positionTable.get(item);
    }

    public boolean isEmpty() {
        return size <= 0;
    }

    private int Parent(int pos) {
        return (pos - 1) / 2;
    }

    private int leftChild(int pos) {
        return pos * 2 + 1;
    }

    private int rightChild(int pos) {
        return pos * 2 + 2;
    }
//Creates a functions to swap positions, with dummy positions for now
    private void swap(int pos1, int pos2) {
        T dummy = minheap.get(pos1);

        minheap.set(pos1, minheap.get(pos2));
        minheap.set(pos2, dummy);
        positionTable.put(minheap.get(pos1), pos1);
        positionTable.put(minheap.get(pos2), pos2);
    }

    public void Insert(T item) {
        minheap.add(item);
        positionTable.put(item, size);
        size++;
        decreasekey(size - 1);
    }

    public void decreasekey(int pos) {
        int currentpos = pos;
        while (minheap.get(currentpos).compareTo(minheap.get(Parent(currentpos))) < 0) {
            swap(currentpos, Parent(currentpos));
            currentpos = Parent(currentpos);
        }
    }

    private boolean movedown(int pos) {
        boolean leftsmaller = leftChild(pos) < size
                && (minheap.get(leftChild(pos)).compareTo(minheap.get(pos)) < 0);
        boolean rightsmaller = rightChild(pos) < size
                && (minheap.get(rightChild(pos)).compareTo(minheap.get(pos)) < 0);
        return leftsmaller || rightsmaller;
    }

    public void increasekey(int pos) {
        int currentpos = pos;
        while (movedown(currentpos)) {
            int rpos = rightChild(currentpos);
            int lpos = leftChild(currentpos);
            if (rpos < size && minheap.get(rpos).compareTo(minheap.get(lpos)) < 0) {
                swap(rpos, currentpos);
                currentpos = rpos;
            } else {
                swap(lpos, currentpos);
                currentpos = lpos;
            }
        }
    }

    public T extractMin() {
        T min = minheap.get(0);
        minheap.set(0, minheap.get(size - 1));
        positionTable.put(minheap.get(0), 0);
        size--;
        increasekey(0);
        return min;
    }
}