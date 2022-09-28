package literateProgramming;

public class Page {

    final int rowsPerPage;
    final int columnsPerPage;
    int[] numbers;
    int pageNumber;
    public Page(int rowsPerPage, int columnsPerPage) {
        this.rowsPerPage = rowsPerPage;
        this.columnsPerPage = columnsPerPage;
        pageNumber=0;
    }
    public int getRowsPerPage() {
        return rowsPerPage;
    }

    public int getColumnsPerPage() {
        return columnsPerPage;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }

    boolean hasNext() {
        return getNextPageOffset() <= getNumberOfNumbers();
    }
    public int getNumberOfNumbers() {
        return numbers.length - 1;
    }

    public int getPageOffset() {
        return (pageNumber - 1) * rowsPerPage * columnsPerPage + 1;
    }
    public int getNextPageOffset() {
        return (pageNumber) * rowsPerPage * columnsPerPage + 1;
    }

    void nextPage() {
        pageNumber = getPageNumber() + 1;
    }

    int getIndexFor(int row, int col) {
        return getPageOffset() + row + col * getRowsPerPage();
    }

    boolean hasEntry(int row, int col) {
        return getIndexFor(row, col) <= getNumberOfNumbers();
    }

    int getEntryAt(int row, int col) {
        return numbers[getIndexFor(row, col)];
    }
}