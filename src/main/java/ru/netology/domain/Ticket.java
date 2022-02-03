package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket implements Comparable {
    private int id;
    private int price;
    private String from;
    private String to;
    private int flightTime;

    @Override
    public int compareTo(Object o) {
        Ticket ticket = (Ticket) o;
        return this.price - ticket.price;
    }
}
