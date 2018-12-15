package tk.madhavareddy.digitaldiary.process.service.imp;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import tk.madhavareddy.digitaldiary.presentation.data.Diary;
import tk.madhavareddy.digitaldiary.process.service.DigitalDiaryService;
@Service
public class DigitalDiaryServiceImpl implements DigitalDiaryService {

	@Override
	public Diary createDiary() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Diary updateDiary() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Diary deleteDiary() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Diary getDiary(String id) {
		Diary diary = new Diary();
		if(id.equals("1")) {
		
		diary.setConetent("Hi today is happy day my first digital diary collection is started");
		diary.setEventId("EV001");
		LocalDate eventDate = LocalDate.now();
		diary.setEventDate(eventDate );
		diary.setLocation("Brussels");
		}
		return diary;
	}

}
