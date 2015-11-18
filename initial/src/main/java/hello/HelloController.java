package hello;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(tags = {"Hello"})
@RestController
public class HelloController {

    @ApiOperation(value = "hello example", notes = "This is an extended comment about the hello method")
    @RequestMapping(value = "/greetings", method = RequestMethod.GET)
    public String index() {
        return "Greetings from Spring Boot!";
    }
    
}
