package com.beck.javaiii_kirkwood.shared;
import com.azure.communication.email.*;
import com.azure.communication.email.implementation.models.ErrorResponseException;
import com.azure.communication.email.models.*;
import com.azure.core.util.polling.PollResponse;
import com.azure.core.util.polling.SyncPoller;
import io.github.cdimascio.dotenv.Dotenv;
import jakarta.servlet.http.HttpServletRequest;



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
  public static boolean send2faCode(String Code, String email){
    String subject = "LearnX New User Confirmation";
    String code = Code;
    String Email=email;
    String message = "<h2>Welcome to LearnX</h2>";
    message += "<p>Please enter code <b>" + code + "</b> to activate your account.</p>";
    return sendemail(Email, subject, message);


  }
  public static boolean sendPasswordResetEmail(String email, String token, HttpServletRequest req) {
    String subject = "LearnX New User Confirmation";
    String message = "<h2>Welcome to LearnX</h2>";
    message += "<p>Please use this link to securely reset your password. This link will expire in 30 minutes</p>";
    String appURL="";
    if (req.isSecure()){
      appURL=req.getServletContext().getInitParameter("appURLCloud");
    }
    else {
      appURL=req.getServletContext().getInitParameter("appURLLocal");
    }
    String fullURL = String.format("%s/new-password?token=%s", appURL, token);
    message += String.format("<p><a href=\"%s\" target=\"_blank\">%s</a></p>", fullURL, fullURL);
    message += "<p>If you did not request to reset your password, you can ignore this message. Your password will not be changed.</p>";
    return sendemail(email, subject, message);





  }


}
