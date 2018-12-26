package tk.madhavareddy.digitaldiary.process.service.imp;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import tk.madhavareddy.digitaldiary.persistence.dao.DiaryDao;
import tk.madhavareddy.digitaldiary.persistence.entity.Diary;
import tk.madhavareddy.digitaldiary.persistence.search.DiarySpecification;
import tk.madhavareddy.digitaldiary.persistence.search.Search;
import tk.madhavareddy.digitaldiary.process.service.DigitalDiaryService;
@Service
@Slf4j
public class DigitalDiaryServiceImpl implements DigitalDiaryService {
	private final DiaryDao diaryDao;
	private final DiarySpecification diarySpecification;

	@Autowired
	public DigitalDiaryServiceImpl(DiaryDao diaryDao, DiarySpecification diarySpecification) {
		this.diaryDao = diaryDao;
		this.diarySpecification = diarySpecification;
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
	public List<Diary> getAllDiariesByStatusNative(Integer status) {
		return diaryDao.getAllDiariesByStatusNative(status);
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
	public List<Diary> findAllPaginated(Pageable pageable) {
		return diaryDao.getAllDiaries(pageable);
	}

	@Override
	public List<Diary> findAll(String eventContent, Pageable pageable) {
		Search search = new Search();
		search.setSearchTerm(eventContent);
		Specification<Diary> searchByStatusSpecification = diarySpecification.getFilter(search);
		return diaryDao.getAll(searchByStatusSpecification, pageable);
	}
}
