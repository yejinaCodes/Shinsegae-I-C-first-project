package dao;

import dto.DeliveryDto;
import java.util.Deque;
import java.util.List;

public interface DeliveryDao {
    void createDelivery(DeliveryDto var1);

    void updateDelivery(int var1, int var2);

    boolean existenceByRelease(int var1);

    List<DeliveryDto> findByAll();

    DeliveryDto findByID(int var1);

    List<Integer> deliveryManAll();

    Deque<Integer> waitDeliveryMan();
}
