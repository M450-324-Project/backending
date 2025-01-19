package todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoApplication {

    private TodoApplication() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static void main(final String[] args) {
        SpringApplication.run(TodoApplication.class, args);
    }

}
