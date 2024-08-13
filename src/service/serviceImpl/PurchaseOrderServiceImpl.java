package service.serviceImpl;

import dao.daoImpl.PurchaseOrderDaoImpl;
import dto.PurchaseOrderDto;
import java.io.IOException;
import java.sql.SQLException;
import service.PurchaseOrderService;

public class PurchaseOrderServiceImpl implements PurchaseOrderService {
  @Override
  public void create(PurchaseOrderDto purchaseOrder) throws IOException, SQLException {
    PurchaseOrderDaoImpl po = new PurchaseOrderDaoImpl();
    po.create(purchaseOrder);
  }
}
