package ex1;

public abstract class BaseNotification implements Component {

    final protected Component wrapee;

    BaseNotification(Component wrapee) {
        this.wrapee = wrapee;
    }

    @Override
    public String read(){
        return wrapee.read();
    }
}
