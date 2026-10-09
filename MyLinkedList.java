import java.util.AbstractList;

public class MyLinkedList<T> extends AbstractList<T>{
    private DoublyLinkedNode firstNode;
    private DoublyLinkedNode lastNode;
    private int size;

    public MyLinkedList(){
        this.firstNode = null;
        this.lastNode = null;
        this.size = 0;
    }

    private class DoublyLinkedNode {
        private T item;
        private DoublyLinkedNode previous;
        private DoublyLinkedNode next;

        public DoublyLinkedNode(T item, DoublyLinkedNode previous, DoublyLinkedNode next){
            this.item = item;
            this.previous = previous;
            this.next = next;
        }

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

    public int size(){
        return this.size;
    }

    public T get(int index) {
        if (index >= this.size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        DoublyLinkedNode node = getNthNode(index);
        return node.item;

    }
    public void add(int index, T item){
        if(item == null){
            throw new NullPointerException();
        }
        if(index < 0 || index> this.size){
            throw new IndexOutOfBoundsException();
        }
        if(size == 0){
            DoublyLinkedNode newNode = new DoublyLinkedNode(item, null, null);
            this.firstNode = newNode;
            this.lastNode = newNode;
            this.size++;
            return;
        }

        if (index == 0){
            DoublyLinkedNode newNode = new DoublyLinkedNode(item, null, this.firstNode);
                this.firstNode.previous = newNode;
                this.firstNode = newNode;
                this.size++;
                return;
        
        }
        if (index == this.size){
            DoublyLinkedNode newNode = new DoublyLinkedNode(item, this.lastNode, null);
                this.lastNode.next = newNode;
                this.lastNode = newNode;
                this.size++;
                return;
            
        }
        
        DoublyLinkedNode newNode = new DoublyLinkedNode(item, getNthNode(index).previous, getNthNode(index));
            getNthNode(index).previous.next = newNode;
            getNthNode(index).previous = newNode;
            this.size++;
        }

        public boolean add(T item){
            add(this.size, item);
            return true;
        }

        public T set(int index, T item){
            if (item == null){
                throw new NullPointerException();
            }
            if (index > this.size || index < 0){
                throw new IndexOutOfBoundsException();
            }
            T savedNode = getNthNode(index).item;
            getNthNode(index).item  =  item;
            return savedNode;
        }

        public T remove(int index){
            if (index > this.size || index < 0){
                throw new IndexOutOfBoundsException();
            }
            DoublyLinkedNode removedNode = getNthNode(index);
            if (removedNode.item == null){
                throw new NullPointerException();
            }
            removedNode.previous.next = removedNode.next;
            removedNode.next.previous = removedNode.previous;
            this.size--;
            return removedNode.item;          
        }
    }




