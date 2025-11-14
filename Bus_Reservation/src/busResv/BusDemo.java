package busResv;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class BusDemo {
    public static void main(String[] args) {

        ArrayList<Bus> buses = new ArrayList<>();
        ArrayList<Booking> bookings = new ArrayList<>();

        buses.add(new Bus(1, true, 29));
        buses.add(new Bus(2, false, 40));
        buses.add(new Bus(3, true, 48));

        Scanner scan = new Scanner(System.in);

        for (Bus b : buses) {
            b.displayBusInfo();
        }

        int userOpt = 1;

        while (userOpt == 1) {

            System.out.println("Enter 1 to Book and 2 to Exit:");

            while (!scan.hasNextInt()) {
                System.out.println("Invalid input! Enter 1 or 2:");
                scan.next();
            }
            userOpt = scan.nextInt();

            if (userOpt == 1) {

                System.out.println("Enter passenger name:");
                String name = scan.next();

                int busNo = 0;
                boolean validBus = false;
                while (!validBus) {
                    System.out.println("Enter bus number (1, 2, or 3):");

                    while (!scan.hasNextInt()) {
                        System.out.println("Invalid! Enter a valid bus number (1, 2, 3):");
                        scan.next();
                    }

                    busNo = scan.nextInt();

                    for (Bus b : buses) {
                        if (b.getBusNo() == busNo) {
                            validBus = true;
                            break;
                        }
                    }

                    if (!validBus) {
                        System.out.println("Bus not found! Enter correct bus number.");
                    }
                }

                Date date = null;
                SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                df.setLenient(false);

                boolean validDate = false;

                while (!validDate) {
                    System.out.println("Enter date (dd-MM-yyyy):");
                    String dateInput = scan.next();

                    try {
                        date = df.parse(dateInput);
                        validDate = true;
                    } catch (ParseException e) {
                        System.out.println("Invalid date format! Try again:");
                    }
                }

                Booking booking = new Booking(name, busNo, date);

                if (booking.isAvailable(bookings, buses)) {
                    bookings.add(booking);
                    System.out.println("Your booking is confirmed!");
                } else {
                    System.out.println("Sorry. Bus is full. Try another bus or date.");
                }
            }
        }
    }
}
