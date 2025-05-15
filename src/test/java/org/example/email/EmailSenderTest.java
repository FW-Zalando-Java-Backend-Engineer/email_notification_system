package org.example.email;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Unit tests for EmailSender.
 */
public class EmailSenderTest {
    @Test
    public void testEmailSenderRun(){
        EmailSender sender = new EmailSender("test@example.com");
        assertDoesNotThrow(
                () -> sender.run(), "EmailSender run method should not throw an exception.");
    }

    @Test
    public void threadShouldHaveCorrectName(){
        Thread thread = new Thread(new EmailSender("test@example.com"), "EmailThread-1");
        assertEquals("EmailThread-1", thread.getName(),"Thread name should follow the template '\"EmailThread-number\"");
    }

    @Test
    public void mainThreadShouldWaitForEmailThreadToFinish() throws InterruptedException{
        Thread thread = new Thread(new EmailSender("wait@example.com"));
        thread.start();
        thread.join();
        assertFalse(thread.isAlive(), "Thread should be dead after join()");
    }

}
