package com.beck.javaiii_kirkwood.shared;
import com.azure.communication.email.*;
import com.azure.communication.email.implementation.models.ErrorResponseException;
import com.azure.communication.email.models.*;
import com.azure.core.util.polling.PollResponse;
import com.azure.core.util.polling.SyncPoller;
import io.github.cdimascio.dotenv.Dotenv;

public class EmailService
{
  private static EmailClient CreateEmailClient(){
    Dotenv dotenv = Dotenv.load();
    String connectionString = dotenv.get("EMAIL_CONN");
    EmailClient emailClient = new EmailClientBuilder().connectionString(connectionString).buildClient();
    return emailClient;


  }
  public static boolean sendemail(String toAddr, String Subject, String Message) {
    try {
      Dotenv dotenv = Dotenv.load();
      EmailClient emailClient = CreateEmailClient();
      EmailAddress toAddress = new EmailAddress(toAddr);

      EmailMessage emailMessage = new EmailMessage()
          .setSenderAddress(dotenv.get("FROM_EMAIL"))
          .setToRecipients(toAddress)
          .setSubject(Subject)
          .setBodyHtml(Message);

      SyncPoller<EmailSendResult, EmailSendResult> poller = emailClient.beginSend(emailMessage, null);
      PollResponse<EmailSendResult> result = poller.waitForCompletion();

    } catch (ErrorResponseException ex) {
      System.out.println(ex.getMessage());
      return false;
    }
    return true;

  }
}
