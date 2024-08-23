package service;

import dto.DeliveryDto;
import java.util.List;

public interface DeliveryService {
    void createDelivery(DeliveryDto deliveryDto);

    void updateDelivery(int id);

    List<DeliveryDto> getAll();

    DeliveryDto getId(int id);
}
