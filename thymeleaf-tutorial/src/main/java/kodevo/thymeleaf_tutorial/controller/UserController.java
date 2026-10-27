package kodevo.thymeleaf_tutorial.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kodevo.thymeleaf_tutorial.model.User;

@Controller
public class UserController {

    // handle method to handle variable-expresion request
    @GetMapping("variable-expression")
    public String variableExpresion(Model model){
        User user = new User("Ricardo", "r_gochicoa@hotmail.com", "ADMIN", "male");
        model.addAttribute("user", user);
        return "variable-expression";
    }

    // handler method to handle selection expression
    @GetMapping("selection-expression")
    public String selectionExpression(Model model){
        User user = new User("Ricardo2", "r_gochicoa2@hotmail.com", "ADMIN", "male");
        model.addAttribute("user", user);
        return "selection-expression";
    }

    // handler method to handle message expression request
    @GetMapping("message-expression")
    public String messageExpression(){
        return "message-expression";
    }

    //handler method to handle link expression
    @GetMapping("link-expression")
    public String linkExpression(Model model){
        model.addAttribute("id", 1);
        return "link-expression";
    }

    //handler method to handle fragment expression
    @GetMapping("fragment-expression")
    public String fragmentExpression(){
        return "fragment-expression";
    }
    
    @GetMapping("/users")
    public String users(Model model){
        User admin = new User("Admin", "admin@gmail.com", "ADMIN", "Male");
        User ricardo = new User("Ricardo", "ricardo@gmail.com", "User", "Male");
        User lady = new User("Lady", "lady@gmail.com", "User", "Female");
        List<User> users = new ArrayList<>();
        users.add(admin);
        users.add(ricardo);
        users.add(lady);
        model.addAttribute("users", users);
        return "users";
    }
    @GetMapping("/if-unless")
    public String ifUnless(Model model){
       User admin = new User("Admin", "admin@gmail.com", "ADMIN", "Male");
        User ricardo = new User("Ricardo", "ricardo@gmail.com", "User", "Male");
        User lady = new User("Lady", "lady@gmail.com", "User", "Female");
        List<User> users = new ArrayList<>();
        users.add(admin);
        users.add(ricardo);
        users.add(lady);
        model.addAttribute("users", users);
        return "if-unless"; 
    }

    @GetMapping("switch-case")
    public String switchCase(Model model){
        User admin = new User("Admin", "admin@gmail.com", "ADMIN", "Male");
        User ricardo = new User("Ricardo", "ricardo@gmail.com", "USER", "Male");
        User lady = new User("Lady", "lady@gmail.com", "User", "Female");
        List<User> users = new ArrayList<>();
        users.add(admin);
        users.add(ricardo);
        users.add(lady);
        model.addAttribute("user", ricardo);
        return "switch-case";
    }
}
