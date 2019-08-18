package tk.madhavareddy.digitaldiary.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tk.madhavareddy.digitaldiary.persistence.entity.CompositeIdentity;
import tk.madhavareddy.digitaldiary.persistence.entity.Diary;

@Repository
public interface DigitalDiaryRepository extends JpaRepository<Diary, CompositeIdentity> {
}
