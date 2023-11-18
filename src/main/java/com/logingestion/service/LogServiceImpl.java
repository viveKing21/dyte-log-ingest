package com.logingestion.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logingestion.model.Log;
import com.logingestion.model.Log.Level;
import com.logingestion.repository.LogRepository;

@Service
public class LogServiceImpl implements LogService{
	@Autowired
	LogRepository logRepository;
	
	public Log ingestLog(Log log) {
		return logRepository.save(log);
	}

	@Override
	public List<Log> getLog(Level level, String text) {
		if(level != null && text != null) {
			return logRepository.findByLevelAndMessageContaining(level, text);
		}
		if(level != null) {
			return logRepository.findByLevel(level);
		}
		if(text != null) {
			return logRepository.findByMessageContaining(text);
		}
		return logRepository.findAll();
	}
}
