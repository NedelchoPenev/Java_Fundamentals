import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import p06_Twitter.contracts.Client;
import p06_Twitter.contracts.Server;
import p06_Twitter.contracts.Tweet;
import p06_Twitter.models.Message;
import p06_Twitter.models.MicrowaveOven;
import p06_Twitter.models.ServerImpl;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.List;

public class p06_Twitter_Tests {

    private static final int MESSAGE_LENGTH_EMPTY_SIZE = 0;
    private static final String TEST_MESSAGE = "this is a test";
    private Tweet tweet;

    @Before
    public void init() {
        this.tweet = Mockito.mock(Tweet.class);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void microwaveShouldImplementClientInterface(){
        Class<? extends Client> microwave = MicrowaveOven.class;
        Class<?>[] interfaces = microwave.getInterfaces();
        Class<Client> clientClass = null;
        for (Class currentInterface : interfaces) {
            if (currentInterface.getSimpleName().equals("Client")) {
                clientClass = currentInterface;
                break;
            }
        }
        Assert.assertSame(Client.class, clientClass);
    }

    @Test
    public void retrieveMessagesShouldPrintMessage() {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stream));
        Tweet tweet = new Message();
        Client client = new MicrowaveOven(new ServerImpl());
        client.receivesMessage(tweet);
        int size = stream.size();
        Assert.assertNotEquals(MESSAGE_LENGTH_EMPTY_SIZE, size);
    }

    @Test
    public void retrieveMessagesShouldPrintExactMessage() {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stream));
        Mockito.when(this.tweet.retrieveMessage()).thenReturn(TEST_MESSAGE);
        Client client = new MicrowaveOven(new ServerImpl());
        client.receivesMessage(this.tweet);
        Assert.assertEquals(TEST_MESSAGE, stream.toString().trim());
    }

    @Test
    public void testStoreMessageOnTheServer() throws NoSuchFieldException, IllegalAccessException {
        Mockito.when(this.tweet.retrieveMessage()).thenReturn(TEST_MESSAGE);
        Server server = new ServerImpl();
        Client client = new MicrowaveOven(server);
        client.receivesMessage(this.tweet);
        Field messageField = server.getClass().getDeclaredField("messagesStore");
        messageField.setAccessible(true);
        List<String> values = List.class.cast(messageField.get(server));
        Assert.assertEquals(TEST_MESSAGE, values.get(0));
    }

}
