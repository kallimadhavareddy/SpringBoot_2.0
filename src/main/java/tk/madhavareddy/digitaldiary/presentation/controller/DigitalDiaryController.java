package tk.madhavareddy.digitaldiary.presentation.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.madhavareddy.digitaldiary.presentation.data.Diary;
import tk.madhavareddy.digitaldiary.process.service.DigitalDiaryService;
import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
public class DigitalDiaryController {

	private final DigitalDiaryService digitalDiaryService;

	@Autowired
	public DigitalDiaryController(DigitalDiaryService digitalDiaryService) {
		this.digitalDiaryService = digitalDiaryService;
	}
	@PostMapping("/diaries/diary")
	public Diary createDairy(@RequestBody @Valid Diary diary) {
		return digitalDiaryService.createDiary(diary);
	}
	@GetMapping("/diaries")
	public List<Diary> getAllDiaries() {
		return digitalDiaryService.getAllDiaries();
	}

}
