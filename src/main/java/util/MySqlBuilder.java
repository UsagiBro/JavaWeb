package util;

import constants.WebConstants;
import entity.dto.FilterBean;

public class MySqlBuilder {

    private static final String SELECT_FROM_INSTRUMENTS =
            "SELECT i.ins_name, i.price, c.label, m.title FROM instruments i " +
                    "JOIN categories c ON i.category_id=c.id JOIN manufacturers m ON i.manufacturer_id=m.id ";
    private static final String SQL_LIMIT = " LIMIT ";
    private static final String SQL_OFFSET = " OFFSET ";
    private static final String SQL_WHERE = " WHERE ";
    private static final String SQL_AND = " AND ";
    private static final String SQL_ORDER_BY = " ORDER BY ";
    private static final String SQL_ASC = " ASC ";
    private static final String SQL_DESC = " DESC ";
    private static final String MANUFACTURER_ID = " manufacturer_id= ";
    private static final String CATEGORY_ID = " category_id= ";
    private static final String SQL_QUOTATION_MARK = "'";
    private static final String SELECT_COUNT_FROM_INSTRUMENTS = "Select COUNT(*) FROM instruments i " +
            "JOIN categories c ON i.category_id=c.id JOIN manufacturers m ON i.manufacturer_id=m.id ";

    private boolean isFirst = true;

    public String buildSelectAllQuery(FilterBean filterBean) {
        StringBuilder resultQuery = new StringBuilder(SELECT_FROM_INSTRUMENTS);
        resultQuery.append(addFilters(filterBean));
        resultQuery.append(addSort(filterBean));
        resultQuery.append(addLimit(filterBean.getInstrumentCount()));
        resultQuery.append(addOffset(filterBean.getOffset()));
        return resultQuery.toString();
    }

    public String buildSelectCountCountQuery(FilterBean filterBean) {
        StringBuilder resultQuery = new StringBuilder(SELECT_COUNT_FROM_INSTRUMENTS);
        resultQuery.append(addFilters(filterBean));
        return resultQuery.toString();
    }

    private String addFilters(FilterBean filterBean) {
        String categoryFilter = filterBean.getCategoryFilter();
        String manufacturerFilter = filterBean.getManufacturerFilter();
        StringBuilder result = new StringBuilder();
        buildFilterFromParameter(result, manufacturerFilter, MANUFACTURER_ID);
        buildFilterFromParameter(result, categoryFilter, CATEGORY_ID);
        return result.toString();
    }

    private String addSort(FilterBean filterBean) {
        StringBuilder result = new StringBuilder();
        String sortValue = filterBean.getSort();
        String sortDirection = filterBean.getSortDirection();
        if (isValidFilterParameter(sortValue)) {
            result.append(SQL_ORDER_BY).append(sortValue);
            if (sortDirection.equals(WebConstants.SORT_BACKWARD)) {
                result.append(SQL_DESC);
            } else {
                result.append(SQL_ASC);
            }
        }
        return result.toString();
    }

    private void buildFilterFromParameter(StringBuilder result, String filterParameter, String filterName) {
        if (isValidFilterParameter(filterParameter)) {
            result.append(addConditionWord()).append(filterName).append(SQL_QUOTATION_MARK)
                    .append(filterParameter).append(SQL_QUOTATION_MARK);
            isFirst = false;
        }
    }

    private String addConditionWord() {
        return isFirst ? SQL_WHERE : SQL_AND;
    }

    private String addLimit(Integer count) {
        return SQL_LIMIT + count;
    }

    private String addOffset(Integer offset) {
        return SQL_OFFSET + offset;
    }

    private boolean isValidFilterParameter(String parameter) {
        return parameter != null && !parameter.isEmpty();
    }
}
