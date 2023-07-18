package com.klagan.retows;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Optional;
import com.klagan.retows.dao.Price;
import com.klagan.retows.exception.BusinessException;
import com.klagan.retows.services.IPriceServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RetowsApplicationTests {

	@Autowired
	private IPriceServices iPricesServices;

	private static final Long idProducto = 35455L;
	private static final Long idCadena = 1L;

	@Test
	void Test1() throws BusinessException {
		String fechaAplicacion = "2020-06-14-10:00:00";
		Optional<Price> op = iPricesServices.getPrice(fechaAplicacion, idProducto, idCadena);
		assertEquals(1L, op.get().getId());
	}

	@Test
	void Test2() throws BusinessException {
		String fechaAplicacion = "2020-06-14-16:00:00";
		Optional<Price> op = iPricesServices.getPrice(fechaAplicacion, idProducto, idCadena);
		assertEquals(2L, op.get().getId());
	}

	@Test
	void Test3() throws BusinessException {
		String fechaAplicacion = "2020-06-14-21:00:00";
		Optional<Price> op = iPricesServices.getPrice(fechaAplicacion, idProducto, idCadena);
		assertEquals(1L, op.get().getId());
	}

	@Test
	void Test4() throws BusinessException {
		String fechaAplicacion = "2020-06-15-10:00:00";
		Optional<Price> op = iPricesServices.getPrice(fechaAplicacion, idProducto, idCadena);
		assertEquals(3L, op.get().getId());
	}

	@Test
	void Test5() throws BusinessException {
		String fechaAplicacion = "2020-06-16-21:00:00";
		Optional<Price> op = iPricesServices.getPrice(fechaAplicacion, idProducto, idCadena);
		assertEquals(4L, op.get().getId());
	}
}