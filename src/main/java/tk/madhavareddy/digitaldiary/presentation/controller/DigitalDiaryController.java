package tk.madhavareddy.digitaldiary.presentation.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.madhavareddy.digitaldiary.persistence.entity.Diary;
import tk.madhavareddy.digitaldiary.process.service.DigitalDiaryService;
import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("diaries")
public class DigitalDiaryController {

	private final DigitalDiaryService digitalDiaryService;

	@Autowired
	public DigitalDiaryController(DigitalDiaryService digitalDiaryService) {
		this.digitalDiaryService = digitalDiaryService;
	}
	@GetMapping
	public List<Diary> getAllDiaries() {
		return digitalDiaryService.getAllDiaries();
	}
	@PostMapping("/diary")
	public Diary createDairy(@RequestBody @Valid Diary diary) {
		return digitalDiaryService.createDiary(diary);
	}
}
