package entity.dto;

import constants.WebConstants;

public class FilterBean {

    private Integer instrumentCount;
    private String categoryFilter;
    private String manufacturerFilter;
    private String sort;
    private String sortDirection;
    private Integer offset;

    public Integer getInstrumentCount() {
        return instrumentCount;
    }

    public void setInstrumentCount(Integer count) {
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

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }
}
