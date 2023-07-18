package com.klagan.retows.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import com.klagan.retows.dao.Price;
import com.klagan.retows.exception.BusinessException;
import com.klagan.retows.services.IPriceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Andy Gómez
 *
 */

@RestController
@RequestMapping(value = "/api")
public class PriceController {

    @Autowired
    private IPriceServices iPriceServices;

    /**
     * End-Point de tipo de Test el cual retorna un objeto Price
     *
     * @param String applicationDate
     * @param Long productId
     * @param Long chainId
     * @return ResponseEntity Prices
     */
    @GetMapping(value = "/prices")
    public ResponseEntity<?> getPrices(
            @RequestParam(value = "applicationDate", required = true) String applicationDate,
            @RequestParam(value = "productId", required = true) Long productId,
            @RequestParam(value = "chainId", required = true) Long chainId) {
        try {
            Optional<Price> op = iPriceServices.getPrice(applicationDate, productId, chainId);
            if (op.isPresent()) {
                return ResponseEntity.ok(op.get());
            }
            return ResponseEntity.noContent().build();
        } catch (BusinessException e) {
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Error al encontrar los precios");
            response.put("details", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}