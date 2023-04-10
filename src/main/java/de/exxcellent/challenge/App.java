package de.exxcellent.challenge;

import de.exxcellent.challenge.analyzer.FootballDataAnalyzer;
import de.exxcellent.challenge.analyzer.WeatherDataAnalyzer;
import de.exxcellent.challenge.model.DataFrame;
import de.exxcellent.challenge.reader.CSVDataFrameReader;


/**
 * The entry class of the program.
 */
public final class App {

    public static void main(String... args) {
        try {
            DataFrame weatherDF = new CSVDataFrameReader().parseIntoDataFrame("src/main/resources/de/exxcellent/challenge/weather.csv");
            new WeatherDataAnalyzer().analyze(weatherDF);

            DataFrame footballDF = new CSVDataFrameReader().parseIntoDataFrame("src/main/resources/de/exxcellent/challenge/football.csv");
            new FootballDataAnalyzer().analyze(footballDF);
        }
        catch(DataFrame.DataFrameException e) {
            System.out.println("Could not read and analyze the given file.");
            e.printStackTrace();
        }
    }
}
