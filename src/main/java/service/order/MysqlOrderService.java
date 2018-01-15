package service.order;

import dao.order.OrderDao;
import dao.transaction.TransactionManager;

public class MysqlOrderService implements OrderService {

    private TransactionManager transactionManager;

    public MysqlOrderService(TransactionManager transactionManager, OrderDao orderDao) {
        this.transactionManager = transactionManager;
    }
}
