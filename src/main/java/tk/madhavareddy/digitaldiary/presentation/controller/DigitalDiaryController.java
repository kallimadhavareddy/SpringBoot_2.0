package tk.madhavareddy.digitaldiary.presentation.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;
import tk.madhavareddy.digitaldiary.presentation.data.Diary;
import tk.madhavareddy.digitaldiary.presentation.data.Location;
import tk.madhavareddy.digitaldiary.presentation.exception.NoRecordsFoundException;
import tk.madhavareddy.digitaldiary.process.service.DigitalDiaryService;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.websocket.server.PathParam;
import java.time.LocalDate;
import java.util.List;

@RestController
@Slf4j
@Validated
public class DigitalDiaryController {

	private final DigitalDiaryService digitalDiaryService;

	@Autowired
	public DigitalDiaryController(DigitalDiaryService digitalDiaryService) {
		this.digitalDiaryService = digitalDiaryService;
	}
	@PostMapping("/diaries/diary")
	public ResponseEntity<Void> createDairy(@RequestBody @Valid Diary diary, UriComponentsBuilder builder) {
		Diary createdDiary = digitalDiaryService.createDiary(diary);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(builder.path("/diaries/{id}").buildAndExpand(createdDiary.getId()).toUri());
		return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
	}
	@GetMapping("/diaries/{id}")
	public Diary getDairy(@PathVariable("id") @Min(1) int id) {
		try {
			return digitalDiaryService.findDiary(id);
		}catch(NoRecordsFoundException ex){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,ex.getMessage());
		}
	}
	@GetMapping("/diaries")
	public List<Diary> getAllDiaries() {
		List<Diary> allDiaries = digitalDiaryService.getAllDiaries();
		if(allDiaries.size()==0){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"No Customer data");
		}
		return allDiaries;
	}

	@GetMapping("/test")
	public Diary getTest() {
		Diary diary = new Diary();
		Location location = new Location();
		location.setLatitude("90");
		location.setLongitude("90");
		location.setUserLocation("Testing");
		location.setCountry("YTD");

		diary.setContent("First Content");
		diary.setContentDate(LocalDate.now());
		diary.setLocation(location);

		return diary;
	}

}
