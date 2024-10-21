package hw2;

public class DegreeSeekingWithoutAssistance extends DegreeSeekingStudent {

    public DegreeSeekingWithoutAssistance(int studentID, String firstName, String lastName, int age, 
        int numOfCredit, String major, String academicStanding){

        super(studentID, firstName, lastName, age, numOfCredit, major, academicStanding);
    }

    @Override
    public int computeFees(){
        
        return 100 + 50 + 275 * Math.min(numOfCredit, 12);
    }
}
