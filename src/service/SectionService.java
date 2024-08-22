package service;

import dto.CellDto;
import dto.SectionDto;

import java.util.List;

public interface SectionService {
    List<SectionDto> getAll();
    SectionDto getById(int id);
}
