package com.xebia.tdd.training.hotelreservation.chapter4;

import org.junit.Test;
import org.mockito.Mockito;

/**
 * Created by Anand V on 7/21/16.
 */
public class MessageControllerTest {

    private MessageController messageController = Mockito.mock(MessageController.class);

    @Test
    public void testMessage() throws Exception {
        Message<String> mockMessage = (Message<String>) Mockito.mock(Message.class);
        messageController.setMessage(mockMessage);
        Mockito.when(messageController.setMessage(Mockito.<Message<String>>any())).thenReturn(true);
    }
}