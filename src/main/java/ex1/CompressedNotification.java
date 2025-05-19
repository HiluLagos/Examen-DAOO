package ex1;

public class CompressedNotification extends BaseNotification {
    CompressedNotification(Component wrapee) {
        super(wrapee);
    }

    @Override
    public String read(){
        return wrapee.read().replaceAll("\\s+", "");
    }
}
