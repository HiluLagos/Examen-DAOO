package ex1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NotificationTests {

    @Test
    public void baseNotificationReadsItself_01(){
        Notification notification = new Notification("Important Message", "Hello World!");
        Assertions.assertEquals("- Important Message -\n" +
                "Hello World!", notification.read());
    }

    @Test
    public void encryptedNotificationsReadsWithEncryption_02(){
        Notification notification = new Notification("Encrypted Message", "Hello World!");
        EncryptedNotification encryptedNotification = new EncryptedNotification(notification);
        Assertions.assertEquals("!dlroW olleH\n" +
                "- egasseM detpyrcnE -", encryptedNotification.read());
    }

    @Test
    public void compressedNotificationReadsAsCompressed_03(){
        Notification notification = new Notification("Compressed Message", "Hello World!");
        CompressedNotification compressedNotification = new CompressedNotification(notification);
        Assertions.assertEquals("-CompressedMessage-HelloWorld!", compressedNotification.read());
    }

    @Test
    public void htmlFormattedNotificationReadsFormated_04(){
        Notification notification = new Notification("HTML Formatted Message", "Hello World!");
        FormatedNotification formatedNotification = new FormatedNotification(notification, "html");
        Assertions.assertEquals("<header>\n" +
                "    <h1>MESSAGE RECEIVED</h1>\n" +
                "    <p>- HTML Formatted Message -\n" +
                "Hello World!</p>\n" +
                "</header>", formatedNotification.read());
    }

    @Test
    public void xmlFormattedNotificationReadsFormated_05(){
        Notification notification = new Notification("XML Formatted Message", "Hello World!");
        FormatedNotification formatedNotification = new FormatedNotification(notification, "xml");
        Assertions.assertEquals("<heading>MESSAGE RECEIVED</heading>\n" +
                "<body>- XML Formatted Message -\n" +
                "Hello World!</body>", formatedNotification.read());
    }

    @Test
    public void encryptedNotificationCanBeCompressed_06(){
        Notification notification = new Notification("Encrypted Message", "Hello World!");
        EncryptedNotification encryptedNotification = new EncryptedNotification(notification);
        CompressedNotification compressedNotification = new CompressedNotification(encryptedNotification);
        Assertions.assertEquals("!dlroWolleH-egasseMdetpyrcnE-", compressedNotification.read());
    }

    @Test
    public void htmlFormattedNotificationCanBeCompressed_07(){
        Notification notification = new Notification("HTML Formatted Message", "Hello World!");
        FormatedNotification formatedNotification = new FormatedNotification(notification, "html");
        CompressedNotification compressedNotification = new CompressedNotification(formatedNotification);
        Assertions.assertEquals("<header><h1>MESSAGERECEIVED</h1><p>-HTMLFormattedMessage-HelloWorld!</p></header>", compressedNotification.read());
    }

    // Add tests for all combinations...
    @Test
    public void allNotificationsCanBeCombined_08(){
        Notification notification = new Notification("All Notifications", "Hello World!");
        FormatedNotification formatedNotification = new FormatedNotification(notification, "html");
        EncryptedNotification encryptedNotification = new EncryptedNotification(formatedNotification);
        CompressedNotification compressedNotification = new CompressedNotification(encryptedNotification);
        Assertions.assertEquals(">redaeh/<>p/<!dlroWolleH-snoitacifitoNllA->p<>1h/<DEVIECEREGASSEM>1h<>redaeh<", compressedNotification.read());
    }

    @Test
    public void sameNotificationsCanBeAppliedManyTimes_09(){
        Notification notification = new Notification("Encrypted Notification", "Hello World!");
        EncryptedNotification encryptedNotification = new EncryptedNotification(notification);
        EncryptedNotification encryptedNotification2 = new EncryptedNotification(encryptedNotification);
        Assertions.assertEquals("- Encrypted Notification -\n" +
                "Hello World!", encryptedNotification2.read());
    }
}
