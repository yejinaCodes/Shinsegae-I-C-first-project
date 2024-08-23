package service;

import dto.CellDto;

import java.util.List;

public interface CellService {
    List<CellDto> getAll();
    CellDto getById(int id);
}
