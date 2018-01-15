package service.category;

import dao.category.CategoryDao;
import dao.transaction.TransactionManager;
import entity.dto.Category;

import java.util.List;

public class MysqlCategoryService implements CategoryService {

    private CategoryDao categoryDao;
    private TransactionManager transactionManager;

    public MysqlCategoryService(CategoryDao categoryDao, TransactionManager transactionManager) {
        this.categoryDao = categoryDao;
        this.transactionManager = transactionManager;
    }

    @Override
    public List<Category> getAllCategories() {
        return transactionManager.processTransaction(() -> categoryDao.getAllCategories());
    }
}
