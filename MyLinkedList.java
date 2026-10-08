public class MyLinkedList<T> extends AbstractList<T>{

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