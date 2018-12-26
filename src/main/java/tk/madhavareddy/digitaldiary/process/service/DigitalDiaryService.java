package tk.madhavareddy.digitaldiary.process.service;


import org.springframework.data.domain.Pageable;
import tk.madhavareddy.digitaldiary.persistence.entity.Diary;
import tk.madhavareddy.digitaldiary.persistence.search.DiarySpecification;

import java.util.List;

public interface DigitalDiaryService {
	Diary createDiary(Diary diary);
	Diary updateDiary();
	Diary deleteDiary();
	List<Diary> getAllDiaries();
	List<Diary> getAllDiariesByStatusNative(Integer status);
	List<Diary> findAllPaginated(Pageable pageable);
	List<Diary> findAll(String eventContent, Pageable pageable);
}
