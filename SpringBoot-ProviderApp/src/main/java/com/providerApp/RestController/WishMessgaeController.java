package com.providerApp.RestController;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.providerApp.model.Customer;

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
	
	@GetMapping("/welcome/{id}/{name}")
	public ResponseEntity<String>welcomeMessage(@PathVariable int id,@PathVariable String name){
		return new ResponseEntity<String>("welcome "+id+" "+name,HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/saveCustomer")
	public ResponseEntity<String>register(@RequestBody Customer c){
		return new ResponseEntity<String>(c.toString(),HttpStatus.OK);
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Customer>findRecord(@PathVariable int id){
		Customer c=new Customer(id,"Thala","Ranchi");
		return new ResponseEntity<Customer>(c,HttpStatus.FOUND);
	}
}
