package service.serviceImpl;

import dao.daoImpl.StockRequestDaoImpl;
import dto.StockRequestDto;
import java.sql.SQLException;
import java.util.ArrayList;
import service.StockRequestService;

public class StockRequestServiceImpl implements StockRequestService {
  StockRequestDaoImpl po = new StockRequestDaoImpl();
  @Override
  public void create(StockRequestDto stockRequest) {
    po.create(stockRequest);
  }

  @Override
  public ArrayList<StockRequestDto> findByAll() throws SQLException {
    return po.findByAll();
  }

  @Override
  public ArrayList<StockRequestDto> findByStatus(){
    return po.findByStatus();
  }

  @Override
  public boolean updateStatus(ArrayList<Integer> updateList){
    return po.updateStatus(updateList);
  }

}
