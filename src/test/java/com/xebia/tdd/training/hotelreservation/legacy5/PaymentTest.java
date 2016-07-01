package com.xebia.tdd.training.hotelreservation.legacy5;

import com.xebia.tdd.training.hotelreservation.chapter4.HotelEmployeeDAO;
import com.xebia.tdd.training.hotelreservation.chapter4.HotelEmployeeMailService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Created by Anand V on 6/21/16.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({Payment.class, String.class})
public class PaymentTest {

    private static CardType mockCardType = Mockito.mock(CardType.class);

    @Mock
    HotelEmployeeDAO hotelEmployeeDAO;

    @Mock
    HotelEmployeeMailService mailService;

    @InjectMocks
    Payment payment = new Payment();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void cardTest() throws Exception {
        PowerMockito.whenNew(CardType.class).withArguments(Mockito.anyString()).thenReturn(mockCardType);
        CardType cardType = payment.getCard();
        Assert.assertSame(mockCardType, cardType);

    }

}