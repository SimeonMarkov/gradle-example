package com.example.gradle;

import com.example.gradle.model.AddressBook;
import com.example.gradle.model.Price;
import com.example.gradle.model.Trade;
import com.example.gradle.repository.PricingRepository;
import com.example.gradle.service.PricingService;
import com.example.gradle.service.SimplePricingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class GradleApplicationTests {

    @Test
    public void addCustomerTest() {
        Customer dummy = mock(Customer.class);
        AddressBook addressBook = new AddressBook();
        addressBook.addCustomer(dummy);
        assertEquals(1, addressBook.getNumberOFCustomers());
    }

    @Test
    public void testGetHighestPricedTrade() {
        Price price1 = new Price(10);
        Price price2 = new Price(15);
        Price price3 = new Price(25);

        PricingRepository pricingRepository = mock(PricingRepository.class);
        when(pricingRepository.gePriceForTrade(any(Trade.class)))
                .thenReturn(price1, price2, price3);

        PricingService service = new SimplePricingService(pricingRepository);
        Trade trade = mock(Trade.class);
        service.priceTrade(trade);
        verify(pricingRepository, times(1)).gePriceForTrade(trade);
    }
}
