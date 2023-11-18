package com.logingestion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.logingestion.model.Log;
import com.logingestion.service.LogService;

@RestController
@CrossOrigin(origins = "*")
public class LogController {
	@Autowired
	LogService logService;
	
	@PostMapping("/logs")
	ResponseEntity<Log> ingestLog(@RequestBody Log log){
		return ResponseEntity.ok(logService.ingestLog(log));
	}
	@GetMapping("/logs")
	ResponseEntity<List<Log>> getLogs(
			@RequestParam(required = false) String search,
			@RequestParam(required = false) Log.Level level){
		return ResponseEntity.ok(logService.getLog(level, search));
	}
}
