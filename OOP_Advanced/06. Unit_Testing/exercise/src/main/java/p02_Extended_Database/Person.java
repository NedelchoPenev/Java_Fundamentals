package p02_Extended_Database;

import javax.naming.OperationNotSupportedException;

public class Person {

    private String username;
    private Long id;

    public Person(String username, Long id) throws OperationNotSupportedException {
        this.username = username;
        this.setId(id);
    }

    public String getUsername() {
        return username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) throws OperationNotSupportedException {
        if (id == null || id < 0){
            throw new OperationNotSupportedException();
        }
        this.id = id;
    }
}
