package tk.madhavareddy.digitaldiary.persistence.dao;



import tk.madhavareddy.digitaldiary.persistence.entity.Diary;

import java.util.List;

public interface DiaryDao {
    Diary createDiary(Diary diary);
    List<Diary> getAllDiaries();
    List<Diary> getAllDiariesByStatusNative(Integer status);
}
