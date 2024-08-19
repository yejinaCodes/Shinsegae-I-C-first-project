package service.serviceImpl;

import dao.daoImpl.ShippingInstructionDaoImpl;
import dto.ShippingInstructionDto;
import java.util.List;
import service.ShippingInstructionService;

public class ShippingInstructionServiceImpl implements ShippingInstructionService {
    ShippingInstructionDaoImpl instructionDaoImpl = new ShippingInstructionDaoImpl();

    public ShippingInstructionServiceImpl() {
    }

    public void createShippingInstruction() {
        this.instructionDaoImpl.createShippingInstruction();
    }

    public List<ShippingInstructionDto> getAll() {
        return this.instructionDaoImpl.findAll();
    }
}
