import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p02_Extended_Database.Database;
import p02_Extended_Database.Person;

import javax.naming.OperationNotSupportedException;

public class p02_Extended_Database_Tests {

    private static final String USERNAME = "Joro";
    private static final long ID = 12361671L;
    private Database database;

    @Before
    public void initialize() throws OperationNotSupportedException {
        Person pesho = new Person("Pesho", 1L);
        Person ivan = new Person("Ivan", 2L);
        Person venci = new Person("Venci", 3L);

        this.database = new Database(pesho, ivan, venci);
    }

    @Test()
    public void ConstructorWithNoParametersShouldNotThrowException() throws OperationNotSupportedException {
        this.database = new Database();
    }

    @Test()
    public void AddNewPerson() throws OperationNotSupportedException {
        this.database.add(new Person("Kiro", 4L));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void AddNewPersonWithTheSameIdShouldThrowException() throws OperationNotSupportedException {
        this.database.add(new Person("Kiro", 3L));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void AddNewPersonWithNullIdShouldThrowException() throws OperationNotSupportedException {
        this.database.add(new Person("Kiro", null));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void AddNewPersonWithNegativeIdShouldThrowException() throws OperationNotSupportedException {
        this.database.add(new Person("Kiro", -2L));
    }

    @Test()
    public void RemovePersonShouldWorkCorrectly() throws OperationNotSupportedException {
        this.database.remove(new Person("Venci", 3L));
    }

    @Test()
    public void FindByUsernameShouldWorkCorrectly() throws OperationNotSupportedException {
        Person joro = new Person(USERNAME, ID);
        this.database.add(joro);

        Assert.assertEquals(this.database.findByUsername(USERNAME), joro);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void FindByUsernameShouldThrowExceptionIfNoSuchUsernameExist() throws OperationNotSupportedException {
        Person joro = new Person(USERNAME, ID);

        Assert.assertEquals(this.database.findByUsername(USERNAME), joro);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void FindByUsernameShouldThrowExceptionIfUsernameIsNull() throws OperationNotSupportedException {
        String username = null;
        Person joro = new Person(username, ID);

        Assert.assertEquals(this.database.findByUsername(username), joro);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void FindByUsernameIsCaseSensitiveShouldThrowException() throws OperationNotSupportedException {
        Person joro = new Person(USERNAME, ID);

        Assert.assertNotEquals(this.database.findByUsername("joro"), joro);
    }

    @Test()
    public void FindByIdShouldWorkCorrectly() throws OperationNotSupportedException {
        Person joro = new Person(USERNAME, ID);
        this.database.add(joro);

        Assert.assertEquals(this.database.findById(ID), joro);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void FindByIdShouldThrowExceptionIfNoSuchIDExist() throws OperationNotSupportedException {
        Person joro = new Person(USERNAME, ID);
        this.database.add(joro);

        Assert.assertEquals(this.database.findById(4L), joro);
    }
}
