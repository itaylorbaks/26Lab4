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

    public int size(){
        return this.size;
    }

    public T get(int index) {
     // TODO: we will fill this in soon
        return null;
    }
    private DoublyLinkedNode getNthNode(int index){
        int count = 0;
        DoublyLinkedNode thisNode = this.firstNode;
        while(count < index && thisNode!= null){
            thisNode = thisNode.next;
            count++;
        }
        if (thisNode == null){
            throw new IndexOutOfBoundsException();
        }
        else{
            return thisNode;
        }
    }
    public void add(int index, T item){
        if(item == null){
            throw new NullPointerException();
        }
        if(index < 0 || index> this.size){
            throw new IndexOutOfBoundsException();
        }
        if(size == 0){
            DoublyLinkedNode newNode = new DoublyLinkedNode(item, firstNode, lastNode);
            this.firstNode = newNode;
            this.lastNode = newNode;
            this.size++;
        }

        if (index == 0){
            DoublyLinkedNode newNode = new DoublyLinkedNode(item, null, firstNode){
                this.firstNode.previous = newNode;
                this.firstNode = newNode;
                size++;
            }
        }
        if (index == this.size){
            DoublyLinkedNode newNode = new DoublyLinkedNode(item, lastNode, null){
                this.lastNode.next = newNode;
                this.lastNode = newNode;
                size++;
            }
        }
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
}