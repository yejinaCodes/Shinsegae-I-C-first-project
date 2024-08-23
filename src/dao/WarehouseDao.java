package dao;

import dto.WarehouseDto;

import java.util.List;

public interface WarehouseDao {
    List<WarehouseDto> findAll();
}
