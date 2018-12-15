package tk.madhavareddy.digitaldiary.process.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import tk.madhavareddy.digitaldiary.presentation.data.Diary;
import tk.madhavareddy.digitaldiary.process.service.DigitalDiaryService;

@RestController
public class DigitalDiaryController {
	
	private DigitalDiaryService digitalDiaryService;
	
	@Autowired
	public void DigitalDiaryService(DigitalDiaryService digitalDiaryService){
	this.digitalDiaryService = digitalDiaryService;	
	}	

	@GetMapping("/diaries/{diaryId}/diary")	
	public Diary getContent(@PathVariable String diaryId) {

		return digitalDiaryService.getDiary(diaryId);
	}	
}
