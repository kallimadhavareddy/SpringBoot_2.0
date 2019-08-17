package tk.madhavareddy.digitaldiary.process.service;


import tk.madhavareddy.digitaldiary.persistence.entity.Diary;

import java.util.List;

public interface DigitalDiaryService {
	Diary createDiary(Diary diary);
	List<Diary> getAllDiaries();
}