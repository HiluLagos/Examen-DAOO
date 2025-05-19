package ex1;

import java.util.Objects;

public class FormatedNotification extends BaseNotification {
    final private String format;

    FormatedNotification(Component wrapee, String format) {
        super(wrapee);
        if (Objects.equals(format, "html") || Objects.equals(format, "xml")) {
            this.format = format;
        }
        else {
            throw new IllegalArgumentException("format must be either html or xml");
        }
    }

    @Override
    public String read(){
        if (format.equals("html")) {
            return String.format("<header>\n" +
                    "    <h1>MESSAGE RECEIVED</h1>\n" +
                    "    <p>%s</p>\n" +
                    "</header>", wrapee.read());
        }
        else if (format.equals("xml")) {
            return String.format("<heading>MESSAGE RECEIVED</heading>\n" +
                    "<body>%s</body>", wrapee.read());
        }
        else {
            throw new IllegalArgumentException("format must be either html or xml");
        }
    }
}
