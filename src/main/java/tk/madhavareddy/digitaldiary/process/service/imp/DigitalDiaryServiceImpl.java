package tk.madhavareddy.digitaldiary.process.service.imp;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.madhavareddy.digitaldiary.persistence.dao.Dao;
import tk.madhavareddy.digitaldiary.persistence.entity.Diary;
import tk.madhavareddy.digitaldiary.process.service.DigitalDiaryService;
@Service
@Slf4j
public class DigitalDiaryServiceImpl implements DigitalDiaryService {
	private final Dao<Diary> dao;
	@Autowired
	public DigitalDiaryServiceImpl(Dao<Diary> dao){
		this.dao =dao;
	}
	@Override
	public Diary createDiary(Diary diary) {
		return dao.create(diary);
	}
	@Override
	public List<Diary> getAllDiaries() {
		return dao.getAll();
	}
}
