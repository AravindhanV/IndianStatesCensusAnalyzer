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

	public int loadIndiaCensusData(String csvFilePath) throws CensusAnalyzerException {

		int numberOfEntries = 0;
		try {
			if(!csvFilePath.contains(".csv")) {
				throw new CensusAnalyzerException("Enter csv file" , ExceptionType.CENSUS_INCORRECT_FILE_FORMAT);
			}
			Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
			CsvToBeanBuilder<CSVStateCensus> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
			csvToBeanBuilder.withType(CSVStateCensus.class);
			csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
			CsvToBean<CSVStateCensus> csvToBean = csvToBeanBuilder.build();
			Iterator<CSVStateCensus> censusCSVIterator = csvToBean.iterator();

			while (censusCSVIterator.hasNext()) {
				numberOfEntries++;
				censusCSVIterator.next();
			}

		} catch (IOException e) {
			throw new CensusAnalyzerException(e.getMessage(), ExceptionType.CENSUS_FILE_PROBLEM);
		} catch (RuntimeException e) {
			throw new CensusAnalyzerException(e.getMessage(), ExceptionType.CSV_FILE_INTERNAL_ISSUES);
		}
		return numberOfEntries;
	}

	public int loadIndiaStateCode(String csvFilePath) throws CensusAnalyzerException {

		int numberOfEntries = 0;
		try {
			if (!csvFilePath.contains(".csv")) {
				throw new CensusAnalyzerException("Enter csv file", ExceptionType.CENSUS_INCORRECT_FILE_FORMAT);
			}
			Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
			CsvToBeanBuilder<CSVStates> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
			csvToBeanBuilder.withType(CSVStates.class);
			csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
			CsvToBean<CSVStates> csvToBean = csvToBeanBuilder.build();
			Iterator<CSVStates> censusCSVIterator = csvToBean.iterator();

			while (censusCSVIterator.hasNext()) {
				numberOfEntries++;
				censusCSVIterator.next();
			}

		} catch (IOException e) {
			throw new CensusAnalyzerException(e.getMessage(), ExceptionType.CENSUS_FILE_PROBLEM);
		} catch (RuntimeException e) {
			throw new CensusAnalyzerException(e.getMessage(), ExceptionType.CSV_FILE_INTERNAL_ISSUES);
		}
		return numberOfEntries;
	}
}
