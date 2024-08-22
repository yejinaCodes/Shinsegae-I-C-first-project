package dao;

import dto.CellDto;

import java.util.List;

public interface CellDao {
    List<CellDto> findAll();

    CellDto findById(int id);
}
