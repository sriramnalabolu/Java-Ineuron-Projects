package in.ineuron.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/greet")
public class GreetRestController {

    @GetMapping("/wish/{userName}")
    public ResponseEntity<String> sayHello(@PathVariable String userName) {
        LocalDateTime ldt = LocalDateTime.now();
        int hour = ldt.getHour();

        String body = null;

        if (hour < 12) {
            body = "Good Morning :: " + userName;
        } else if (hour < 16) {
            body = "Good Afternoon :: " + userName;
        } else if (hour < 20) {
            body = "Good Evening :: " + userName;
        } else {
            body = "Good Night :: " + userName;
        }

        return new ResponseEntity<String>(body, HttpStatus.OK);
    }
}
