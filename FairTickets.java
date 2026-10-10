

public class FairTickets {
    public int totPeopleNum;
    public int totTixNum;

    public FairTickets(int totPeopleNum, int totTixNum){
        this.totPeopleNum = totPeopleNum;
        this.totTixNum = totTixNum;  
    }

    public void createNamesList(int n){
        MyLinkedList<String> namesList = new MyLinkedList<>();
        for(int i = 0; i < n; i++ ){
            namesList.add("Person " + n); 
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
