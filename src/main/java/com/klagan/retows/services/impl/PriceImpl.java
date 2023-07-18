package com.klagan.retows.services.impl;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import com.klagan.retows.dao.Price;
import com.klagan.retows.exception.BusinessException;
import com.klagan.retows.repository.IPricesRepository;
import com.klagan.retows.services.IPriceServices;
import com.klagan.retows.utils.Fechas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Andy Gómez
 * @implNote Clase que tiene la lógica del negocio
 *
 */

@Service("iPriceServices")
public class PriceImpl implements IPriceServices {

    @Autowired
    IPricesRepository pricesRepository;

    @Autowired
    Fechas fechas;

    @Override
    public Optional<Price> getPrice(String applicationDate, Long productId, Long chainId) throws BusinessException {
        LocalDateTime dateTime = fechas.localDateTimeToString(applicationDate);
        Predicate<Price> filterPredicate = x -> x.getStartDate().isBefore(dateTime) && x.getEndDate().isAfter(dateTime)
                && x.getProductId().equals(productId) && x.getBrandId().getId().equals(chainId);
        List<Price> prices = getPrices().parallelStream().filter(filterPredicate).collect(Collectors.toList());
        if (prices.stream().count() > 1) {
            return prices.stream().max(Comparator.comparing(Price::getPriority));
        } else if (prices.stream().count() == 1) {
            return prices.stream().findFirst();
        } else {
            throw new BusinessException("No se ha encontrado precio para el producto: ", productId);
        }
    }

    @Override
    public List<Price> getPrices() {
        return StreamSupport.stream(pricesRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }
}