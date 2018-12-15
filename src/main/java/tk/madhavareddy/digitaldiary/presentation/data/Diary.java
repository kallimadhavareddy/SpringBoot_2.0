package tk.madhavareddy.digitaldiary.presentation.data;

import java.time.LocalDate;

public class Diary {
	private String eventId;
	private String conetent;
	private LocalDate eventDate;
	private String location;
	public String getEventId() {
		return eventId;
	}
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	public String getConetent() {
		return conetent;
	}
	public void setConetent(String conetent) {
		this.conetent = conetent;
	}
	public LocalDate getEventDate() {
		return eventDate;
	}
	public void setEventDate(LocalDate eventDate) {
		this.eventDate = eventDate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}	
}
