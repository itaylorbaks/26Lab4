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