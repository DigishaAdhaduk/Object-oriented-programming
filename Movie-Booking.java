class movieBooking{
    private String movieName;
    private int SeatsAvailable;

    public movieBooking(String movieName, int SeatsAvailable) {
        this.movieName = movieName;
        this.SeatsAvailable = SeatsAvailable;
    }

    public String getMovieName() {
        return movieName;
    }

    public int getSeatsAvailable() {
        return SeatsAvailable;
    }

    public void bookTicket(int numberOfSeats) {
        if (numberOfSeats <= SeatsAvailable) {
            SeatsAvailable -= numberOfSeats;
            System.out.println("Successfully booked " + numberOfSeats + " tickets for " + movieName);
        } else {
            System.out.println("Sorry, not enough seats available.");
        }
    }

}
public class movieBookingApp {
    public static void main(String[] args) {
        movieBooking booking = new movieBooking("Inception", 100);
        System.out.println("Movie: " + booking.getMovieName()); // Output: Movie: Inception
        System.out.println("Seats Available: " + booking.getSeatsAvailable()); // Output: Seats Available: 100

        booking.bookTicket(5); // Output: Successfully booked 5 tickets for Inception
        System.out.println("Seats Available after booking: " + booking.getSeatsAvailable());// Output: Seats Available after booking: 95

        booking.bookTicket(200); // Output: Sorry, not enough seats available.
    }
}
