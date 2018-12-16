package tk.madhavareddy.digitaldiary.process.service.imp;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.madhavareddy.digitaldiary.persistence.dao.DiaryDao;
import tk.madhavareddy.digitaldiary.persistence.entity.Diary;
import tk.madhavareddy.digitaldiary.process.service.DigitalDiaryService;
@Service
@Slf4j
public class DigitalDiaryServiceImpl implements DigitalDiaryService {
	private final DiaryDao diaryDao;
	@Autowired
	public DigitalDiaryServiceImpl(DiaryDao diaryDao){
		this.diaryDao=diaryDao;
	}
	@Override
	public Diary createDiary(Diary diary) {
		return diaryDao.createDiary(diary);
	}
	@Override
	public List<Diary> getAllDiaries() {
		return diaryDao.getAllDiaries();
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

}
