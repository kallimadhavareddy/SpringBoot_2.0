package tk.madhavareddy.digitaldiary.persistence.dao;



import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import tk.madhavareddy.digitaldiary.persistence.entity.Diary;
import tk.madhavareddy.digitaldiary.persistence.search.DiarySpecification;

import java.util.List;

public interface DiaryDao {
    Diary createDiary(Diary diary);
    List<Diary> getAllDiaries();
    List<Diary> getAllDiariesByStatusNative(Integer status);
    List<Diary> getAllDiaries(Pageable pageable);
    List<Diary> getAll(Specification<Diary> searchByStatusSpecification, Pageable pageable);

}
