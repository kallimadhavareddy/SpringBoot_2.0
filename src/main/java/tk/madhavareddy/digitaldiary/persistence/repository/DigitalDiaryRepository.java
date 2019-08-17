package tk.madhavareddy.digitaldiary.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tk.madhavareddy.digitaldiary.persistence.entity.Diary;

import java.util.Optional;

@Repository
public interface DigitalDiaryRepository extends JpaRepository<Diary, Integer> {
    Optional<Diary> findDiaryById(int id);
}
