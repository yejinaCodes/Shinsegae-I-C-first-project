package service.serviceImpl;

import dao.daoImpl.StockRequestDaoImpl;
import dto.StockRequestDto;
import java.sql.SQLException;
import service.StockRequestService;

public class StockRequestServiceImpl implements StockRequestService {
  StockRequestDaoImpl po = new StockRequestDaoImpl();
  @Override
  public void create(StockRequestDto stockRequest) throws SQLException {
    po.create(stockRequest);
  }
}
