import java.util.Iterator;

public class Professors implements Iterable<String> {

    private String[] names;

    public Professors(String[] names){
        this.names = names.clone();
    }

    public Iterator<String> iterator() {
        return new ProfessorIterator(this);
    }

    private class ProfessorIterator implements Iterator<String> {
        private Professors profs;
        private int index;

        ProfessorIterator(Professors profs){
            this.profs = profs;
            this.index = 0;
        }

        public boolean hasNext(){
            return (this.index < this.profs.names.length);
        }

        public String next(){
            String prof = "Professor " + this.profs.names[index];
            index++;
            return prof;
        }
    }


    public static void main(String[] args){

        String[] names = new String[] {
            "Eck", 
            "Feldman", 
            "Levinson", 
            "Taylor"
        };

        Professors profs = new Professors(names);
            for (String prof : profs) {
                System.out.println(prof);
            }
        
    }
    
}
