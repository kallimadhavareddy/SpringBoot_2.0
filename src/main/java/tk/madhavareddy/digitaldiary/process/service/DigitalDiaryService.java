package tk.madhavareddy.digitaldiary.process.service;
import tk.madhavareddy.digitaldiary.presentation.data.Diary;

import java.util.List;

public interface DigitalDiaryService {
    Diary createDiary(tk.madhavareddy.digitaldiary.presentation.data.Diary diary);
    Diary updateDiary();
    Diary deleteDiary();
	List<Diary> getAllDiaries();
	List<Diary> getAllDiariesByStatusNative(Integer status);
	List<Diary> findAllPaginated(Integer currentPage);
	List<Diary> findAll(String eventContent, Integer currentPage);
	Diary getDiary(Integer diaryId);
}
