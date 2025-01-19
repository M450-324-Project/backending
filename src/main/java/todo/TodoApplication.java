package todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application class for the Todo application.
 */
@SpringBootApplication
public class TodoApplication {

    /**
     * Main method to run the Spring Boot application.
     *
     * @param args the command line arguments
     */
    public static void main(final String[] args) {
        SpringApplication.run(TodoApplication.class, args);
    }
}
