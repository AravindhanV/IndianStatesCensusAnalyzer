package com.bridgelabz.indianstatescensusanalyzer;

public class CensusAnalyzerException extends RuntimeException {
	enum ExceptionType {
		CENSUS_FILE_PROBLEM,
		CENSUS_INCORRECT_FILE_FORMAT,
		WRONG_FILE_PATH,
		CSV_FILE_INTERNAL_ISSUES
	}

	ExceptionType type;

	public CensusAnalyzerException(String message, ExceptionType type) {
		super(message);
		this.type = type;
	}
}
