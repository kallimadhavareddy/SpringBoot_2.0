package tk.madhavareddy.digitaldiary.presentation.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.madhavareddy.digitaldiary.persistence.entity.Event;
import tk.madhavareddy.digitaldiary.presentation.data.Diary;
import tk.madhavareddy.digitaldiary.presentation.util.ObjectMapperUtils;
import tk.madhavareddy.digitaldiary.process.service.DigitalDiaryService;
import javax.validation.Valid;
import java.util.List;
import java.util.Set;

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
		tk.madhavareddy.digitaldiary.persistence.entity.Diary diaryEntity = objectMapperUtils.map(diary, tk.madhavareddy.digitaldiary.persistence.entity.Diary.class);
		diaryEntity.getLocation().setDiary(diaryEntity);
		Set<Event> events = diaryEntity.getEvents();
		events.stream().forEach(event->event.setDiary(diaryEntity));
		diaryEntity.setEvents(events);
		return objectMapperUtils.map(digitalDiaryService.createDiary(diaryEntity),Diary.class);
	}

	@GetMapping("/diaries/{status}/status")
	public List<Diary> getAllDiariesByStatusNative(@PathVariable Integer status) {
		return objectMapperUtils.mapAll(digitalDiaryService.getAllDiariesByStatusNative(status),Diary.class);
	}
}
