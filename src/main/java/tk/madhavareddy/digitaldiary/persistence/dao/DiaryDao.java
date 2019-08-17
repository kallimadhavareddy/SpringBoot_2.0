package tk.madhavareddy.digitaldiary.persistence.dao;



import tk.madhavareddy.digitaldiary.persistence.entity.Diary;

import java.util.List;
import java.util.Optional;

public interface DiaryDao {
    Diary createDiary(Diary diary);
    List<Diary> getAllDiaries();
    Optional<Diary> getDiaryById(int id);
    Diary updateDiary(Diary diary);
    void deleteDiaryById(int id);

}
