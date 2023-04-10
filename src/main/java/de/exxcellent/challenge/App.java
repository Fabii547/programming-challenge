package de.exxcellent.challenge;

import de.exxcellent.challenge.analyzer.FootballDataAnalyzer;
import de.exxcellent.challenge.analyzer.WeatherDataAnalyzer;
import de.exxcellent.challenge.model.DataFrame;
import de.exxcellent.challenge.reader.CSVDataFrameReader;


/**
 * The entry class of the program.
 */
public final class App {

    /**
     * Possible parameters:
     * --weather src/main/resources/de/exxcellent/challenge/weather.csv
     * --football src/main/resources/de/exxcellent/challenge/football.csv
     *
     * @param args CLI arguments
     */
    public static void main(String... args) {
        if (args.length != 2) {
            System.out.println("You have to provide two arguments the challenge name and the filepath.");
            return;
        }

        try {
            switch(args[0]) {
                case "--weather":
                    DataFrame weatherDF = new CSVDataFrameReader()
                            .parseIntoDataFrame(args[1]);
                    new WeatherDataAnalyzer().analyze(weatherDF);
                    break;
                case "--football":
                    DataFrame footballDF = new CSVDataFrameReader()
                            .parseIntoDataFrame(args[1]);
                    new FootballDataAnalyzer().analyze(footballDF);
                    break;
                default:
                    System.out.printf("Unknown challenge '%s' given", args[0]);
            }
        }
        catch(DataFrame.DataFrameException e) {
            System.out.println("Could not read and analyze the given file.");
            e.printStackTrace();
        }
    }
}
