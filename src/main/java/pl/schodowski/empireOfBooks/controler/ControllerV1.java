package pl.schodowski.empireOfBooks.controler;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.schodowski.empireOfBooks.controler.dto.OrderDto;
import pl.schodowski.empireOfBooks.services.OrderService;

import java.util.List;

@RestController
public class ControllerV1 {

    @Autowired
    OrderService orderService;

    public ControllerV1(OrderService orderService) {
        this.orderService = orderService;
    }
    @Operation(summary = "pobieranie listy zamowień")
    @GetMapping("/getOrders")
    public List<OrderDto> getAllOrders(){
        return orderService.getAllOrders();
    }
}
