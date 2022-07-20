import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TicketManagerTest {
    TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager(repository);

    Ticket ticket1 = new Ticket(1, 4500,"DME", "KZN",6);
    Ticket ticket2 = new Ticket(2, 7500,"DME", "KZN",6);
    Ticket ticket3 = new Ticket(3, 8500,"DME", "KZN",6);
    Ticket ticket4 = new Ticket(4, 3500,"DME", "KZN",6);
    Ticket ticket5 = new Ticket(5, 2500,"DME", "KZN",6);
    Ticket ticket6 = new Ticket(6, 9000,"DME", "KZN",6);

    @Test

    public void findTicketAssert () {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Ticket[] actual = {ticket5, ticket4, ticket1, ticket2, ticket3, ticket6};
        Ticket[] expended = manager.searchByFromAndTo("DME", "KZN");

        assertArrayEquals(actual, expended);
    }

    @Test
    public void findTicketNoFromAndTo () {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Ticket[] actual = {};
        Ticket[] expended = manager.searchByFromAndTo("MOV", "VKO");

        assertArrayEquals(actual, expended);
    }

    @Test
    public void findTicketTrueTo () {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Ticket[] actual = {};
        Ticket[] expended = manager.searchByFromAndTo("MOV", "KZN");

        assertArrayEquals(actual, expended);
    }

    @Test
    public void findTicketTrueFrom () {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Ticket[] actual = {};
        Ticket[] expended = manager.searchByFromAndTo("DME", "MOV");

        assertArrayEquals(actual, expended);
    }

    @Test
    public void removeTicket () {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        repository.removeById(ticket2.getId());

        Ticket[] actual = repository.findAll();
        Ticket[] expended = {ticket1, ticket3,ticket4,ticket5,ticket6};

        assertArrayEquals(actual, expended);
    }
}
