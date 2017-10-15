package myproject.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by zhoulei on 2017/9/28.
 */
@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private static List tempGreeting = new ArrayList();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name",defaultValue = "World") String name ) {
        Greeting greeting = new Greeting(counter.incrementAndGet(), String.format(template, name));
        tempGreeting.add(greeting);
        return  greeting;
    }

    @RequestMapping("/exists")
    public boolean exists(@RequestParam(value = "id",required = true) int id){
        List userList = new ArrayList();
        userList.add(2);
        userList.add(6);
        userList.add(4);
        userList.add(11);
        userList.add(14);
        userList.add(1);
        return userList.contains(id);
    }

    @RequestMapping("/algreeting")
    public List allGreeting(){
        return tempGreeting;
    }

    @Autowired
    private UserRepository userRepository;

    //这是使用mysql连接数据库的教程
    @GetMapping("/adduser")
    public @ResponseBody String addNewUser(@RequestParam String name,@RequestParam String email){
        UserHello userHello = new UserHello();
        userHello.setName(name);
        userHello.setEmail(email);
        userRepository.save(userHello);
        return "保存";
    }

    @GetMapping("/alluser")
    public @ResponseBody Iterable<UserHello> getAllUsers(){
        return userRepository.findAll();
    }

    //这是使用jpa访问数据库的教程
    //https://spring.io/guides/gs/accessing-data-jpa/
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/addcustomer")
    public @ResponseBody String addCustomer(@RequestParam String firstName,@RequestParam String lastName){
        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customerRepository.save(customer);
        return "success";
    }

    @GetMapping("/getcustomerbylastname")
    public @ResponseBody List<Customer> getCustomerByLastName(@RequestParam String lastName){
        return customerRepository.findByLastName(lastName);
    }

}
