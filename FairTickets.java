import java.util.ListIterator;

public class FairTickets {
    public int totPeopleNum;
    public int totTixNum;
    public MyLinkedList<String> namesList = new MyLinkedList<>();
    public MyLinkedList<MyLinkedList<Integer>> outer = new MyLinkedList<>();


    public FairTickets(int totPeopleNum, int totTixNum){
        this.totPeopleNum = totPeopleNum;
        this.totTixNum = totTixNum;  
    }

    public void createNamesList(int n){
        for(int i = 0; i < n; i++ ){
            namesList.add("Person " + i);
        }
    }
    public void createTixLists(int totPeopleNum){
        for(int i = 0; i < totPeopleNum; i++ ){
            MyLinkedList<Integer> list = new MyLinkedList<>();
            outer.add(list);
        }
    }

    public void assignTix(int totTixNum){
        ListIterator<MyLinkedList<Integer>> outerIterator = outer.listIterator();
        boolean forward = true;
        for (int i = 0; i < totTixNum; i++){
            if (forward){
                if (outerIterator.hasNext()){
                MyLinkedList<Integer> nextNode = outerIterator.next();
                nextNode.add(i);
                }
                else {
                    forward = false;
                }
            }
            if (!forward){
                if (outerIterator.hasPrevious()){
                MyLinkedList<Integer> prevNode = outerIterator.previous();
                prevNode.add(i);
                }
                else {
                    forward = true;
                }
                }
        }
    }

    public String printResults(){
        for(int i = 0; i < totPeopleNum; i++ ){
            String personName = namesList.getNthNode(i).item;

        }

    }
    



    public static void main(String[] args){
        if (args.length != 2) {
            System.out.println("Must Provide People and Tix Number");
            return;
        }
        if (Integer.parseInt(args[1]) != Integer.parseInt(args[0])*2){
            System.out.println("Number of Tix must be double the Number of People");
            return;
        }
        new FairTickets(Integer.parseInt(args[0]), Integer.parseInt(args[1]));




    
}
}
