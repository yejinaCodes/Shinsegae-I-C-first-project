package service.serviceImpl;

import dao.daoImpl.DeliveryDaoImpl;
import dto.DeliveryDto;
import java.util.List;
import service.DeliveryService;

public class DeliveryServiceImpl implements DeliveryService {
    static DeliveryDaoImpl dao = new DeliveryDaoImpl();

    public DeliveryServiceImpl() {
    }

    public void createDelivery(DeliveryDto deliveryDto) {
        dao.createDelivery(deliveryDto);
    }

    public void updateDelivery(int id) {
        dao.updateDelivery(id, 2);
    }

    public void deleteDelivery(int id) {
    }

    public List<DeliveryDto> getAll() {
        return dao.findByAll();
    }
}
