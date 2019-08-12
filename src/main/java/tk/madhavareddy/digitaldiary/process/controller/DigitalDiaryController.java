package tk.madhavareddy.digitaldiary.process.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DigitalDiaryController {
	@GetMapping("/diaries/{diaryId}/diary")	
	public String getDiary() {
		return "Spring boot Sample!, Say everyone Hello to digital Diary project";
	}	
}
