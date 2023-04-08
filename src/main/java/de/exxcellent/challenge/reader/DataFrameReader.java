package de.exxcellent.challenge.reader;

import de.exxcellent.challenge.model.DataFrame;

import java.io.IOException;

public interface DataFrameReader {
    DataFrame parseIntoDataFrame(String data) throws IOException, DataFrame.DataFrameException;
}
