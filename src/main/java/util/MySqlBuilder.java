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

    private static final int DEFAULT_LIMIT = 18;
    private static final int DEFAULT_OFFSET = 0;

    private boolean isFirst = true;

    public String buildQuery(FilterBean filterBean) {
        StringBuilder resultQuery = new StringBuilder(SELECT_FROM_INSTRUMENTS);
        resultQuery.append(addFilters(filterBean));
        resultQuery.append(addSort(filterBean));
        resultQuery.append(addLimit(filterBean.getInstrumentCount()));
        resultQuery.append(addOffset(filterBean.getOffset()));
        return resultQuery.toString();
    }

    private String addFilters(FilterBean filterBean) {
        String categoryFilter = filterBean.getCategoryFilter();
        String manufacturerFilter = filterBean.getManufacturerFilter();
        StringBuilder result = new StringBuilder();
        if (isValidFilterParameter(manufacturerFilter)) {
            result.append(addConditionWord()).append(MANUFACTURER_ID).append(SQL_QUOTATION_MARK)
                    .append(manufacturerFilter).append(SQL_QUOTATION_MARK);
            isFirst = false;
        }
        if (isValidFilterParameter(categoryFilter)) {
            result.append(addConditionWord()).append(CATEGORY_ID).append(SQL_QUOTATION_MARK)
                    .append(categoryFilter).append(SQL_QUOTATION_MARK);
            isFirst = false;
        }
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

    private String addConditionWord() {
        return isFirst ? SQL_WHERE : SQL_AND;
    }

    private String addLimit(String count) {
        if (isValidFilterParameter(count)) {
            return SQL_LIMIT + count;
        } else {
            return SQL_LIMIT + DEFAULT_LIMIT;
        }
    }

    private String addOffset(String offset) {
        if (isValidFilterParameter(offset)) {
            return SQL_OFFSET + offset;
        } else {
            return SQL_OFFSET + DEFAULT_OFFSET;
        }
    }

    private boolean isValidFilterParameter(String parameter) {
        return parameter != null && !parameter.isEmpty();
    }
}
