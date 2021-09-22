/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.bridgelabz.indianstatescensusanalyzer;

import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.bridgelabz.indianstatescensusanalyzer.StateCensusAnalyzer;

import static org.junit.Assert.*;

public class IndianStatesCensusAnalyzerTest {
	private static final String INDIA_CENSUS_CSV_FILE_PATH = "./src/test/resources/IndianStateCensus.csv";
	private static final String CSV_WRONG_FILE_PATH="./IndianStateCensus.csv";
	private static final String INCORRECT_FILE_FORMAT = "./src/test/resources/CensusDataWrongType.txt";
	private static final String CSV_CENSUS_WRONG_DELIMITER = "./src/test/resources/IndianCensusWrongDelimiter.csv";
	private static final String CSV_CENSUS_WRONG_HEADER = "./src/test/resources/CsvFileWrongHeader.csv";
	private static final String STATE_CSV_FILE_PATH = "./src/test/resources/IndianStateCodes.csv";
	private static final String STATE_CSV_FILE_WRONG_PATH = "./IndianStateCodes.csv";
	
	@Test
	public void loadIndiaCensusData_ValidCSVInput_NumberOfRows() {
		StateCensusAnalyzer analyzer = new StateCensusAnalyzer();
		int noOfLines = analyzer.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
		assertEquals(2, noOfLines);
	}
	
	@Test 
	public void loadIndiaCensusData_givenWrongPath_ShouldThrowException() {
		try {
            StateCensusAnalyzer censusAnalyser = new StateCensusAnalyzer();
            int numOfRecords = censusAnalyser.loadIndiaCensusData(CSV_WRONG_FILE_PATH);

        } catch (CensusAnalyzerException e) {
        	assertEquals(CensusAnalyzerException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }
    }
	
	 @Test 
	    public void givenIndiaCensusData_WithWrongFileType_ShouldThrowException() {
	        try {
	        	StateCensusAnalyzer censusAnalyser = new StateCensusAnalyzer();
	            int numOfRecords = censusAnalyser.loadIndiaCensusData(INCORRECT_FILE_FORMAT);
	        } catch (CensusAnalyzerException e) {
	            assertEquals(CensusAnalyzerException.ExceptionType.CENSUS_INCORRECT_FILE_FORMAT, e.type);
	        }
	    }
}
