package util;

import constants.WebConstants;
import entity.dto.FilterBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MySqlBuilder {

    private static final String SELECT_FROM_INSTRUMENTS =
            "SELECT i.ins_name, i.price, c.label, m.title FROM instruments i " +
                    "JOIN categories c ON i.category_id=c.id JOIN manufacturers m ON i.manufacturer_id=m.id ";
    private static final String SQL_LIMIT = " LIMIT ";
    private static final String SQL_WHERE = " WHERE ";
    private static final String SQL_AND = " AND ";
    private static final String SQL_ORDER_BY = " ORDER BY ";
    private static final String SQL_ASC = " ASC ";
    private static final String SQL_DESC = " DESC ";
    private static final String MANUFACTURER_ID = " category_id= ";
    private static final String CATEGORY_ID = " manufacturer_id= ";

    private static final String SQL_QUOTATION_MARK = "`";

    private boolean isFirst = true;

    public String buildQuery(FilterBean filterBean) {
        StringBuilder resultQuery = new StringBuilder(SELECT_FROM_INSTRUMENTS);
        resultQuery.append(addFilters(filterBean));
        resultQuery.append(addSort(filterBean));
        resultQuery.append(addLimit(filterBean.getCount()));
        return resultQuery.toString();
    }

    private String addFilters(FilterBean filterBean) {
        String categoryFilter = filterBean.getCategoryFilter();
        String manufacturerFilter = filterBean.getManufacturerFilter();
        StringBuilder result = new StringBuilder();
        if (!manufacturerFilter.equals("")) {
            result.append(addConditionWord()).append(MANUFACTURER_ID).append(SQL_QUOTATION_MARK)
                    .append(manufacturerFilter).append(SQL_QUOTATION_MARK);
            isFirst = false;
        }
        if (!categoryFilter.equals("")) {
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
        if (!sortValue.equals("")) {
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
        if (isFirst) {
            return SQL_WHERE;
        } else {
            return SQL_AND;
        }
    }

    private String addLimit(String count) {
        return SQL_LIMIT + count;
    }
}
