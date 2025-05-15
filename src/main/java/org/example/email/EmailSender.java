package org.example.email;



/**
 * EmailSender simulates the task of sending an email.
 */
public class EmailSender implements  Runnable{
    private final String recipient;

    /**
     * Constructs an EmailSender for the specified recipient.
     *
     * @param recipient the email address of the recipient
     */
    public EmailSender(String recipient) {
        this.recipient = recipient;
    }



    /**
     * Simulates sending an email by printing to the console.
     */
    @Override
    public void run() {
        System.out.println("Sending email to: "+recipient+" by "+Thread.currentThread().getName());
        try{
           Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Email sending interrupted for: "+recipient);
            Thread.currentThread().interrupt();
        }

        System.out.println("Email sent to: " + recipient + " by " + Thread.currentThread().getName());

    }
}
