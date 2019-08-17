package tk.madhavareddy.digitaldiary.persistence.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.madhavareddy.digitaldiary.persistence.dao.DiaryDao;
import tk.madhavareddy.digitaldiary.persistence.entity.Diary;
import tk.madhavareddy.digitaldiary.persistence.repository.DigitalDiaryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DiaryDaoImpl implements DiaryDao {
    private final DigitalDiaryRepository digitalDiaryRepository;
    @Autowired
    public DiaryDaoImpl(DigitalDiaryRepository digitalDiaryRepository){
        this.digitalDiaryRepository= digitalDiaryRepository;
    }
    @Override
    public Diary createDiary(Diary diary) {
        return digitalDiaryRepository.save(diary);
    }
    @Override
    public List<Diary> getAllDiaries() {
        return digitalDiaryRepository.findAll();
    }
    @Override
    public Optional<Diary> getDiaryById(int id) {
        return digitalDiaryRepository.findDiaryById(id);
    }
    @Override
    public Diary updateDiary(Diary diary) {
        return digitalDiaryRepository.save(diary);
    }
    @Override
    public void deleteDiaryById(int id) {
        digitalDiaryRepository.deleteById(id);
    }
}
