package tk.madhavareddy.digitaldiary.presentation.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tk.madhavareddy.digitaldiary.presentation.data.Diary;
import tk.madhavareddy.digitaldiary.presentation.util.ObjectMapperUtils;
import tk.madhavareddy.digitaldiary.process.service.DigitalDiaryService;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@Slf4j
public class DigitalDiaryController {

	private final DigitalDiaryService digitalDiaryService;
	private final ObjectMapperUtils objectMapperUtils;

	@Autowired
	public DigitalDiaryController(DigitalDiaryService digitalDiaryService,ObjectMapperUtils objectMapperUtils) {
		this.digitalDiaryService = digitalDiaryService;
		this.objectMapperUtils = objectMapperUtils;
	}
	@GetMapping("/diaries")
	public List<Diary> getAllDiaries() {
		return objectMapperUtils.mapAll(digitalDiaryService.getAllDiaries(),Diary.class);
	}
	@PostMapping("/diaries/diary")
	public Diary createDairy(@RequestBody @Valid Diary diary) {
		log.info(""+diary);
		return objectMapperUtils.map(digitalDiaryService.createDiary(objectMapperUtils.map(diary, tk.madhavareddy.digitaldiary.persistence.entity.Diary.class)), Diary.class);
	}
	@GetMapping("/diaries/dummy/diary")
	public Diary dummy(){
		Diary diary = new Diary();
		diary.setContent("this is my first diary content");
		diary.setContentDate(LocalDate.now());
		diary.setLocation("Brussels");
		return diary;
	}
}
