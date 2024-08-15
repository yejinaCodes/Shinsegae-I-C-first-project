package dao;

import dto.StockRequestDto;
import java.io.IOException;
import java.sql.SQLException;

public interface StockRequestDao {

  void create(StockRequestDto stockRequest) throws IOException, SQLException;


}
