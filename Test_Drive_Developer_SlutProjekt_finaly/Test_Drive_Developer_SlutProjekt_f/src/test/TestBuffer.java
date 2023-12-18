package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.Item;
import mock.MockBuffer;
import mock.MockConsumer;
import mock.MockItem;
import mock.MockProducer;

public class TestBuffer {

    @Test
    @DisplayName("Verify Buffer is Not Empty After Adding Item")
    void testBufferNotEmpty() {
        MockBuffer bufferMock = new MockBuffer();
        MockProducer producerMock = new MockProducer(bufferMock);
        MockConsumer consumerMock = new MockConsumer(bufferMock);
        MockItem itemMock = new MockItem("friends");
        producerMock.additem(itemMock);
        assertEquals(itemMock, consumerMock.removeItem());
    }
    
    @Test
    @DisplayName("Ensure Buffer is Empty After Removal")
    void testBufferEmptyPostRemoval() {
        MockBuffer bufferMock = new MockBuffer();
        MockProducer producerMock = new MockProducer(bufferMock);
        MockConsumer consumerMock = new MockConsumer(bufferMock);
        MockItem itemMock = new MockItem("friends");
        producerMock.additem(itemMock);
        consumerMock.removeItem();
        assertTrue(bufferMock.getBuffer().isEmpty());
    }
    
    @Test
    @DisplayName("Validate Output on Adding New Item")
    void testBufferAddOutput() {
    	ByteArrayOutputStream capturedOutput = new ByteArrayOutputStream();
    	PrintStream originalOut = System.out;
    	System.setOut(new PrintStream(capturedOutput));
    	
    	MockBuffer bufferMock = new MockBuffer();
    	MockProducer producerMock = new MockProducer(bufferMock);
    	producerMock.additem(new MockItem("warrior"));
    	
    	assertTrue(capturedOutput.toString().contains("[warrior]"));
    	System.setOut(originalOut);
    }
    
    @Test
    @DisplayName("Confirm Return Value of additem is True")
    void testAddItemReturnValue() {
        MockBuffer bufferMock = new MockBuffer();
        MockProducer producerMock = new MockProducer(bufferMock);
        MockItem itemMock = new MockItem("friends");
        assertTrue(producerMock.additem(itemMock));
    }

    @Test
    @DisplayName("Buffer Interruption Handling Test")
    void testBufferInterruptionHandling() throws InterruptedException {
        MockBuffer bufferMock = new MockBuffer();
        MockConsumer consumerMock = new MockConsumer(bufferMock);

        Thread testThread = new Thread(() -> assertThrows(InterruptedException.class, ()-> consumerMock.removeItem()));
        testThread.start();
        testThread.interrupt();
    }
    @Test
    @DisplayName("isEmpty returns true when buffer is empty")
    void testIsEmptyWhenBufferIsEmpty() {
        MockBuffer buffer = new MockBuffer();
        assertTrue(buffer.isEmpty(), "Buffer should be empty");
    }
    @Test
    @DisplayName("isEmpty returns false when buffer has items")
    void testIsEmptyWhenBufferIsNotEmpty() {
        MockBuffer buffer = new MockBuffer();
        buffer.add(new Item("test"));  // Antag att du har en passande konstruktor i Item-klassen
        assertFalse(buffer.isEmpty(), "Buffer should not be empty after adding an item");
    }



}
