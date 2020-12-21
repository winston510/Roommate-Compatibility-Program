import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Match {
	public static void main(String[] args) throws IOException {
		
		String name, togetherBirthDate; 
		char gender;
		int quietTime, music, reading, chatting, month, day, year;
		int counter = 0; //to hold the value of how many students are scanned
		
		//array to hold all the students data
		Student[] studentInformation = new Student[100]; 
		
		//blank array slot to start off the comparison
		Student[] blank = new Student[1];
		Date blankBirthDate = new Date(0, 0, 0);
		Preference blankPref = new Preference(0, 0, 0, 0);
		Student blankInformation = new Student("blank", 'b', blankBirthDate, blankPref);
		blank[0] = blankInformation;
		
		
		//input for file and where the scan begins
		System.out.print("\nEnter the name of file to open: ");
	
		Scanner kbd = new Scanner(System.in); 
		
		String filename = kbd.next(); // holds the file name
		
		Scanner input = new Scanner(new FileReader(filename)); //creates the scanner 
		
		while(input.hasNextLine()) { //checks if there are still lines to read
			
			Scanner line = new Scanner(input.nextLine());
			line.useDelimiter("[\t\r]"); //can be used to fix storing birth date situation
			
		    name = line.next();
			
			gender = line.next().charAt(0); // looks at the letter at the first position
			
		    togetherBirthDate = line.next();
			Scanner seperatedBirthDate = new Scanner(togetherBirthDate); //scanner for the birth date
			seperatedBirthDate.useDelimiter("[\t-]"); //uses the "-" to fix the spacing situation for the dates to break it down
			
			month = seperatedBirthDate.nextInt();
			day = seperatedBirthDate.nextInt();
			year = seperatedBirthDate.nextInt();
			
			quietTime = line.nextInt();
			music = line.nextInt();
			reading = line.nextInt();
			chatting = line.nextInt();
			
			//creates the objects with the information
			Date birthDate = new Date(month, day, year);
			Preference pref = new Preference(quietTime, music, reading, chatting);
			Student information = new Student(name, gender, birthDate, pref); // this had everything combined in there which is also why it is last
			
			studentInformation[counter] = information; //uses the counter to know which array spot to store the information 
			
			counter ++; // adds 1 to counter per student info scanned
			
		}
		
		//listed all the for loop variable outside 
		int i;
		int j;
		int k;
		int l;
		int m;
		
		//array to hold the students for the best matches
		Student[] topMatchedA = new Student[100];
		Student[] topMatchedB = new Student[100];
		
		//loop that fills in all of the spots in the array
		for(l = 0; l < 100; l++) {
			topMatchedA[l] = blank[0];
			topMatchedB[l] = blank[0];
		}
		
		//record best match and best score match
		for(i = 0; i < counter; i++) {
			
			//put it here so that it resets every time we run the loop again
			Student bestMatchedStudent = blank[0]; //holds the best match
			int bestScore = 0; //holds the best score value
			Boolean foundMatchBestScore = false; //holds whether there is a match of that student already in the top matched array
			
			//compares each student to each other from left to right one at a time
			for (j = 0; j < counter; j ++) { 
				
				//starts comparing each student (finds the best score after running)
				if(studentInformation[i] != studentInformation[j] && studentInformation[i].getGender() == studentInformation[j].getGender() && studentInformation[j].getMatched() == false) {//checks to if they are comparing the same student to itself and gender are the same and checks if the first and second person has a match status of false 
					if(studentInformation[i].compare(studentInformation[j]) > bestScore) {
						bestMatchedStudent = studentInformation[j]; //holds the best match student
						bestScore = studentInformation[i].compare(studentInformation[j]); //holds the best score
					}
				}
			}
			
			//checks if studentInformation[i] or bestMatchedStudent matches with any other the objects in the array that stores the top score matches
			for(m = 0; m < 100; m++) {
				if(studentInformation[i] == topMatchedA[m] || studentInformation[i] == topMatchedB[m] || bestMatchedStudent == topMatchedA[m] || bestMatchedStudent == topMatchedB[m]) {
					foundMatchBestScore = true; //flip the switch to true
					break; //once they find a match no need to run the whole thing it will break
				}
			}
			
			//prints of the matches and stores them into the best score array for the match
			if(bestMatchedStudent != blank[0] && foundMatchBestScore == false) { // if the boolean is false that means there is no match in the top score array  and if bestMatchedStudent has not been changed
				studentInformation[i].setMatched(true); //set matched to true
				bestMatchedStudent.setMatched(true); // set matched to true
				System.out.println(studentInformation[i].getName() + " matches with " + bestMatchedStudent.getName() + " with the score " + bestScore); //print
				topMatchedA[i] = studentInformation[i];
				topMatchedB[i] = bestMatchedStudent;
			}
		}
		
		
		//loop that finds and prints all of the people that were not matched
		for(k = 0; k < counter; k++) {
			if(studentInformation[k].getMatched() == false) {
				System.out.println(studentInformation[k].getName() + " has no matches.");
			}
		}
	}
	
}
