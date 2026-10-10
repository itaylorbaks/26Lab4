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
        for(int i = 1; i < n+1; i++ ){
            namesList.add("Person " + i);
        }
    }
    public void createTixLists(int totPeopleNum){
        for(int i = 1; i < totPeopleNum + 1; i++ ){
            MyLinkedList<Integer> list = new MyLinkedList<>();
            outer.add(list);
            System.out.println("added person" + i);
        }
    }

    public void assignTix(int totTixNum){
        ListIterator<MyLinkedList<Integer>> outerIterator = outer.listIterator();
        boolean forward = true;
        MyLinkedList<Integer> nextNode = new MyLinkedList<>();
        MyLinkedList<Integer> prevNode = new MyLinkedList<>();
        for (int i = 1; i < totTixNum + 1; i++){
            if (forward){
                if (outerIterator.hasNext()){
                System.out.println("hasnext");
                nextNode = outerIterator.next();
                nextNode.add(i);
                }
                else {
                    nextNode.add(i);
                    System.out.println("Switching to backward");
                    forward = false;
                    prevNode = outerIterator.previous();
                    System.out.println(forward);
                    
                }
            }
            else if (!forward){
                if (outerIterator.hasPrevious()){
                    System.out.println("hasprev");
                    prevNode = outerIterator.previous();
                    prevNode.add(i);
                }
                else {
                    prevNode.add(i);
                    System.out.println("Switching to forward");
                    forward = true;
                    nextNode = outerIterator.next();
                    System.out.println(forward);
                    
                }
                }
        }
    }

    public void printResults(){
        for (int i = 0; i < totPeopleNum; i++ ){
            System.out.println(namesList.get(i) + "'s Tickets:");
            int sum = 0;
            MyLinkedList<Integer> thisPerson = outer.get(i);
            ListIterator<Integer> thisPersonIterator = thisPerson.listIterator();
            
            while (thisPersonIterator.hasNext()){
                int ticket = thisPersonIterator.next();
                System.out.println("Ticket " + ticket);
                sum += ticket;
            }
            System.out.println("Sum of Tickets: " + sum);
            System.out.println(" ");


        }
    }
    



    public static void main(String[] args){
        if (args.length != 2) {
            System.out.println("Must Provide People and Tix Number");
            return;
        }
        if ((Integer.parseInt(args[1]) %2) != 0){
            System.out.println("Number of Tix must be a Multiple of 2 * the Number of People");
            return;
        }
        int instancePeople = Integer.parseInt(args[0]);
        int instanceTix = Integer.parseInt(args[1]);

        FairTickets thisFair = new FairTickets(instancePeople, instanceTix);
        thisFair.createNamesList(thisFair.totPeopleNum);
        thisFair.createTixLists(thisFair.totPeopleNum);
        thisFair.assignTix(thisFair.totTixNum);
        thisFair.printResults();



        




    
}
}
