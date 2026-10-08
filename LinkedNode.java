public class LinkedNode<T> {

    public T data;

    public LinkedNode<T> next;

    public LinkedNode(T data, LinkedNode<T> next){
        this.data = data;
        this.next = next;
    }



    public static void main(String[] args) {
        LinkedNode<String> thirdNode = new LinkedNode<String>("third", null);
        LinkedNode<String> secondNode = new LinkedNode<String>("second", thirdNode);
        LinkedNode<String> firstNode = new LinkedNode<String>("first", secondNode);

        for (LinkedNode<String> node = firstNode; node != null; node = node.next) {
            System.out.println(node.data);
        }



    }
    
}
