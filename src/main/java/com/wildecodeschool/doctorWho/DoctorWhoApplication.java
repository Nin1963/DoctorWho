package com.wildecodeschool.doctorWho;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class DoctorWhoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoctorWhoApplication.class, args);
	}
	
	@RequestMapping("/doctor/{numberIncarnation}")
    @ResponseBody
    public ResponseEntity<?> doc(@PathVariable String numberIncarnation) {
		int number = Integer.parseInt(numberIncarnation);
		if(number < 9) return new ResponseEntity<>("303 See Other",HttpStatus.SEE_OTHER);
		String response = "";
		switch(number) {
		case 9:
			response = "{\"number\": 9, \"name\": \"Christopher Eccleston\"}";
			break;
		case 10: 
			response = "{\"number\": 10, \"name\": \"David Tennant\"}";
			break;
		case 11:
			response = "{\"number\": 11, \"name\": \"Matt Smith\"}";
			break;
		case 12:
			response = "{\"number\": 12, \"name\": \"Peter Capaldi\"}";
			break;
		case 13:
			response = "{\"number\": 13, \"name\": \"Jodie Whittaker\"}";
			break;
		default:
			return new ResponseEntity<>("Impossible de récupérer l'incarnation "+number, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
