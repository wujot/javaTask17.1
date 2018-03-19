package ip.addres.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class DataController {
    private DatabaseOfUsers databaseOfUsers;

    public DataController(DatabaseOfUsers databaseOfUsers) {
        this.databaseOfUsers = databaseOfUsers;
    }

    @RequestMapping("/")
    public String home() {
        return "/index.html";
    }

    @ResponseBody
    @RequestMapping("/users")
    public String dataOnWeb(HttpServletResponse response) {
        List<String> record = new ArrayList<>();
        for (int i = 0; i < databaseOfUsers.getDatabase().size(); i++) {
            record.add(databaseOfUsers.getDatabase().get(i).toString());
        }
        return record.toString();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@RequestParam (value="firstName", defaultValue = "Anonim")
                                  String firstName, String lastName, String age) {
        List<User> record = databaseOfUsers.getDatabase();
        if (firstName.equals("") || lastName.equals("") || age.equals("")) {
            return "redirect:/err.html";
        } else {
            record.add(new User(firstName, lastName, age));
            return "redirect:/success.html";
        }
    }

}
