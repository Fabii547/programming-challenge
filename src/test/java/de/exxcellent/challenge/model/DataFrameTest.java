package de.exxcellent.challenge.model;

import de.exxcellent.challenge.model.DataFrame;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DataFrameTest {

    @Test
    public void testSize() throws DataFrame.ColumnHeadersFormatException {
        DataFrame df = new DataFrame(new String[]{"First", "Second", "Third"});
        assertEquals(0, df.getRows().size());
    }

    @Test
    public void testEmptyHeader() {
        assertThrows(
                DataFrame.ColumnHeadersFormatException.class,
                () -> new DataFrame(new String[]{"First", "", "Third"})
        );
    }

    @Test
    public void testMismatchingColumns() {
        assertThrows(DataFrame.ColumnMismatchException.class, () -> {
            DataFrame df = new DataFrame(new String[]{"First", "Second", "Third"});
            df.addRow(new String[]{"1", "2", "3", "4"});
        });
    }

    @Test
    public void testGettingRowValue() throws DataFrame.DataFrameException {
        DataFrame df = new DataFrame(new String[]{"First", "Second", "Third"});
        df.addRow(new String[]{"1", "2", "3"});

        List<DataFrame.Row> rows = df.getRows();
        assertEquals("2", rows.get(0).getColumnValue("second"));
    }
}
