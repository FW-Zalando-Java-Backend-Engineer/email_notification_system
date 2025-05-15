package org.example.email;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


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
}
