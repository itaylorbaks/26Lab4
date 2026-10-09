
import java.util.AbstractList;
import java.util.Iterator;
import java.util.ListIterator;

public class MyLinkedList<T> extends AbstractList<T> {
    private DoublyLinkedNode firstNode;
    private DoublyLinkedNode lastNode;
    private int size;

    public MyLinkedList() {
        this.firstNode = null;
        this.lastNode = null;
        this.size = 0;
    }

    private class DoublyLinkedNode {
        private T item;
        private DoublyLinkedNode previous;
        private DoublyLinkedNode next;

        public DoublyLinkedNode(T item, DoublyLinkedNode previous,
                                DoublyLinkedNode next) {
            this.item = item;
            this.previous = previous;
            this.next = next;
        }
    }

    private class MyLinkedListIterator implements ListIterator<T> {
        private DoublyLinkedNode previousNode;
        private DoublyLinkedNode nextNode;

        public MyLinkedListIterator(DoublyLinkedNode previousNode,
                                    DoublyLinkedNode nextNode) {
            this.previousNode = previousNode;
            this.nextNode = nextNode;
        }
    }

    public ListIterator<T> listIterator() {
        return new MyLinkedListIterator(null, firstNode);
    }

    public Iterator<T> iterator() {
        return listIterator();
    }

    private DoublyLinkedNode getNthNode(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }

        DoublyLinkedNode thisNode = this.firstNode;

        for (int count = 0; count < index; count++) {
            thisNode = thisNode.next;
        }

        return thisNode;
    }

    public int size() {
        return this.size;
    }

    public T get(int index) {
        DoublyLinkedNode node = getNthNode(index);
        return node.item;
    }

    public void add(int index, T item) {
        if (item == null) {
            throw new NullPointerException();
        }

        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException();
        }

        if (size == 0) {
            DoublyLinkedNode newNode =
                    new DoublyLinkedNode(item, null, null);
            this.firstNode = newNode;
            this.lastNode = newNode;
            this.size++;
            return;
        }

        if (index == 0) {
            DoublyLinkedNode newNode =
                    new DoublyLinkedNode(item, null, this.firstNode);
            this.firstNode.previous = newNode;
            this.firstNode = newNode;
            this.size++;
            return;
        }

        if (index == this.size) {
            DoublyLinkedNode newNode = new DoublyLinkedNode(item, this.lastNode, null);
            this.lastNode.next = newNode;
            this.lastNode = newNode;
            this.size++;
            return;
        }

        DoublyLinkedNode currentNode = getNthNode(index);
        DoublyLinkedNode newNode = new DoublyLinkedNode(item, currentNode.previous, currentNode);

        currentNode.previous.next = newNode;
        currentNode.previous = newNode;
        this.size++;
    }

    public boolean add(T item) {
        add(this.size, item);
        return true;
    }

    public T set(int index, T item) {
        if (item == null) {
            throw new NullPointerException();
        }

        DoublyLinkedNode node = getNthNode(index);
        T savedNode = node.item;
        node.item = item;
        return savedNode;
    }

    public T remove(int index) {
        DoublyLinkedNode removedNode = getNthNode(index);

        if (removedNode.previous == null) {
            this.firstNode = removedNode.next;
        } else {
            removedNode.previous.next = removedNode.next;
        }

        if (removedNode.next == null) {
            this.lastNode = removedNode.previous;
        } else {
            removedNode.next.previous = removedNode.previous;
        }

        this.size--;
        return removedNode.item;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void clear() {
        this.firstNode = null;
        this.lastNode = null;
        this.size = 0;
    }
}
