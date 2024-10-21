package hw2;
// TODO: Make sure you create a package named hw2 and add the package name to every Java file 

import java.io.BufferedReader;
import java.io.IOException;

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
		students = new Student[100];
		int studentCount = 0;

		try (BufferedReader reader = new BufferedReader(new java.io.FileReader("hw2.txt"))) {
			String line = reader.readLine();
			do {

				String[] tokens = line.split(";");
                int id = Integer.parseInt(tokens[0]);
                String firstName = tokens[1];
                String lastName = tokens[2];
                int age = Integer.parseInt(tokens[3]);
                int creditHours = Integer.parseInt(tokens[4]);

				if(tokens[5].equals("Y")){

					String major = mapMajor(tokens[6]);
					String academicStanding = mapAcademicStanding(tokens[7]);

					if(tokens[8].equals("Y")){

						int financialAid = Integer.parseInt(tokens[9]);

						students[studentCount++] = new DegreeSeekingWithAssistance(id, firstName, lastName, age, creditHours, major, academicStanding, financialAid);
					}
					else{
						students[studentCount++] = new DegreeSeekingWithoutAssistance(id, firstName, lastName, age, creditHours, major, academicStanding);
					}		
				}
				else{
					if(tokens[6].equals("S")){
						students[studentCount++] = new SeniorCitizensStudent(id, firstName, lastName, age, creditHours);
					}
					else if (tokens[6].equals("C")){
						String certificateType = mapMajor(tokens[7]);
						students[studentCount++] = new CertificateStudent(id, firstName, lastName, age, creditHours, certificateType);
					}
				}
			} while ((line = reader.readLine()) != null && studentCount != 0);
			
		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}


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

		for(int i = 0; i < studentCount; i++){
			Student student = students[i];
			student_name = student.firstName + " " + student.lastName;
			student_fee = student.computeFees();
			reportBuilder.append(student_name + " has $" + String.format("%,d", student_fee) + " fees assessed \n");
		}		
		
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
		for(int i = 0; i < studentCount; i++){
			Student student = students[i];
			student_fee = student.computeFees();
			if(student instanceof DegreeSeekingWithAssistance){
				degree_fin_fees += student_fee; 
			}
			else if(student instanceof DegreeSeekingWithoutAssistance){
				degree_nofin_fees += student_fee;
			}
			else if(student instanceof CertificateStudent){
				certificate_fees += student_fee;
			}
			else if(student instanceof SeniorCitizensStudent){
				senior_fees += student_fee;
			}
		}
		total_fees = degree_nofin_fees + degree_fin_fees + certificate_fees + senior_fees;
		
		
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

	private static String mapMajor(String code){
		switch (code){
			case "S": return "Gaming Science";
			case "M": return "Hotel Management";
			case "A": return "Lounge Arts";
			case "E": return "Beverage Engineering";
			default: return "Unknown";
		}
	}

	private static String mapAcademicStanding(String code) {
		switch(code){
			case "G": return "Good";
			case "W": return "Warning";
			case "P": return "Probation";
			default: return "Unknown";
		}
	}
}
