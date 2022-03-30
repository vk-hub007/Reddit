package com.reddict.reddictClone.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comeback")
public class SampleController {

	@GetMapping("vimal/")
	public ResponseEntity<String> results(){
		return ResponseEntity.ok("I am back unfinished");
	}
}
