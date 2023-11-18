package com.logingestion.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.logingestion.model.Log;

@Service
public interface LogService {
	Log ingestLog(Log log);
	List<Log> getLog(Log.Level level, String text);
}
