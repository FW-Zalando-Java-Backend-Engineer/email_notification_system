package org.example.email; // used for namespace management.



/**
 * EmailSender simulates the task of sending an email.
 */
public class EmailSender implements  Runnable{ // It implements Runnable, which allows it to be used as a task in a Thread.
    // Field 'state'
    private final String recipient; // the immutable state is thread-safe by default.

    /**
     * Constructs an EmailSender for the specified recipient.
     *
     * @param recipient the email address of the recipient
     */
    public EmailSender(String recipient) {
        this.recipient = recipient; // each instance sends to a different recipient.
    }



    /**
     * Simulates sending an email by printing to the console.
     */
    @Override // Overrides the run() method of Runnable. This method is what runs when the thread starts.
    public void run() {
        // Simulates "sending" by printing to console, along with the thread's name (for clarity in multithreaded runs).
        System.out.println("Sending email to: "+recipient+" by "+Thread.currentThread().getName());
        try{
           Thread.sleep(5000); // Pauses for 5 seconds to simulate delay, like waiting for SMTP or network IO.
        } catch (InterruptedException e) { // If the thread is interrupted while sleeping, we:
            System.out.println("Email sending interrupted for: "+recipient); // Print an error
            Thread.currentThread().interrupt(); // Reset the interrupt flag. Best practice
        }
        // Continue the simulation.
        System.out.println("Email sent to: " + recipient + " by " + Thread.currentThread().getName());

    }
}
