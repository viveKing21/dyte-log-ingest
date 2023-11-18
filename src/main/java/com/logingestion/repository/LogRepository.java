package com.logingestion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.logingestion.model.Log;

public interface LogRepository extends JpaRepository<Log, Long>{
	List<Log> findByLevel(Log.Level level);
	List<Log> findByMessageContaining(String text);
	List<Log> findByLevelAndMessageContaining(Log.Level level, String text);
}
