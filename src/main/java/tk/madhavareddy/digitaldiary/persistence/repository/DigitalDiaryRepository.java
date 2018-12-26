package tk.madhavareddy.digitaldiary.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tk.madhavareddy.digitaldiary.persistence.entity.Diary;

import java.util.List;

@Repository
public interface DigitalDiaryRepository extends JpaRepository<Diary, Integer> {
    @Query(value = "SELECT * FROM DIGITAL_DIARY d WHERE d.status = ?1",nativeQuery = true)
    List<Diary> findAllDiaryByStatusNative(Integer status);
}
