package hw2;

public abstract class Student {
    protected int studentID;
    protected String firstName;
    protected String lastName;
    protected int age;
    protected int numOfCredit;

    public Student(int studentID, String firstName, String lastName, int age, int numOfCredit){
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.numOfCredit = numOfCredit;
    }

    public abstract void printData();

    public abstract int computeFees();
}
