
public class Date {
	
	public int year, month, day;
	
	int daysDifference;
	//int yearsDifferenceInDays;
	
	//sets all of the information to the object (constructor)
	public Date(int month, int day, int year) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	//sets the year
	public void setYear(int year) {
		this.year = year;
	}
		
	//sets the month
	public void setMonth(int month) {
		this.month = month;
	}
		
	//sets the day
	public void setDay(int day) {
		this.day = day;
	}
	
	//gets the year
	public int getYear() {
		return year;
	}
	
	//gets the month
	public int getMonth() {
		return month;
	}
	
	//gets the day
	public int getDay() {
		return day;
	}
	
	public int dayOfYear() {
		int totalDays = 0;
		switch (month) {
			case 12: totalDays += 30;
			case 11: totalDays += 31;
			case 10: totalDays += 30;
			case 9 : totalDays += 31;
			case 8 : totalDays += 31;
			case 7 : totalDays += 30;
			case 6 : totalDays += 31;
			case 5 : totalDays += 30;
			case 4 : totalDays += 31;
			case 3 : totalDays += 28;
			case 2 : totalDays += 31;
			}
			totalDays += day;
			return totalDays;
		}
	
	//returns the difference between the current birth date and the input date
	public int compare(Date dt) {
		int difference;
		int yearsDifferenceInDays;
		int daysDifference;
		int totalDifference;
		int monthDifference;
		
		difference = this.month - dt.getMonth();
		
		yearsDifferenceInDays = Math.abs(this.year - dt.getYear()) * 365;
		
		daysDifference = Math.abs(dayOfYear() - dt.dayOfYear());
		
		totalDifference = Math.abs(yearsDifferenceInDays - daysDifference);
		
		monthDifference = totalDifference / 30;
		
		if(monthDifference > 60) {
			return 60;
		}
		else {
			return monthDifference;
		}
		
	}
		
}



