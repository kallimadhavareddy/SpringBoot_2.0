package tk.madhavareddy.digitaldiary.persistence.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.madhavareddy.digitaldiary.persistence.dao.Dao;
import tk.madhavareddy.digitaldiary.persistence.entity.Diary;
import tk.madhavareddy.digitaldiary.persistence.repository.DigitalDiaryRepository;

import java.util.List;
@Service
public class DiaryDaoImpl implements Dao<Diary> {
    private final DigitalDiaryRepository digitalDiaryRepository;
    @Autowired
    public DiaryDaoImpl(DigitalDiaryRepository digitalDiaryRepository){
        this.digitalDiaryRepository= digitalDiaryRepository;
    }
    @Override
    public Diary create(Diary diary) {
        return digitalDiaryRepository.save(diary);
    }
    @Override
    public List<Diary> getAll() {
        return digitalDiaryRepository.findAll();
    }
}
