package com.klagan.retows.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Objects;
import com.klagan.retows.dao.Price;
import com.klagan.retows.utils.Fechas;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class PriceControllerTest {

    @Autowired
    private PriceController pricesController;

    @Autowired
    private Fechas fechas;

    private static final Long idProducto = 35455L;
    private static final Long idCadena = 1L;

    @Test
    public void test1() throws Exception {
        ResponseEntity<?> priceResponse = pricesController.getPrices("2020-06-14-10:00:00", idProducto, idCadena);
        if (priceResponse.getStatusCode() == HttpStatus.OK) {
            Price price = (Price) priceResponse.getBody();
            if (Objects.nonNull(price)) {
                assertEquals("2020-06-14-00:00:00", fechas.StringToLocalDateTime(price.getStartDate()));
                assertEquals("2020-12-31-23:59:59", fechas.StringToLocalDateTime(price.getEndDate()));
                assertEquals(1, price.getPriceList());
                assertEquals(35.50, price.getPrice().doubleValue());
                assertEquals(1, price.getId());
                assertEquals(1, price.getBrandId().getId());
            }
        } else {
            System.err.println(priceResponse.getStatusCode());
        }
    }

    @Test
    public void test2() throws Exception {
        ResponseEntity<?> priceResponse = pricesController.getPrices("2020-06-14-16:00:00", idProducto, idCadena);
        if (priceResponse.getStatusCode() == HttpStatus.OK) {
            Price price = (Price) priceResponse.getBody();
            if (Objects.nonNull(price)) {
                assertEquals("2020-06-14-15:00:00", fechas.StringToLocalDateTime(price.getStartDate()));
                assertEquals("2020-06-14-18:30:00", fechas.StringToLocalDateTime(price.getEndDate()));
                assertEquals(2, price.getPriceList());
                assertEquals(25.45, price.getPrice().doubleValue());
                assertEquals(2, price.getId());
                assertEquals(1, price.getBrandId().getId());
            }
        } else {
            System.err.println(priceResponse.getStatusCode());
        }
    }

    @Test
    public void test3() throws Exception {
        ResponseEntity<?> priceResponse = pricesController.getPrices("2020-06-14-21:00:00", idProducto, idCadena);
        if (priceResponse.getStatusCode() == HttpStatus.OK) {
            Price price = (Price) priceResponse.getBody();
            if (Objects.nonNull(price)) {
                assertEquals("2020-06-14-00:00:00", fechas.StringToLocalDateTime(price.getStartDate()));
                assertEquals("2020-12-31-23:59:59", fechas.StringToLocalDateTime(price.getEndDate()));
                assertEquals(1, price.getPriceList());
                assertEquals(35.50, price.getPrice().doubleValue());
                assertEquals(1, price.getId());
                assertEquals(1, price.getBrandId().getId());
            }
        } else {
            System.err.println(priceResponse.getStatusCode());
        }
    }

    @Test
    public void test4() throws Exception {
        ResponseEntity<?> priceResponse = pricesController.getPrices("2020-06-15-10:00:00", idProducto, idCadena);
        if (priceResponse.getStatusCode() == HttpStatus.OK) {
            Price price = (Price) priceResponse.getBody();
            if (Objects.nonNull(price)) {
                assertEquals("2020-06-15-00:00:00", fechas.StringToLocalDateTime(price.getStartDate()));
                assertEquals("2020-06-15-11:00:00", fechas.StringToLocalDateTime(price.getEndDate()));
                assertEquals(3, price.getPriceList());
                assertEquals(30.50, price.getPrice().doubleValue());
                assertEquals(3, price.getId());
                assertEquals(1, price.getBrandId().getId());
            }
        } else {
            System.err.println(priceResponse.getStatusCode());
        }
    }

    @Test
    public void test5() throws Exception {
        ResponseEntity<?> priceResponse = pricesController.getPrices("2020-06-16-21:00:00", idProducto, idCadena);
        if (priceResponse.getStatusCode() == HttpStatus.OK) {
            Price price = (Price) priceResponse.getBody();
            if (Objects.nonNull(price)) {
                assertEquals("2020-06-15-16:00:00", fechas.StringToLocalDateTime(price.getStartDate()));
                assertEquals("2020-12-31-23:59:59", fechas.StringToLocalDateTime(price.getEndDate()));
                assertEquals(4, price.getPriceList());
                assertEquals(38.95, price.getPrice().doubleValue());
                assertEquals(4, price.getId());
                assertEquals(1, price.getBrandId().getId());
            }
        } else {
            System.err.println(priceResponse.getStatusCode());
        }
    }
}