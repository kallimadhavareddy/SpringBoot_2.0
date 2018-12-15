package tk.madhavareddy.digitaldiary.presentation.data;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Setter
@Getter
public class Diary {
	private String eventId;
	private String conetent;
	private LocalDate eventDate;
	private String location;
}
