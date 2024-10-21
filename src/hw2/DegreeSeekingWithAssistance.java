package hw2;

public class DegreeSeekingWithAssistance extends DegreeSeekingStudent {

    private int financialAid;

    public DegreeSeekingWithAssistance(int studentID, String firstName, String lastName, int age, 
        int numOfCredit, String major, String academicStanding, int financialAid) {

        super(studentID, firstName, lastName, age, numOfCredit, major, academicStanding);

        this.financialAid = financialAid;
    }

    @Override
    public void printData(){

        super.printData();

        System.out.println(firstName + " receives $" + financialAid + " in financial assistance per term");
    }

    @Override
    public int computeFees(){

        int baseFee = 100 + 50 + 275 * Math.min(numOfCredit, 12);

        return Math.max(baseFee - financialAid, 0);
    }
}
