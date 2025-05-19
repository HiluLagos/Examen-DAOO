package ex1;

public class Notification implements Component {
    final private String title;
    final private String body;

    public Notification(String title, String body) {
        this.title = title;
        this.body = body;
    }

    @Override
    public String read() {
        return "- " + title + " -\n" + body;
    }
}
