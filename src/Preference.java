
public class Preference {

	public int quietTime, music, reading, chatting;
	
	public Preference(int quietTime, int music, int reading, int chatting) {
		this.quietTime = quietTime;
		this.music = music;
		this.reading = reading;
		this.chatting = chatting;
	}
	
	//gets the quietTime preference
	public int getQuietTime() {
		return quietTime;
	}
	
	//gets the music preference 
	public int getMusic() {
		return music;
	}
	
	//gets the reading preference
	public int getReading() {
		return reading;
	}
	
	//gets the chatting preference
	public int getChatting() {
		return chatting;
	}
	
	//sets the quietTime preference
	public void setQuietTime(int quietTime) {
		this.quietTime = quietTime;
	}
		
	//sets the music preference 
	public void setMusic(int music) {
		this.music = music;
	}
		
	//sets the reading preference
	public void setReading(int reading) {
		this.reading = reading;
	}
		
	//sets the chatting preference
	public void setChatting(int chatting) {
		this.chatting = chatting;
	}
	
	//returns difference for the activities from the two students being compared
	public int compare(Preference pref) {
		return (Math.abs(quietTime - pref.getQuietTime()) + Math.abs(music - pref.getMusic()) + Math.abs(reading - pref.getReading()) + Math.abs(chatting - pref.getChatting()));
	}
}
