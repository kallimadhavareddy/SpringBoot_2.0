package tk.madhavareddy.digitaldiary.persistence.dao;



import tk.madhavareddy.digitaldiary.persistence.entity.Diary;

import java.util.List;

public interface Dao<T> {
    Diary create(T diary);
    List<T> getAll();
}
