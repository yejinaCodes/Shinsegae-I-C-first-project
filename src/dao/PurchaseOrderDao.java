package dao;

import dto.PurchaseOrderDto;
import java.io.IOException;
import java.sql.SQLException;

public interface PurchaseOrderDao {

  void create(PurchaseOrderDto purchaseOrder) throws IOException, SQLException;


}