package com.klagan.retows.repository;

import com.klagan.retows.dao.Price;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Andy Gómez
 *
 */

@Repository
public interface IPricesRepository extends CrudRepository<Price, Long>{

}