import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Passenger {
    private String name;
    private int age;
    private String contactNumber;

    public Passenger(String name, int age, String contactNumber) {
        this.name = name;
        this.age = age;
        this.contactNumber = contactNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}

abstract class Ticket {
    private Passenger passenger;
    private String departure;
    private String arrival;
    private double price;

    public Ticket(Passenger passenger, String departure, String arrival, double price) {
        this.passenger = passenger;
        this.departure = departure;
        this.arrival = arrival;
        this.price = price;
    }

    public abstract void displayTicketDetails();

    public Passenger getPassenger() {
        return passenger;
    }

    public String getDeparture() {
        return departure;
    }

    public String getArrival() {
        return arrival;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

class BusinessClassTicket extends Ticket {
    private String specialService;

    public BusinessClassTicket(Passenger passenger, String departure, String arrival, double price, String specialService) {
        super(passenger, departure, arrival, price);
        this.specialService = specialService;
    }

    public void displayTicketDetails() {
        System.out.println("\n---VANNI EMIRATES AIRLINES---\n");
        System.out.println("--Vanni - Airlines Ticket Booking System--\n");
        System.out.println("1. Book a Ticket");
        System.out.println("2. View Passengers on a Flight");
        System.out.println("3. Calculate Revenue");
        System.out.println("4. Change a Ticket");
        System.out.println("5. Cancel and Refund a Ticket");
        System.out.println("6. Exit");
        System.out.println("\nYour Booked Ticket Details:\n");
        System.out.println("Name: " + getPassenger().getName());
        System.out.println("Age: " + getPassenger().getAge());
        System.out.println("Contact Number: " + getPassenger().getContactNumber());
        System.out.println("Departure: " + getDeparture());
        System.out.println("Arrival: " + getArrival());
        System.out.println("Price: " + getPrice());
        System.out.println("Special Service: " + specialService);
        System.out.println("Thanks for choosing Vanni Emirates Airlines!");
    }
}

class NormalClassTicket extends Ticket {
    public NormalClassTicket(Passenger passenger, String departure, String arrival, double price) {
        super(passenger, departure, arrival, price);
    }

    public void displayTicketDetails() {
        System.out.println("\n---VANNI EMIRATES AIRLINES---\n");
        System.out.println("--Vanni - Airlines Ticket Booking System--\n");
        System.out.println("1. Book a Ticket");
        System.out.println("2. View Passengers on a Flight");
        System.out.println("3. Calculate Revenue");
        System.out.println("4. Change a Ticket");
        System.out.println("5. Cancel and Refund a Ticket");
        System.out.println("6. Exit");
        System.out.println("\nYour Ticket Details:\n");
        System.out.println("Name: " + getPassenger().getName());
        System.out.println("Age: " + getPassenger().getAge());
        System.out.println("Contact Number: " + getPassenger().getContactNumber());
        System.out.println("Departure: " + getDeparture());
        System.out.println("Arrival: " + getArrival());
        System.out.println("Price: " + getPrice());
        System.out.println("Thanks for choosing Vanni Emirates Airlines!");
    }
}

public class TicketApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Ticket> tickets = new ArrayList<>();

        while (true) {
            System.out.println("\n---Vanni Emirates Airlines ---\n");
            System.out.println("--Vanni - Airlines Ticket Booking System--\n");
            System.out.println("1. Book a Ticket");
            System.out.println("2. View Passengers on a Flight");
            System.out.println("3. Calculate Revenue");
            System.out.println("4. Change a Ticket");
            System.out.println("5. Cancel and Refund a Ticket");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    // Book a ticket
                    System.out.println("Enter passenger name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter passenger age: ");
                    int age = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter contact number: ");
                    String contactNumber = scanner.nextLine();
                    Passenger passenger = new Passenger(name, age, contactNumber);

                    System.out.println("Enter departure: ");
                    String departure = scanner.nextLine();
                    System.out.println("Enter arrival: ");
                    String arrival = scanner.nextLine();
                    System.out.println("Enter price: ");
                    double price = Double.parseDouble(scanner.nextLine());

                    System.out.println("Select ticket type:");
                    System.out.println("1. Business Class");
                    System.out.println("2. Economy Class");
                    int ticketChoice = Integer.parseInt(scanner.nextLine());

                    Ticket ticket;

                    if (ticketChoice == 1) {
                        System.out.println("Enter special service: ");
                        String specialService = scanner.nextLine();
                        ticket = new BusinessClassTicket(passenger, departure, arrival, price, specialService);
                        System.out.println("Awesome!! You have choosed Business Class");
                    } else if (ticketChoice == 2) {
                        ticket = new NormalClassTicket(passenger, departure, arrival, price);
                        System.out.println("Congratulations!! You have choosed Economy Class");
                    } else {
                        System.out.println("Invalid choice. Exiting...");
                        return;
                    }

                    tickets.add(ticket);
                    break;

                case 2:
                    // View passengers on a flight
                    System.out.println("View passengers on a flight");
                    for (Ticket t : tickets) {
                        t.displayTicketDetails();
                    }
                    break;

                case 3:
                    // Calculate revenue
                    System.out.println("Calculate revenue");
                    double revenue = 0.0;
                    for (Ticket t : tickets) {
                        revenue += t.getPrice();
                    }
                    System.out.println("Total revenue: $" + revenue);
                    break;

                case 4:
                    // Change a ticket
                    System.out.println("Change a ticket");
                    if (tickets.isEmpty()) {
                        System.out.println("No tickets to change.");
                    } else {
                        System.out.println("Enter passenger name to change the ticket: ");
                        String passengerNameToChange = scanner.nextLine();

                        boolean ticketFound = false;
                        for (Ticket t : tickets) {
                            if (t.getPassenger().getName().equalsIgnoreCase(passengerNameToChange)) {
                                System.out.println("Enter new departure: ");
                                String newDeparture = scanner.nextLine();
                                System.out.println("Enter new arrival: ");
                                String newArrival = scanner.nextLine();
                                System.out.println("Enter new price: ");
                                double newPrice = Double.parseDouble(scanner.nextLine());

                                t.getPassenger().setName(newDeparture);
                                t.getPassenger().setContactNumber(newArrival);
                                t.setPrice(newPrice);
                                System.out.println("Ticket changed.");
                                ticketFound = true;
                                break;
                            }
                        }

                        if (!ticketFound) {
                            System.out.println("No matching ticket found for the passenger name.");
                        }
                    }
                    break;

                case 5:
                    // Cancel and refund a ticket
                    System.out.println("Cancel and refund a ticket");
                    if (tickets.isEmpty()) {
                        System.out.println("No tickets to cancel and refund.");
                    } else {
                        System.out.println("Enter passenger name to cancel and refund the ticket: ");
                        String passengerNameToCancelAndRefund = scanner.nextLine();

                        boolean ticketFound = false;
                        for (int i = 0; i < tickets.size(); i++) {
                            if (tickets.get(i).getPassenger().getName().equalsIgnoreCase(passengerNameToCancelAndRefund)) {
                                double refundAmount = tickets.get(i).getPrice();
                                tickets.remove(i);
                                System.out.println("Ticket canceled and refunded Successfully. Refund amount: $" + refundAmount);
                                ticketFound = true;
                                break;
                            }
                        }

                        if (!ticketFound) {
                            System.out.println("No matching ticket found for the passenger name.");
                        }
                    }
                    break;

                case 6:
                    System.out.println("Thank-you choosing --VANNI EMIRATES AIRLINES-- and have a nice day!");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            
            System.out.println("Do you want to continue? (1: Yes, 2: No)");
            int continueChoice = Integer.parseInt(scanner.nextLine());
            if (continueChoice != 1) {
                System.out.println("Thank-you choosing --VANNI EMIRATES AIRLINES-- and have a nice day!");
                return;
            }
        }
    }
}
