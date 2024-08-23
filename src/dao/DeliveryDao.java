package dao;

import dto.DeliveryDto;
import java.util.Deque;
import java.util.List;

public interface DeliveryDao {
    void createDelivery(DeliveryDto deliveryDto);

    void updateDelivery(int id, int select);

    boolean existenceByRelease(int id);

    List<DeliveryDto> findByAll();

    DeliveryDto findByID(int id);

    List<Integer> deliveryManAll();

    Deque<Integer> waitDeliveryMan();
}
