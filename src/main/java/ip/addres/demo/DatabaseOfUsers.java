package ip.addres.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DatabaseOfUsers {


    private List<User> database;

    @Autowired
    public DatabaseOfUsers() {
        database = new ArrayList<>();
        database.add(new User("Jan", "Kowalski", "30"));
        database.add(new User("Adam", "Malysz", "15"));
        database.add(new User("Pawel", "Gawel", "68"));
    }

    public List<User> getDatabase() {
        return database;
    }

    public void setDatabase(List<User> database) {
        this.database = database;
    }
}
