package de.exxcellent.challenge.reader;

import de.exxcellent.challenge.model.DataFrame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CSVDataFrameReaderTest {
    private CSVDataFrameReader csvReader;

    @BeforeEach
    public void setup() {
        this.csvReader = new CSVDataFrameReader();
    }

    @Test
    public void testReadingCSV() throws DataFrame.DataFrameException {
        DataFrame df = csvReader.parseIntoDataFrame("src/test/resources/test.csv");

        assertEquals(2, df.getRows().size());
    }

    @Test
    public void testReadingCSVContent() throws DataFrame.DataFrameException {
        DataFrame df = csvReader.parseIntoDataFrame("src/test/resources/test.csv");
        List<DataFrame.Row> rows = df.getRows();

        // Validate sample value of last row.
        assertEquals("5", rows.get(1).getColumnValue("COLUMN B"));
    }

    @Test
    public void testReadingNonExistingFile() {
        assertThrows(
                DataFrame.DataFrameException.class,
                () -> csvReader.parseIntoDataFrame("src/test/resources/no_file.csv")
        );
    }
}
