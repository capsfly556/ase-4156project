package org.openapitools.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ParticipantTest {

    private Participant participant;
    private UUID participantID;
    private String name;

    @BeforeEach
    void setUp() {
        participantID = UUID.randomUUID();
        name = "John Doe";
        participant = new Participant();
        participant.setParticipantID(participantID);
        participant.setName(name);
    }

    @Test
    void testGetParticipantID() {
        assertEquals(participantID, participant.getParticipantID());
    }

    @Test
    void testSetParticipantID() {
        UUID newID = UUID.randomUUID();
        participant.setParticipantID(newID);
        assertEquals(newID, participant.getParticipantID());
    }

    @Test
    void testGetName() {
        assertEquals(name, participant.getName());
    }

    @Test
    void testSetName() {
        String newName = "Jane Doe";
        participant.setName(newName);
        assertEquals(newName, participant.getName());
    }

    @Test
    void testAddParticipantOrder() {
        ParticipantOrder order = new ParticipantOrder();
        participant.addParticipantOrder(order);

        List<ParticipantOrder> orders = participant.getParticipantOrders();
        assertEquals(1, orders.size());
        assertEquals(order, orders.get(0));
        assertEquals(participant, order.getParticipant());
    }

    @Test
    void testSetParticipantOrders() {
        ParticipantOrder order1 = new ParticipantOrder();
        ParticipantOrder order2 = new ParticipantOrder();

        List<ParticipantOrder> orders = new ArrayList<>();
        orders.add(order1);
        orders.add(order2);

        participant.setParticipantOrders(orders);

        assertEquals(2, participant.getParticipantOrders().size());
        assertEquals(order1, participant.getParticipantOrders().get(0));
        assertEquals(order2, participant.getParticipantOrders().get(1));
    }

    @Test
    void testEquals_SameObject() {
        assertTrue(participant.equals(participant));
    }

    @Test
    void testEquals_DifferentObjectsSameValues() {
        Participant participant2 = new Participant();
        participant2.setParticipantID(participantID);
        participant2.setName(name);
        participant2.setParticipantOrders(new ArrayList<>());

        assertTrue(participant.equals(participant2));
    }

    @Test
    void testEquals_NullObject() {
        assertFalse(participant.equals(null));
    }

    @Test
    void testEquals_DifferentClass() {
        assertFalse(participant.equals(new Object()));
    }

    @Test
    void testEquals_DifferentValues() {
        Participant participant2 = new Participant();
        participant2.setParticipantID(UUID.randomUUID());
        participant2.setName("Different Name");

        assertFalse(participant.equals(participant2));
    }

    @Test
    void testHashCode() {
        Participant participant2 = new Participant();
        participant2.setParticipantID(participantID);
        participant2.setName(name);
        participant2.setParticipantOrders(new ArrayList<>());

        assertEquals(participant.hashCode(), participant2.hashCode());
    }

    @Test
    void testToString() {
        String expected = "class Participant {\n" +
                          "    participantID: " + participantID + "\n" +
                          "    name: " + name + "\n" +
                          "    participantOrders: []\n" +
                          "}";

        assertEquals(expected, participant.toString());
    }
}