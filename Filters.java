package fileio;

public class Filters {

private InputforSort sort = new InputforSort();

private InputforContains contains = new InputforContains();

/** this method getsSort */
    public InputforSort getSort() {
        return sort;
    }
/** thsi method gets sort */
    public void setSort(final InputforSort sort) {
        this.sort = sort;
    }
/** this method gets contains */
    public InputforContains getContains() {
        return contains;
    }
/** tbhis method sets contains */
    public void setContains(final InputforContains contains) {
        this.contains = contains;
    }
}
