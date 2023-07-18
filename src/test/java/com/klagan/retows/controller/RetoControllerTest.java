package com.klagan.retows.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.math.BigDecimal;
import java.util.Optional;

import com.klagan.retows.dao.Brand;
import com.klagan.retows.dao.Price;
import com.klagan.retows.services.IPriceServices;
import com.klagan.retows.utils.Fechas;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
public class RetoControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private PriceController pricesController;

    @Mock
    private IPriceServices pricesServices;

    @Autowired
    private Fechas fechas;

    private static final Long idProducto = 35455L;
    private static final Long idCadena = 1L;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(pricesController).build();
    }

    @Test
    public void test1() throws Exception {
        String fechaAplicacion = "2020-06-14-10:00:00";
        Brand brand = new Brand();
        brand.setId(1L);
        Price prices = new Price();
        prices.setId(1L);
        prices.setPrice(new BigDecimal(35.5));
        prices.setPriceList(1);
        prices.setStartDate(fechas.localDateTimeToString("2020-06-14-00:00:00"));
        prices.setEndDate(fechas.localDateTimeToString("2020-12-31-23:59:59"));
        prices.setProductId(35455L);
        prices.setBrandId(brand);
        Optional<Price> oprices = Optional.of(prices);

        when(pricesServices.getPrice(fechaAplicacion, idProducto, idCadena)).thenReturn(oprices);

        // Act and Assert
        mockMvc.perform(get("/api/prices").param("fechaAplicacion", fechaAplicacion).param("idProducto", "35455")
                        .param("idCadena", "1")).andExpect(status().isOk())
                .andExpect(jsonPath("$.startDate").value("2020-06-14-00:00:00"))
                .andExpect(jsonPath("$.endDate").value("2020-12-31-23:59:59"))
                .andExpect(jsonPath("$.priceList").value(1))
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.price").value(35.50))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.cadena.id").value(1));
    }

    @Test
    public void test2() throws Exception {
        String fechaAplicacion = "2020-06-14-16:00:00";
        Brand brand = new Brand();
        brand.setId(1L);
        Price prices = new Price();
        prices.setId(2L);
        prices.setPrice(new BigDecimal(25.45));
        prices.setPriceList(2);
        prices.setStartDate(fechas.localDateTimeToString("2020-06-14-15:00:00"));
        prices.setEndDate(fechas.localDateTimeToString("2020-06-14-18:30:00"));
        prices.setProductId(35455L);
        prices.setBrandId(brand);
        Optional<Price> oprices = Optional.of(prices);

        when(pricesServices.getPrice(fechaAplicacion, idProducto, idCadena)).thenReturn(oprices);

        // Act and Assert
        mockMvc.perform(get("/api/prices").param("fechaAplicacion", fechaAplicacion).param("idProducto", "35455")
                        .param("idCadena", "1")).andExpect(status().isOk())
                .andExpect(jsonPath("$.startDate").value("2020-06-14-15:00:00"))
                .andExpect(jsonPath("$.endDate").value("2020-06-14-18:30:00"))
                .andExpect(jsonPath("$.priceList").value(2))
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.price").value(25.45))
                .andExpect(jsonPath("$.id").value(2))
                .andExpect(jsonPath("$.cadena.id").value(1));
    }

    @Test
    public void test3() throws Exception {
        String fechaAplicacion = "2020-06-14-21:00:00";
        Brand brand = new Brand();
        brand.setId(1L);
        Price prices = new Price();
        prices.setId(1L);
        prices.setPrice(new BigDecimal(35.5));
        prices.setPriceList(1);
        prices.setStartDate(fechas.localDateTimeToString("2020-06-14-00:00:00"));
        prices.setEndDate(fechas.localDateTimeToString("2020-12-31-23:59:59"));
        prices.setProductId(35455L);
        prices.setBrandId(brand);
        Optional<Price> oprices = Optional.of(prices);

        when(pricesServices.getPrice(fechaAplicacion, idProducto, idCadena)).thenReturn(oprices);

        // Act and Assert
        mockMvc.perform(get("/api/prices").param("fechaAplicacion", fechaAplicacion).param("idProducto", "35455")
                        .param("idCadena", "1")).andExpect(status().isOk())
                .andExpect(jsonPath("$.startDate").value("2020-06-14-00:00:00"))
                .andExpect(jsonPath("$.endDate").value("2020-12-31-23:59:59"))
                .andExpect(jsonPath("$.priceList").value(1))
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.price").value(35.50))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.cadena.id").value(1));
    }

    @Test
    public void test4() throws Exception {
        String fechaAplicacion = "2020-06-15-10:00:00";
        Brand brand = new Brand();
        brand.setId(1L);
        Price prices = new Price();
        prices.setId(3L);
        prices.setPrice(new BigDecimal(30.5));
        prices.setPriceList(3);
        prices.setStartDate(fechas.localDateTimeToString("2020-06-15-00:00:00"));
        prices.setEndDate(fechas.localDateTimeToString("2020-06-15-11:00:00"));
        prices.setProductId(35455L);
        prices.setBrandId(brand);
        Optional<Price> oprices = Optional.of(prices);

        when(pricesServices.getPrice(fechaAplicacion, idProducto, idCadena)).thenReturn(oprices);

        // Act and Assert
        mockMvc.perform(get("/api/prices").param("fechaAplicacion", fechaAplicacion).param("idProducto", "35455")
                        .param("idCadena", "1")).andExpect(status().isOk())
                .andExpect(jsonPath("$.startDate").value("2020-06-15-00:00:00"))
                .andExpect(jsonPath("$.endDate").value("2020-06-15-11:00:00"))
                .andExpect(jsonPath("$.priceList").value(3))
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.price").value(30.50))
                .andExpect(jsonPath("$.id").value(3))
                .andExpect(jsonPath("$.cadena.id").value(1));
    }

    @Test
    public void test5() throws Exception {
        String fechaAplicacion = "2020-06-16-21:00:00";
        Brand brand = new Brand();
        brand.setId(1L);
        Price prices = new Price();
        prices.setId(4L);
        prices.setPrice(new BigDecimal(38.95));
        prices.setPriceList(4);
        prices.setStartDate(fechas.localDateTimeToString("2020-06-15-16:00:00"));
        prices.setEndDate(fechas.localDateTimeToString("2020-12-31-23:59:59"));
        prices.setProductId(35455L);
        prices.setBrandId(brand);
        Optional<Price> oprices = Optional.of(prices);

        when(pricesServices.getPrice(fechaAplicacion, idProducto, idCadena)).thenReturn(oprices);

        // Act and Assert
        mockMvc.perform(get("/api/prices").param("fechaAplicacion", fechaAplicacion).param("idProducto", "35455")
                        .param("idCadena", "1")).andExpect(status().isOk())
                .andExpect(jsonPath("$.startDate").value("2020-06-15-16:00:00"))
                .andExpect(jsonPath("$.endDate").value("2020-12-31-23:59:59"))
                .andExpect(jsonPath("$.priceList").value(4))
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.price").value(38.95))
                .andExpect(jsonPath("$.id").value(4))
                .andExpect(jsonPath("$.cadena.id").value(1));
    }
}