package service.manufacturer;

import dao.manufacturer.ManufacturerDao;
import dao.transaction.TransactionManager;
import entity.dto.Manufacturer;

import java.util.List;

public class MysqlManufacturerService implements ManufacturerService {

    private ManufacturerDao manufacturerDao;
    private TransactionManager transactionManager;

    public MysqlManufacturerService(ManufacturerDao manufacturerDao, TransactionManager transactionManager) {
        this.manufacturerDao = manufacturerDao;
        this.transactionManager = transactionManager;
    }

    @Override
    public List<Manufacturer> getAllManufacturers() {
        return transactionManager.processTransaction(() -> manufacturerDao.getAllManufacturers());
    }
}
