package de.exxcellent.challenge.reader;

import de.exxcellent.challenge.model.DataFrame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public final class CSVDataFrameReader implements DataFrameReader {
    private static final String VALUE_SEPARATOR = ",";

    @Override
    public DataFrame parseIntoDataFrame(String data) throws DataFrame.DataFrameException {
        DataFrame df;
        try (BufferedReader br = new BufferedReader(new FileReader(data))) {
            String line;

            // Read header row with the column names.
            line = br.readLine();
            df = new DataFrame(line.split(VALUE_SEPARATOR));

            // Read all content rows.
            while ((line = br.readLine()) != null) {
                String[] values = line.split(VALUE_SEPARATOR);
                df.addRow(values);
            }
        }
        catch(IOException e) {
            throw new DataFrame.DataFrameException("Could not read data.", e);
        }
        return df;
    }
}
