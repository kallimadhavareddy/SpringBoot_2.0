package tk.madhavareddy.digitaldiary.process.service;


import tk.madhavareddy.digitaldiary.presentation.data.Diary;

import java.util.List;

public interface DigitalDiaryService {
	Diary createDiary(Diary diary);
	Diary findDiary(int id);
	Diary updateDiary(Diary diary);
	void deleteDiaryById(int id);
	List<Diary> getAllDiaries();
}
