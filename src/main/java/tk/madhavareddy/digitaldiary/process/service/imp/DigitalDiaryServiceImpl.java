package tk.madhavareddy.digitaldiary.process.service.imp;

import java.util.List;
import java.util.Set;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import tk.madhavareddy.digitaldiary.persistence.dao.DiaryDao;
import tk.madhavareddy.digitaldiary.persistence.entity.Event;
import tk.madhavareddy.digitaldiary.persistence.search.DiarySpecification;
import tk.madhavareddy.digitaldiary.persistence.search.Search;
import tk.madhavareddy.digitaldiary.presentation.data.Diary;
import tk.madhavareddy.digitaldiary.presentation.exception.ResourceNotFoundException;
import tk.madhavareddy.digitaldiary.presentation.util.ObjectMapperUtils;
import tk.madhavareddy.digitaldiary.process.service.DigitalDiaryService;

import javax.persistence.EntityNotFoundException;

@Service
@Slf4j
public class DigitalDiaryServiceImpl implements DigitalDiaryService {
	private final DiaryDao diaryDao;
	private final DiarySpecification diarySpecification;
    private final ObjectMapperUtils objectMapperUtils;

	@Autowired
	public DigitalDiaryServiceImpl(DiaryDao diaryDao, DiarySpecification diarySpecification, ObjectMapperUtils objectMapperUtils) {
		this.diaryDao = diaryDao;
		this.diarySpecification = diarySpecification;
        this.objectMapperUtils = objectMapperUtils;
    }

	@Override
	public Diary createDiary(Diary diary) {
        tk.madhavareddy.digitaldiary.persistence.entity.Diary diaryEntity = objectMapperUtils.map(diary, tk.madhavareddy.digitaldiary.persistence.entity.Diary.class);
        diaryEntity.getLocation().setDiary(diaryEntity);
        Set<Event> events = diaryEntity.getEvents();
        events.forEach(event->event.setDiary(diaryEntity));
        diaryEntity.setEvents(events);
        return objectMapperUtils.map(diaryDao.createDiary(diaryEntity), Diary.class);
	}

	@Override
	public List<Diary> getAllDiaries() {
        return objectMapperUtils.mapAll(diaryDao.getAllDiaries(), Diary.class);
	}

	@Override
	public List<Diary> getAllDiariesByStatusNative(Integer status) {
        return objectMapperUtils.mapAll(diaryDao.getAllDiariesByStatusNative(status), Diary.class);

	}

	public List<Diary> findAllPaginated(Integer currentPage) {
        return objectMapperUtils.mapAll(diaryDao.getAllDiaries(PageRequest.of(currentPage - 1, 2)), Diary.class);
	}

	@Override
	public List<Diary> findAll(String eventContent, Integer currentPage) {
		Search search = new Search();
		search.setSearchTerm(eventContent);
		Specification<tk.madhavareddy.digitaldiary.persistence.entity.Diary> searchByStatusSpecification = diarySpecification.getFilter(search);
        return objectMapperUtils.mapAll(diaryDao.getAll(searchByStatusSpecification,PageRequest.of(currentPage - 1, 2)), tk.madhavareddy.digitaldiary.presentation.data.Diary.class);
	}

    @Override
    public Diary getDiary(Integer diaryId) {
		try{
			tk.madhavareddy.digitaldiary.persistence.entity.Diary diary = diaryDao.getDiary(diaryId);
			if(diary.getEvents()==null) {
				throw new ResourceNotFoundException("Given Id " + diaryId + " Not found");
			}else{
				return objectMapperUtils.map(diary, tk.madhavareddy.digitaldiary.presentation.data.Diary.class);
			}
		}catch(EntityNotFoundException ex){
			throw new ResourceNotFoundException("Given Id " + diaryId + " Not found");
		}
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
