package p02_Extended_Database;

import javax.naming.OperationNotSupportedException;
import java.util.TreeMap;

public class Database {

    private TreeMap<String, Person> databaseNames;
    private TreeMap<Long, Person> databaseIDs;


    public Database(Person... people) throws OperationNotSupportedException{
        this.databaseNames = new TreeMap<>();
        this.databaseIDs = new TreeMap<>();

        setPeoples(people);
    }

    private void setPeoples(Person... people) {
        for (Person person : people) {
            this.databaseIDs.put(person.getId(), person);
            this.databaseNames.put(person.getUsername(), person);
        }
    }

    public void add(Person person) throws OperationNotSupportedException {
        if(this.databaseIDs.containsKey(person.getId())){
            throw new OperationNotSupportedException();
        }
        this.databaseNames.put(person.getUsername(), person);
        this.databaseIDs.put(person.getId(), person);
    }

    public void remove(Person person){
        this.databaseIDs.remove(person.getId());
        this.databaseNames.remove(person.getUsername());
    }

    public Person findByUsername(String username) throws OperationNotSupportedException {
        if (username == null || !this.databaseNames.containsKey(username)){
            throw new OperationNotSupportedException();
        }

        return this.databaseNames.get(username);
    }

    public Person findById(Long id) throws OperationNotSupportedException {
        if (!this.databaseIDs.containsKey(id)){
            throw new OperationNotSupportedException();
        }

        return this.databaseIDs.get(id);
    }
}
