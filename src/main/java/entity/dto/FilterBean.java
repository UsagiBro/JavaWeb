package entity.dto;

public class FilterBean {

    private String instrumentCount;
    private String categoryFilter;
    private String manufacturerFilter;
    private String sort;
    private String sortDirection;
    private String offset;

    public String getInstrumentCount() {
        return instrumentCount;
    }

    public void setInstrumentCount(String count) {
        this.instrumentCount = count;
    }

    public String getCategoryFilter() {
        return categoryFilter;
    }

    public void setCategoryFilter(String categoryFilter) {
        this.categoryFilter = categoryFilter;
    }

    public String getManufacturerFilter() {
        return manufacturerFilter;
    }

    public void setManufacturerFilter(String manufacturerFilter) {
        this.manufacturerFilter = manufacturerFilter;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getSortDirection() {
        return sortDirection;
    }

    public void setSortDirection(String sortDirection) {
        this.sortDirection = sortDirection;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }
}
