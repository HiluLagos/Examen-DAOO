package ex1;

public class EncryptedNotification extends BaseNotification {
    EncryptedNotification(Component wrapee) {
        super(wrapee);
    }

    @Override
    public String read(){
        StringBuilder stringBuilder = new StringBuilder(wrapee.read());
        return stringBuilder.reverse().toString();
    }
}
