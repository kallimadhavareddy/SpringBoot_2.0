package tk.madhavareddy.digitaldiary.persistence.dao;




import java.util.List;

public interface Dao<T> {
    T create(T diary);
    List<T> getAll();
}
