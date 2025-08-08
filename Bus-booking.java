class bus{
    private String busName;
    private int seatsAvailable;
    private String route;
    private String departureTime;
    private String arrivalTime;
    private double ticketPrice;
    private String busType;
    private String busNumber;

    public bus(String busName, int seatsAvailable, String route, String departureTime, String arrivalTime, double ticketPrice, String busType, String busNumber) {
        this.busName = busName;
        this.seatsAvailable = seatsAvailable;
        this.route = route;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.ticketPrice = ticketPrice;
        this.busType = busType;
        this.busNumber = busNumber;
    }   

    public String getBusName() {
        return busName;
    }
    public int getSeatsAvailable() {
        return seatsAvailable;
    }
    public String getRoute() {
        return route;
    }
    public String getDepartureTime() {
        return departureTime;
    }
    public String getArrivalTime() {
        return arrivalTime;
    }
    public double getTicketPrice() {
        return ticketPrice;
    }
    public String getBusType() {
        return busType;
    }
    public String getBusNumber() {
        return busNumber;
    }
    public void bookTicket(int numberOfSeats){
        if (numberOfSeats <= seatsAvailable){
            seatsAvailable -= numberOfSeats;
            System.out.println("Successfully booked " + numberOfSeats + " tickets for " + busName);
            System.out.println("Remaining seats: " + seatsAvailable);
        } else {
            System.out.println("Sorry, not enough seats available.");
        }
    }
    public void cancelTicket(int numberOfSeats) {
        seatsAvailable += numberOfSeats;
        System.out.println("Successfully cancelled " + numberOfSeats + " tickets for " + busName);
        System.out.println("Available seats after cancellation: " + seatsAvailable);
    }
    public void displayBusDetails() {
        System.out.println("Bus Name: " + busName);         
    }
    public void displayRouteDetails() {
        System.out.println("Route: " + route);
        System.out.println("Departure Time: " + departureTime);
        System.out.println("Arrival Time: " + arrivalTime);
    }
    public void displayTicketPrice(int numberOfSeats) {
        System.out.println("Ticket Price: " + numberOfSeats * ticketPrice);
    }
    public void displayBusType() {
        System.out.println("Bus Type: " + busType);
    }
    public void displayBusNumber() {
        System.out.println("Bus Number: " + busNumber);
    }    
    public void displaySeatsAvailable() {
        System.out.println("Seats Available: " + seatsAvailable);
    }
}


public class busBookingApp {
    public static void main(String[] args) {
        bus myBus = new bus("Eagle Express", 50, "Rajkot to Vadodara", "08:00 AM", "10:00 AM", 15.0, "Volvo", "CE123");
        
        myBus.displayBusDetails();
        myBus.displayRouteDetails();
        myBus.displayTicketPrice(2);
        myBus.displayBusType();
        myBus.displayBusNumber();
        myBus.displaySeatsAvailable();

        myBus.bookTicket(5);
        myBus.cancelTicket(2);
        myBus.displaySeatsAvailable();
    }    
}
