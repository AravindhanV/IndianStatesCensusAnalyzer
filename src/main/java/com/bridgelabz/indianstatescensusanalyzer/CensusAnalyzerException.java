package com.bridgelabz.indianstatescensusanalyzer;

public class CensusAnalyzerException extends RuntimeException {
	enum ExceptionType{
		CENSUS_FILE_PROBLEM,
		UNABLE_TO_PARSE,
		CENSUS_INCORRECT_FILE_FORMAT
	}

	ExceptionType type;

	 public CensusAnalyzerException(String message, ExceptionType type) {
		 super(message);
	     this.type = type;
	   }
}
