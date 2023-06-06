package pl.schodowski.empireOfBooks.controler.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class OrderDto {

    private String clientName;

    private LocalDate date;

    private BigDecimal finalPrice;

    private String deliveryAddress;


    public OrderDto(String clientName, LocalDate date, double finalPrice, String deliveryAddress) {
        this.clientName = clientName;
        this.date = date;
        this.finalPrice = BigDecimal.valueOf(finalPrice).setScale(2, RoundingMode.HALF_UP);
        this.deliveryAddress = deliveryAddress;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "Client name = '" + clientName + '\'' +
                ", Date sales = " + date +
                ", Total sale price = " + finalPrice +
                ", Delivery address = '" + deliveryAddress + '\'' +
                '}';
    }
}

