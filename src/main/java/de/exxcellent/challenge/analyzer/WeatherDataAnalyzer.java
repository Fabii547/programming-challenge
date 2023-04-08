package de.exxcellent.challenge.analyzer;

import de.exxcellent.challenge.model.DataFrame;

public class WeatherDataAnalyzer {
    public void analyze(DataFrame df) {
        DataFrame.Row rowOfInterest = null;
        int minTemperatureSpread = Integer.MAX_VALUE;
        for (DataFrame.Row row : df.getRows()) {
            int spread = Integer.parseInt(row.getColumnValue("MxT")) - Integer.parseInt(row.getColumnValue("MnT"));
            if (minTemperatureSpread > spread) {
                minTemperatureSpread = spread;
                rowOfInterest = row;
            }
        }

        if (rowOfInterest != null) {
            System.out.printf("Day with smallest temperature spread : %s%n", rowOfInterest.getColumnValue("Day"));
        }
        else {
            System.out.println("Could not determine the day with the smallest temperature spread.");
        }
    }
}
