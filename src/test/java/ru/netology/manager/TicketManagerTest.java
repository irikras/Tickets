package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    private TicketRepository repository = new TicketRepository();
    private TicketManager manager = new TicketManager(repository);
    private Ticket T1 = new Ticket(1, 6500, "DME", "GOJ", 200);
    private Ticket T2 = new Ticket(2, 3000, "SVO", "KUF", 115);
    private Ticket T3 = new Ticket(3, 4800, "DME", "OGZ", 600);
    private Ticket T4 = new Ticket(4, 2500, "SVO", "KUF", 100);
    private Ticket T5 = new Ticket(5, 5700, "DME", "GOJ", 350);

    @BeforeEach
    public void setUp() {
        manager.add(T1);
        manager.add(T2);
        manager.add(T3);
        manager.add(T4);
        manager.add(T5);
    }

    @Test
    public void shouldFindAll() {
        Ticket[] actual = manager.findAll("SVO", "KUF");
        Ticket[] expected = new Ticket[]{T4, T2};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindNothing() {
        Ticket[] actual = manager.findAll("VKO", "KUF");
        Ticket[] expected = new Ticket[]{};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindOneDirection() {
        Ticket[] actual = manager.findAll("DME", "OGZ");
        Ticket[] expected = new Ticket[]{T3};

        assertArrayEquals(expected, actual);
    }
}