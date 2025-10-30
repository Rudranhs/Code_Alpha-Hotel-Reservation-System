import java.util.*;

public class Main {

    static class Room {
        int roomNo;
        boolean isBooked;

        Room(int roomNo) {
            this.roomNo = roomNo;
            this.isBooked = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Room[] rooms = new Room[5];

        for (int i = 0; i < rooms.length; i++) {
            rooms[i] = new Room(i + 1);
        }

        boolean running = true;

        while (running) {
            System.out.println("\n===== HOTEL RESERVATION SYSTEM =====");
            System.out.println("1. Book a Room");
            System.out.println("2. Cancel Booking");
            System.out.println("3. View All Rooms");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter room number to book (1-5): ");
                    int bookNo = sc.nextInt();
                    if (bookNo >= 1 && bookNo <= 5) {
                        if (!rooms[bookNo - 1].isBooked) {
                            rooms[bookNo - 1].isBooked = true;
                            System.out.println("Room " + bookNo + " booked successfully!");
                        } else {
                            System.out.println("Room " + bookNo + " is already booked!");
                        }
                    } else {
                        System.out.println("Invalid room number!");
                    }
                    break;

                case 2:
                    System.out.print("Enter room number to cancel booking: ");
                    int cancelNo = sc.nextInt();
                    boolean cancelled = false;

                    for (Room room : rooms) {
                        if (room.roomNo == cancelNo) {
                            if (room.isBooked) {
                                room.isBooked = false;
                                System.out.println("Booking for Room " + cancelNo + " cancelled successfully.");
                                cancelled = true;
                            } else {
                                System.out.println("Room " + cancelNo + " was not booked.");
                                cancelled = true;
                            }
                            break;
                        }
                    }

                    if (!cancelled) {
                        System.out.println("No booking found for that room number.");
                    }
                    break;

                case 3:
                    System.out.println("\nRoom Status:");
                    for (Room room : rooms) {
                        System.out.println("Room " + room.roomNo + " - " + (room.isBooked ? "Booked" : "Available"));
                    }
                    break;

                case 4:
                    System.out.println("Exiting the system... Thank you!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }

        sc.close();
    }
}
