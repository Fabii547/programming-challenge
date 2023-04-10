package de.exxcellent.challenge.reader;

import de.exxcellent.challenge.model.DataFrame;


public interface DataFrameReader {
    DataFrame parseIntoDataFrame(String data) throws Throwable;
}
