package de.exxcellent.challenge;

import de.exxcellent.challenge.analyzer.FootballDataAnalyzer;
import de.exxcellent.challenge.analyzer.WeatherDataAnalyzer;
import de.exxcellent.challenge.model.DataFrame;
import de.exxcellent.challenge.reader.CSVDataFrameReader;

import java.io.IOException;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {

        try {
            DataFrame weatherDF = new CSVDataFrameReader().parseIntoDataFrame("src/main/resources/de/exxcellent/challenge/weather.csv");
            new WeatherDataAnalyzer().analyze(weatherDF);

            DataFrame footballDF = new CSVDataFrameReader().parseIntoDataFrame("src/main/resources/de/exxcellent/challenge/football.csv");
            new FootballDataAnalyzer().analyze(footballDF);
        }
        catch(IOException|DataFrame.DataFrameException e) {
            System.out.println("Could not read and analyze the given file.");
        }
    }
}
