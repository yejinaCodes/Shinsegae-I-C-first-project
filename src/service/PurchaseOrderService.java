package service;

import dto.PurchaseOrderDto;
import java.io.IOException;
import java.sql.SQLException;

public interface PurchaseOrderService {

  void create(PurchaseOrderDto purchaseOrder) throws IOException, SQLException;
}
