package tk.madhavareddy.digitaldiary.persistence.dao;



import org.springframework.data.domain.Pageable;
import tk.madhavareddy.digitaldiary.persistence.entity.Diary;

import java.util.List;

public interface DiaryDao {
    Diary createDiary(Diary diary);
    List<Diary> getAllDiaries();
    List<Diary> getAllDiariesByStatusNative(Integer status);
    List<Diary> getAllDiaries(Pageable pageable);

}
