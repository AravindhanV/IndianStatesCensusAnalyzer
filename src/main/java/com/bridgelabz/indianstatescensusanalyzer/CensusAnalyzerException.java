package com.bridgelabz.indianstatescensusanalyzer;

public class CensusAnalyzerException extends RuntimeException {
	enum ExceptionType {
		CENSUS_FILE_PROBLEM, UNABLE_TO_PARSE, NO_CENSUS_DATA, CSV_FILE_INTERNAL_ISSUES
	}

	ExceptionType type;

	public CensusAnalyzerException(String message, ExceptionType type) {
		super(message);
		this.type = type;
	}
}
