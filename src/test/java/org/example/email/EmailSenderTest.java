package org.example.email;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for EmailSender to verify behavior in a multithreaded environment.
 */
public class EmailSenderTest {

    @Test
    public void shouldRunWithoutThrowingException() {
        EmailSender sender = new EmailSender("test@example.com");
        assertDoesNotThrow(sender::run, "EmailSender run() should not throw exceptions");
    }

    @Test
    public void shouldSetThreadNameCorrectly() {
        EmailSender sender = new EmailSender("name@example.com");
        Thread thread = new Thread(sender, "CustomEmailThread");
        assertEquals("CustomEmailThread", thread.getName(), "Thread name should match");
    }

    @Test
    public void shouldMarkThreadAsAliveWhenRunning() throws InterruptedException {
        EmailSender sender = new EmailSender("alive@example.com");
        Thread thread = new Thread(sender);
        thread.start();
        assertTrue(thread.isAlive(), "Thread should be alive after start()");
        thread.join();
    }

    @Test
    @Timeout(5)
    public void shouldCompleteWithinTimeout() throws InterruptedException {
        Thread thread = new Thread(new EmailSender("timeout@example.com"));
        thread.start();
        thread.join(); // Ensures the thread does not hang
    }

    @Test
    public void shouldExecuteMultipleThreadsConcurrently() throws InterruptedException {
        AtomicInteger counter = new AtomicInteger(0);
        Runnable fastSender = () -> {
            try {
                Thread.sleep(500);
                counter.incrementAndGet();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        Thread t1 = new Thread(fastSender);
        Thread t2 = new Thread(fastSender);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        assertEquals(2, counter.get(), "Both threads should complete independently");
    }

    @Test
    public void shouldHandleInterruptionGracefully() throws InterruptedException {
        Thread thread = new Thread(new EmailSender("interrupt@example.com"));
        thread.start();
        thread.interrupt();
        thread.join();
        assertFalse(thread.isAlive(), "Thread should be dead after interruption and join()");
    }
}
