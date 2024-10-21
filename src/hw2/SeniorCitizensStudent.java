package hw2;

public class SeniorCitizensStudent extends NonDegreeSeekingStudent{
    
    public SeniorCitizensStudent(int studentID, String firstName, String lastName, int age,
    int numOfCredit){
        super(studentID, firstName, lastName, age, numOfCredit);
    }

    @Override
    public void printData(){
        System.out.println("ID number: " + studentID);
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Age: " + age);
        System.out.println(firstName + " is a senior citizens enrolled in " + numOfCredit + " credits");
    }

    @Override
    public int computeFees(){
        if(numOfCredit <= 6){
            return 100;
        }
        else{
            return 100 + 50 * (numOfCredit - 6);
        }
    }
}
