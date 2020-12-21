
public class Student {
	
	public String name;
	public char gender;
	public Date birthDate;
	public Preference pref;
	public Boolean matched = false; //sets matched as default
	
	//sets all of the information per student to an object
	public Student(String name, char gender, Date birthDate, Preference pref) {
		this.name = name;
		this.gender = gender;
		this.birthDate = birthDate;
		this.pref = pref;
	}
	
	//sets name
	public void setName(String name){
		this.name = name;
	}
		
	//sets gender
	public void setGender(char gender){
		this.gender = gender;
	}
		
	//sets birthday
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
		
	//sets preference
	public void setPreference(Preference pref) {
		this.pref = pref;
	}
		
	//sets matched 
	public void setMatched(Boolean matched) {
		this.matched = matched;
	}
	
	//returns name
	public String getName(){
		return name;
	}
	
	//returns gender
	public char getGender(){
		return gender;
	}
	
	//returns birthday
	public Date getBirthDate() {
		return birthDate;
	}
	
	//returns preference
	public Preference getPreference() {
		return pref;
	}
	
	//returns matched 
	public Boolean getMatched() {
		return matched;
	}
	
	//returns compatibility score
	public int compare(Student st) {
		int score;
		//automatic 0 is different gender
		if(gender != st.getGender()) {
			score = 0;
			return score;
		}
		
		//calculates different score if the genders are the same
		else {
			
			//total of the preference numbers added up
			int addedTotalPrefStudentA = pref.getQuietTime() + pref.getMusic() + pref.getReading() + pref.getChatting();
			int addedTotalPrefStudentB = st.pref.getQuietTime() + st.pref.getMusic() + st.pref.getReading() + st.pref.getChatting();
			
			int birthDateMonthStudentA = birthDate.getMonth();
			int birthDateMonthStudentB = st.birthDate.getMonth();
			int birthDateYearStudentA = birthDate.getYear();
			int birthDateYearStudentB = st.birthDate.getYear();
			
			score = (40 - Math.abs(addedTotalPrefStudentA - addedTotalPrefStudentB)) + (60 - Math.abs((birthDateMonthStudentA) - birthDateMonthStudentB)); 
			return score;
		}
	}
}
