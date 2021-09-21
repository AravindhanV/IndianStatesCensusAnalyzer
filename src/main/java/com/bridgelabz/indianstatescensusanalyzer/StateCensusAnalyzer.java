/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.bridgelabz.indianstatescensusanalyzer;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

import com.bridgelabz.indianstatescensusanalyzer.CensusAnalyzerException.ExceptionType;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class StateCensusAnalyzer {
	
	public int loadIndiaCensusData(String csvFilePath) throws CensusAnalyzerException{

		int numberOfEntries = 0;
		try {
			Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
			CsvToBeanBuilder<CSVStateCensus> csvToBeanBuilder=new CsvToBeanBuilder<>(reader);
			csvToBeanBuilder.withType(CSVStateCensus.class);
			csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
			CsvToBean<CSVStateCensus> csvToBean = csvToBeanBuilder.build();
			Iterator<CSVStateCensus> censusCSVIterator=csvToBean.iterator();

    		while(censusCSVIterator.hasNext()) {
    			numberOfEntries++;
    			censusCSVIterator.next();
    		}

		} catch (IOException e) {
			throw new CensusAnalyzerException(e.getMessage(), ExceptionType.CENSUS_FILE_PROBLEM);
		} catch(IllegalStateException e) {
			throw new CensusAnalyzerException(e.getMessage(),ExceptionType.UNABLE_TO_PARSE);
		} catch(NullPointerException e) {
			throw new CensusAnalyzerException(e.getMessage(), ExceptionType.NO_CENSUS_DATA);
		}
		catch(RuntimeException e) {
			throw new CensusAnalyzerException(e.getMessage(),ExceptionType.CSV_FILE_INTERNAL_ISSUES);
		}
		return numberOfEntries;
	}
}
