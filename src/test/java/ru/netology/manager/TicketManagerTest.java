package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {

    Ticket search1 = new Ticket(1, 22695, "SVO", "MLE", 540);
    Ticket search2 = new Ticket(2, 2465, "DME", "SIP", 160);
    Ticket search3 = new Ticket(3, 4008, "VKO", "AAQ", 140);
    Ticket search4 = new Ticket(4, 6100, "SVO", "HMA", 180);
    Ticket search5 = new Ticket(5, 2690, "LED", "KRR", 180);
    Ticket search6 = new Ticket(6, 1499, "LED", "VKO", 90);
    Ticket search7 = new Ticket(7, 1499, "SVO", "LED", 75);
    Ticket search8 = new Ticket(8, 2412, "VKO", "AER", 150);
    Ticket search9 = new Ticket(9, 46737, "SVO", "HKT", 600);
    Ticket search10 = new Ticket(10, 14430, "SVO", "CPH", 165);
    Ticket search11 = new Ticket(11, 2499, "LED", "VKO", 90);
    Ticket search12 = new Ticket(12, 1899, "LED", "VKO", 90);
    Ticket search13 = new Ticket(13, 1599, "LED", "VKO", 90);

    private TicketRepository repository = new TicketRepository();
    private TicketManager manager = new TicketManager(repository);

    @BeforeEach
    public void setUp() {
        manager.add(search1);
        manager.add(search2);
        manager.add(search3);
        manager.add(search4);
        manager.add(search5);
        manager.add(search6);
        manager.add(search7);
        manager.add(search8);
        manager.add(search9);
        manager.add(search10);
        manager.add(search11);
        manager.add(search12);
        manager.add(search13);
    }


    @Test
    void searchByFromAndToIfNoTicketsWithFromAndTo() {
        Ticket[] expected = new Ticket[]{};
        Ticket[] actual = manager.searchByAirport("XXX", "PPP");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByFromAndToIfOnlyOneTicket() {
        Ticket[] expected = new Ticket[]{search9};
        Ticket[] actual = manager.searchByAirport("SVO", "HKT");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByFromAndTo() {
        Ticket[] expected = new Ticket[]{search6, search13, search12, search11};
        Ticket[] actual = manager.searchByAirport("LED", "VKO");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchOnlyFirstConditionIsMet() {
        Ticket[] expected = new Ticket[]{};
        Ticket[] actual = manager.searchByAirport("DME", "VKO");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchOnlySecondConditionIsMet() {
        Ticket[] expected = new Ticket[]{};
        Ticket[] actual = manager.searchByAirport("XXX", "HKT");
        assertArrayEquals(expected, actual);
    }
}