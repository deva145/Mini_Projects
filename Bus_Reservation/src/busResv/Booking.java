package busResv;

import java.util.Date;
import java.util.ArrayList;

public class Booking {
    String passengerName;
    int busNO;
    Date date;

    public Booking(String passengerName, int busNO, Date date) {
        this.passengerName = passengerName;
        this.busNO = busNO;
        this.date = date;
    }

    public boolean isAvailable(ArrayList<Booking> bookings, ArrayList<Bus> buses) {

        int capacity = 0;

        for (Bus bus : buses) {
            if (bus.getBusNo() == busNO) {
                capacity = bus.getCapacity();
            }
        }

        int booked = 0;

        for (Booking b : bookings) {
            if (b.busNO == busNO && b.date.equals(date)) {
                booked++;
            }
        }

        return booked < capacity;
    }
}
