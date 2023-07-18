package com.klagan.retows.services;

import java.util.List;
import java.util.Optional;
import com.klagan.retows.dao.Price;
import com.klagan.retows.exception.BusinessException;

/**
 *
 *
 * @author Andy Gómez
 *
 */

public interface IPriceServices {

    /**
     * Obtener toda la lista de la tabla Prices
     * @return List Prices
     */
    List<Price> getPrices();

    /**
     * Obtener un valor opcional de la tabla Prices
     * @param String applicationDate
     * @param Long productId
     * @param Long chainId
     * @return Optional Prices
     * @throws BusinessException
     */
    Optional<Price> getPrice(String applicationDate, Long productId, Long chainId) throws BusinessException;
}