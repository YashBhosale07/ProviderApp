package com.providerApp.RestController;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/providerApp")
public class WishMessgaeController {

	@GetMapping("/message")
	public ResponseEntity<String>wishMessage(){
		String Body;
		LocalDateTime l=LocalDateTime.now();
		int hour=l.getHour();
		if(hour<12) {
			Body="Good Morning";
		}else if(hour>12 && hour<16) {
			Body="Good Afternoon";
		}else if (hour>16 && hour<18) {
			Body="Good evening";
		}else {
			Body="Good Night";
		}
		return new ResponseEntity<String>(Body,HttpStatus.OK);
	}
}
