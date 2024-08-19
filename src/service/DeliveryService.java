package service;

import dto.DeliveryDto;
import java.util.List;

public interface DeliveryService {
    void createDelivery(DeliveryDto var1);

    void updateDelivery(int var1);

    void deleteDelivery(int var1);

    List<DeliveryDto> getAll();
}
