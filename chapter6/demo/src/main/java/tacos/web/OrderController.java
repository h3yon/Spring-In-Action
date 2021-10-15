package tacos.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tacos.Order;
import tacos.data.OrderRepository;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("order")
public class OrderController {

    private OrderRepository orderRepo;

    public OrderController(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    @PatchMapping(path = "/{orderId}", consumes = "application/json")
    public Order patchOrder(@PathVariable("orderId") Long orderId,
                            @RequestBody Order patch){
        Order order = orderRepo.findById(orderId).get();
        if(patch.getDeliveryName() != null) order.setDeliveryName(patch.getDeliveryName());
        if(patch.getDeliveryStreet() != null) order.setDeliveryStreet(patch.getDeliveryStreet());
        if(patch.getDeliveryCity() != null) order.setDeliveryCity(patch.getDeliveryCity());
        if(patch.getDeliveryState() != null) order.setDeliveryState(patch.getDeliveryState());
        if(patch.getDeliveryZip() != null) order.setDeliveryZip(patch.getDeliveryZip());
        if(patch.getCcNumber() != null) order.setCcNumber(patch.getCcNumber());
        if(patch.getCcExpiration() != null) order.setCcExpiration(patch.getCcExpiration());
        if(patch.getCcCVV() != null) order.setCcCVV(patch.getCcCVV());
        return orderRepo.save(order);
    }

    @DeleteMapping("/{orderId}")
    @ResponseStatus(code= HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable("orderId") Long orderId){
        try{
            orderRepo.deleteById(orderId);
        }catch (EmptyResultDataAccessException e) {}
    }
}
