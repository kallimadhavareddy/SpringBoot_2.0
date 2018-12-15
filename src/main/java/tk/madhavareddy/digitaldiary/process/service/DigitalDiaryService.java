package tk.madhavareddy.digitaldiary.process.service;



import tk.madhavareddy.digitaldiary.presentation.data.Diary;

public interface DigitalDiaryService {	
	public Diary createDiary();
	public Diary updateDiary();
	public Diary deleteDiary();
	public Diary getDiary(String id);

}
