package hw2;
// TODO: Make sure you create a package named hw2 and add the package name to every Java file 

/*
 * To ensure you get graded correctly by autograder, 
 * DO NOT change the file name (Report.java), method name (generateReport), or add parameters to this method.
 * Fill in your code where there is a TODO comment.
 * Use the provided variables in the reportBuilder code. 
 * Check if your generateReport() output is equal to hw2_output.txt (String.equals())
 * 
 * Questions or comments? Ask on CourseAssist Course Chat
 * 
 */
public class Report {

	// generateReport() should be a public static method that takes no parameters and returns a String
	public static String generateReport() {
		StringBuilder reportBuilder = new StringBuilder();
		// TODO:
		
		// Read hw2.txt line by line
		// Hardcode "hw2.txt" as your input, which means that you should put hw2.txt 
		// right under your Eclipse workspace folder (the top level of the workspace hierarchy).

		// For each record, create an instance from the corresponding class (FinAssist,
		// NoFinAssist, Degree, etc.)

		// Save all instances to a Student[] array. Student is the interface or parent class for all the
		// classes you make.
		Student[] students; // save all the student record objects here

		// DO NOT ADD, CHANGE, OR DELETE ANY reportBuilder code. Use the provided variables.
		// INDIVIDUAL REPORTS, listing of all students and the fees they have each been
		// assessed
		int student_fee = 0; // TODO: Change this! Assign its value in the iteration below and use the
								// provided print statement
		String student_name = ""; // TODO: Change this! Assign its value in the iteration below and use the
									// provided print statement

		// Print out first and last name and fee amount
		reportBuilder.append("Summary of each student's fees assessed: \n\n");
		// TODO: iterate over all Student records and compute the individual student_fee. Assign student_name.
		// TODO: put the following line in your for/while loop so that every student's fee gets printed
		reportBuilder.append(student_name + " has $" + String.format("%,d", student_fee) + " fees assessed \n");
		
		
		// This should work once your Student classes are implemented
		// Don't worry about the string formatting in printData()  :)
		// Make sure you do not comment out the following two lines when you submit the hw
		students[0].printData();
		students[1].printData();
		
		
		// SUMMARY REPORT of fees assessed for each of the four types of student
		int degree_nofin_fees = 0;
		int degree_fin_fees = 0;
		int certificate_fees = 0;
		int senior_fees = 0;
		int total_fees = 0;

		// TODO: Calculate the fees by iterating through all students, or do it in the loop above
		
		
		// Print out the total fees for different students
		reportBuilder.append("\n\n");
		reportBuilder.append("Summary of all student fees assessed: \n\n");
		reportBuilder.append(
				"Degree-seeking students without financial assistance: $" + String.format("%,d", degree_nofin_fees) + "\n");
		reportBuilder
				.append("Degree-seeking students with financial assistance: $" + String.format("%,d", degree_fin_fees) + "\n");
		reportBuilder.append("Certificate students: $" + String.format("%,d", certificate_fees) + "\n");
		reportBuilder.append("Senior citizens: $" + String.format("%,d", senior_fees) + "\n\n");
		reportBuilder.append("Total fees assessed: $" + String.format("%,d", total_fees));

		return reportBuilder.toString();
	}

	public static void main(String[] args) {
		// You may test your Report here by comparing the output with the provided hw2_output.txt
		System.out.println(generateReport());
	}
}
