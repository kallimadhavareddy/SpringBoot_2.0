package tk.madhavareddy.digitaldiary.process.service.imp;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.madhavareddy.digitaldiary.persistence.dao.DiaryDao;
import tk.madhavareddy.digitaldiary.presentation.data.Diary;
import tk.madhavareddy.digitaldiary.presentation.exception.NoRecordsFoundException;
import tk.madhavareddy.digitaldiary.presentation.util.ObjectMapperUtils;
import tk.madhavareddy.digitaldiary.process.service.DigitalDiaryService;
@Service
@Slf4j
public class DigitalDiaryServiceImpl implements DigitalDiaryService {
	private final DiaryDao diaryDao;
	private final ObjectMapperUtils objectMapperUtils;
	@Autowired
	public DigitalDiaryServiceImpl(DiaryDao diaryDao,ObjectMapperUtils objectMapperUtils){
		this.diaryDao=diaryDao;
		this.objectMapperUtils=objectMapperUtils;
	}
	@Override
	public Diary createDiary(Diary diary) {
		tk.madhavareddy.digitaldiary.persistence.entity.Diary diaryEntity = objectMapperUtils.map(diary, tk.madhavareddy.digitaldiary.persistence.entity.Diary.class);
		diaryEntity.getLocation().setDiary(diaryEntity);
		return objectMapperUtils.map(diaryDao.createDiary(diaryEntity),Diary.class);
	}

	@Override
	public Diary findDiary(int id) {
		if(diaryDao.getDiaryById(id).isPresent()) {
			return objectMapperUtils.map(diaryDao.getDiaryById(id).get(),Diary.class);
		}else{
			throw new NoRecordsFoundException("given diary "+id+"not found");
		}
	}

	@Override
	public List<Diary> getAllDiaries() {
		try {
			return objectMapperUtils.mapAll(diaryDao.getAllDiaries(), tk.madhavareddy.digitaldiary.presentation.data.Diary.class);
		}catch(Exception ex) {
			throw new NoRecordsFoundException("Unable to get the Diary details");
		}
	}

	@Override
	public Diary updateDiary(Diary diary) {
		return objectMapperUtils.map(diaryDao.updateDiary(objectMapperUtils.map(diary, tk.madhavareddy.digitaldiary.persistence.entity.Diary.class)),Diary.class);
	}

	@Override
	public void deleteDiaryById(int id) {
		diaryDao.deleteDiaryById(id);
	}
}
