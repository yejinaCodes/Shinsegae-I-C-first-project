package dao;

import dto.CellDto;
import dto.SectionDto;

import java.util.List;

public interface SectionDao {
    List<SectionDto> findAll();

    SectionDto findById(int id);
}
