/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.lenskartcommercewebservices.validator;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.basecommerce.enums.StockLevelStatus;
import de.hybris.platform.commercefacades.product.data.StockData;
import de.hybris.platform.commercewebservicescommons.errors.exceptions.LowStockException;
import de.hybris.platform.commercewebservicescommons.errors.exceptions.ProductLowStockException;
import de.hybris.lenskartcommercewebservices.stock.CommerceStockFacade;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static de.hybris.platform.commercewebservicescommons.errors.exceptions.LowStockException.LOW_STOCK;
import static de.hybris.platform.commercewebservicescommons.errors.exceptions.LowStockException.NO_STOCK;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;


/**
 * Unit test for {@link DefaultStockValidator}
 */
@UnitTest
public class DefaultStockPOSValidatorTest
{
	private static final String BASE_SITE_ID = "testSite";
	private static final Long ENTRY_NUMBER = 1L;
	private static final String PRODUCT_CODE = "12345";
	private static final String STORE_NAME = "testStore";

	@Mock
	private CommerceStockFacade commerceStockFacade;
	@Mock
	private StockData stock;
	private DefaultStockPOSValidator validator;

	@Before
	public void setUp()
	{
		MockitoAnnotations.initMocks(this);
		when(commerceStockFacade.isStockSystemEnabled(anyString())).thenReturn(true);
		when(stock.getStockLevelStatus()).thenReturn(StockLevelStatus.INSTOCK);
		when(commerceStockFacade.getStockDataForProductAndPointOfService(PRODUCT_CODE, STORE_NAME)).thenReturn(stock);
		this.validator = new DefaultStockPOSValidator(commerceStockFacade);
	}

	@Test
	public void testValidateWhenNoStock()
	{
		when(commerceStockFacade.getStockDataForProductAndBaseSite(anyString(), anyString())).thenReturn(null);

		validator.validate(BASE_SITE_ID, PRODUCT_CODE, STORE_NAME, ENTRY_NUMBER);
	}

	@Test
	public void testValidateWhenOutOfStockAndNoEntryNumber()
	{
		when(stock.getStockLevelStatus()).thenReturn(StockLevelStatus.OUTOFSTOCK);

		final ProductLowStockException actualException = assertThrows(ProductLowStockException.class,
				() -> validator.validate(BASE_SITE_ID, PRODUCT_CODE, STORE_NAME, null));

		assertThat(actualException).hasMessage("Product [%s] is currently out of stock", PRODUCT_CODE)
				.hasFieldOrPropertyWithValue("reason", NO_STOCK).hasFieldOrPropertyWithValue("subject", PRODUCT_CODE);
	}

	@Test
	public void testValidateWhenOutOfStockWithEntryNumber()
	{
		when(stock.getStockLevelStatus()).thenReturn(StockLevelStatus.OUTOFSTOCK);

		final LowStockException actualException = assertThrows(LowStockException.class,
				() -> validator.validate(BASE_SITE_ID, PRODUCT_CODE, STORE_NAME, ENTRY_NUMBER));

		assertThat(actualException).hasMessage("Product [%s] is currently out of stock", PRODUCT_CODE)
				.hasFieldOrPropertyWithValue("reason", NO_STOCK).hasFieldOrPropertyWithValue("subject", ENTRY_NUMBER.toString());
	}

	@Test
	public void testValidateWhenLowStockAndNoEntryNumber()
	{
		when(stock.getStockLevelStatus()).thenReturn(StockLevelStatus.LOWSTOCK);

		final ProductLowStockException actualException = assertThrows(ProductLowStockException.class,
				() -> validator.validate(BASE_SITE_ID, PRODUCT_CODE, STORE_NAME, null));

		assertThat(actualException).hasMessage("Not enough product in stock").hasFieldOrPropertyWithValue("reason", LOW_STOCK)
				.hasFieldOrPropertyWithValue("subject", PRODUCT_CODE);
	}

	@Test
	public void testValidateWhenLowStockWithEntryNumber()
	{
		when(stock.getStockLevelStatus()).thenReturn(StockLevelStatus.LOWSTOCK);

		final LowStockException actualException = assertThrows(LowStockException.class,
				() -> validator.validate(BASE_SITE_ID, PRODUCT_CODE, STORE_NAME, ENTRY_NUMBER));

		assertThat(actualException).hasMessage("Not enough product in stock").hasFieldOrPropertyWithValue("reason", LOW_STOCK)
				.hasFieldOrPropertyWithValue("subject", ENTRY_NUMBER.toString());
	}
}