package de.exxcellent.challenge.model;

import java.util.*;

/**
 * Implementation of an immutable data store for tabular data.
 */
public class DataFrame {
    private final List<String> columns;
    private final List<Row> rows = new ArrayList<>();

    public DataFrame(String[] columns) throws ColumnHeadersFormatException {
        String[] sanitizedColumns = this.sanitize(columns);
        if (sanitizedColumns.length != columns.length) {
            throw new ColumnHeadersFormatException();
        }

        this.columns = new ArrayList<>(Arrays.asList(sanitizedColumns));
    }

    public void addRow(String[] values) throws ColumnMismatchException {
        if (values.length != this.columns.size()) {
            throw new ColumnMismatchException();
        }
        this.rows.add(new Row(values));
    }

    public List<Row> getRows() {
        return this.rows;
    }

    private String[] sanitize(String[] columns) {
        return Arrays.stream(columns)
                .filter(s -> s.length() != 0)
                .map(String::trim)
                .map(String::toLowerCase)
                .toArray(String[]::new);
    }

    private int getColumnIndexByName(String columnName) {
        return this.columns.indexOf(columnName.toLowerCase());
    }

    public class Row {
        private final String[] values;

        public Row(String[] values) {
            this.values = values;
        }

        public String getColumnValue(String columnName) {
            return this.values[getColumnIndexByName(columnName)];
        }
    }

    public static class DataFrameException extends Exception {
        public DataFrameException(String message) {
            super(message);
        }

        public DataFrameException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static class ColumnHeadersFormatException extends DataFrameException {
        public ColumnHeadersFormatException() {
            super("The passed columns contain either empty strings or duplicate values.");
        }
    }

    public static class ColumnMismatchException extends DataFrameException {
        public ColumnMismatchException() {
            super("The number of column names does not match the number of passed row values.");
        }
    }
}
