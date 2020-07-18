package tk.madhavareddy.digitaldiary.presentation.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import tk.madhavareddy.digitaldiary.presentation.data.Diary;
import tk.madhavareddy.digitaldiary.presentation.util.ObjectMapperUtils;
import tk.madhavareddy.digitaldiary.process.service.DigitalDiaryService;
import javax.validation.Valid;
import java.io.File;
import java.util.List;

@RestController
@Slf4j
public class DigitalDiaryController {

	private final DigitalDiaryService digitalDiaryService;

	@Autowired
	public DigitalDiaryController(DigitalDiaryService digitalDiaryService,ObjectMapperUtils objectMapperUtils) {
		this.digitalDiaryService = digitalDiaryService;
	}

	@GetMapping("/hello")
	public String helloEndPoint(){
		digitalDiaryService.getLogger();
		return "Hai how are you";
	}










	@Value("${test.path}")
	String filePath;
	@Value("${test.path2}")
	String filePath2;

	@GetMapping("/diaries")
	public List<Diary> getAllDiaries() {
		return digitalDiaryService.getAllDiaries();
	}
	@PostMapping("/diaries/diary")
	public Diary createDairy(@RequestBody @Valid Diary diary) {
		return digitalDiaryService.createDiary(diary);
	}
	@GetMapping("/diaries/{status}/status")
	public List<Diary> getAllDiariesByStatusNative(@PathVariable Integer status) {
		return digitalDiaryService.getAllDiariesByStatusNative(status);
	}
	@GetMapping("pagination/diaries/{currentPage}/")
	public List<Diary> getAllDiariesPagination(@PathVariable Integer currentPage) {
		return digitalDiaryService.findAllPaginated(currentPage);
	}
	@GetMapping("search/diaries/{eventContent}/{currentPage}")
	public List<Diary> getDiariesByEventContent(@PathVariable String eventContent,@PathVariable Integer currentPage) {
		return digitalDiaryService.findAll(eventContent,currentPage);
	}

	@GetMapping("diaries/{diaryId}/diary")
	public Diary getDiary(@PathVariable Integer diaryId){
		return digitalDiaryService.getDiary(diaryId);
	}

	@GetMapping("/test/file")
	public String fileTest(){

		File file = new File(filePath+"/First.txt");
		if(file.exists()) {
			return "Yes file exists in the path "+file.getAbsolutePath();
		}

		return "not exists";
	}

	@GetMapping("/test/file2")
	public String fileTest2(){

		File file = new File(filePath2+ "/Second.txt");
		if(file.exists()) {
			return "Yes file exists in the path "+file.getAbsolutePath();
		}



		return file.getAbsolutePath();
	}

}
