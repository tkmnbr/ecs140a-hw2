package hw2;

/**
 * DegreeSeekingStudent
 */
public abstract class DegreeSeekingStudent extends Student {

    protected String major;
    protected String academicStanding;

    public DegreeSeekingStudent(int studentID, String firstName, String lastName, int age, int numOfCredit, String major, String academicStanding) {
        super(studentID, firstName, lastName, age, numOfCredit);
        this.major = major;
        this.academicStanding = academicStanding;
    }

    @Override
    public void printData() {
        System.out.println("ID number: " + studentID);
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Age: " + age);
        System.out.println(firstName + " is a degree-seeking student enrolled in " + numOfCredit + " credits");
        System.out.println(firstName + "'s major is " + major);
        System.out.println(firstName + "'s academic standing is " + academicStanding);
    }
}