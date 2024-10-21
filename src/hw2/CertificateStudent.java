package hw2;

public class CertificateStudent extends NonDegreeSeekingStudent{

    String certificateType;
    
    public CertificateStudent(int studentID, String firstName, String lastName,
        int age, int numOfCredit, String certificateType){

            super(studentID, firstName, lastName, age, numOfCredit);
            this.certificateType = certificateType;
    }

    @Override
    public void printData(){
        System.out.println("ID number: " + studentID);
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Age: " + age);
        System.out.println(firstName + " is a certificate student enrolled in " + numOfCredit + " credits");
    }

    @Override
    public int computeFees(){
        return 700 + 300 * numOfCredit;
    }
}
