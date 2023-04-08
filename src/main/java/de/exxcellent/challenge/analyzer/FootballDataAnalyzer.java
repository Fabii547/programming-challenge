package de.exxcellent.challenge.analyzer;

import de.exxcellent.challenge.model.DataFrame;

public class FootballDataAnalyzer implements DataFrameAnalyzer {
    @Override
    public void analyze(DataFrame df) {
        DataFrame.Row rowOfInterest = null;
        int minScoreDifference = Integer.MAX_VALUE;
        for (DataFrame.Row row : df.getRows()) {
            int scoresDiff = Math.abs(Integer.parseInt(row.getColumnValue("Goals")) - Integer.parseInt(row.getColumnValue("Goals Allowed")));
            if (minScoreDifference > scoresDiff) {
                minScoreDifference = scoresDiff;
                rowOfInterest = row;
            }
        }

        if (rowOfInterest != null) {
            System.out.printf("Team with smallest goal spread : %s%n", rowOfInterest.getColumnValue("Team"));
        }
        else {
            System.out.println("Could not determine the day with the smallest temperature spread.");
        }
    }
}
