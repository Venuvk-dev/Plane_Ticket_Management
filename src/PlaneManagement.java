import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PlaneManagement {
    static Scanner input = new Scanner(System.in); //creating Scanner as scope
    static char rowLetter; //variable for getting input to row Letter
    static int seatNumber; //variable for getting input to seat number
    static char reSelect; // variable for getting input whether the user want to continue to the menu or not
    static int [] a_seats=new int[14]; // Array created for accessing the seats of row A
    static int [] b_seats=new int[12]; // Array created for accessing the seats of row B
    static int [] c_seats=new int[12]; // Array created for accessing the seats of row C
    static int [] d_seats=new int[14]; // Array created for accessing the seats of row D
    static int[] index_row;  //A common array for assigning all rows which will be given by the user
    static int index_seat; // A common integer for assigning all seats which will be given by the user
    static String input_name; // Variable for asking user's name to throw as a parameter for constructor
    static String input_surname;  // Variable for asking user's surname to throw as a parameter for constructor
    static String input_email; // Variable for asking user's email to throw as a parameter for constructor
    static int ticket_count=0; // variable for counting number of seats purchased
    static int price=0; // Variable to calculate the total sales of purchased
    static Ticket[] array_of_tickets=new Ticket[52]; // An array for storing the details of the person using Class Person and Ticket
    static int priceOfTicket; // Variable for show the price of a single ticket



    public static void seat_diagram(){
        System.out.println("""
                —————————————————————————————————————————————————————————————————
                ⁕                 VIEW OF THE SEATS DISPLAY                     ⁕
                —————————————————————————————————————————————————————————————————""");
        System.out.print("A: ");
        for (int element_a:a_seats){
            System.out.print(element_a+" ");
        }
        System.out.println(" ");

        System.out.print("B: ");
        for (int element_b:b_seats){
            System.out.print(element_b+" ");
        }
        System.out.println(" ");

        System.out.print("C: ");
        for (int element_c:c_seats) {
            System.out.print(element_c + " ");
        }
        System.out.println(" ");

        System.out.print("D: ");
        for (int element_d:d_seats){
            System.out.print(element_d+" ");
        }
        System.out.println(" ");
        System.out.println("""
                —————————————————————————————————————————————————————————————————""");
    }
    public static void userMenu(){
        while (true) {
            System.out.println("\n            WELCOME TO THE PLANE MANAGEMENT APPLICATION");
            System.out.println("\n*****************************************************************");
            System.out.println("*                     MENU OPTIONS                              *");
            System.out.println("*****************************************************************");
            System.out.println("1) BUY A SEAT");
            System.out.println("2) CANCEL A SEAT");
            System.out.println("3) FIND FIRST AVAILABLE SEAT");
            System.out.println("4) SHOW SEATING PLAN");
            System.out.println("5) PRINT TICKET INFORMATION AND TOTAL SALES");
            System.out.println("6) SEARCH SEAT");
            System.out.println("0) QUIT");
            System.out.println("*****************************************************************");
            System.out.println("Please select an option:");
            try {
                int choosingOption = input.nextInt(); //Asking input for Option that the user want

                if (choosingOption == 1) {
                    System.out.println("\n");
                    System.out.println("""
                —————————————————————————————————————————————————————————————————
                ⁕                     WELCOME TO BUY SEATS                      ⁕
                —————————————————————————————————————————————————————————————————
                            """);
                    buy_seat();
                    break;
                } else if (choosingOption == 2) {
                    System.out.println("\n");
                    System.out.println("""
                —————————————————————————————————————————————————————————————————
                ⁕                     WELCOME TO CANCEL SEATS                   ⁕
                —————————————————————————————————————————————————————————————————
                            """);
                    cancel_seat();
                    break;
                } else if (choosingOption == 3) {
                    System.out.println("\n");
                    System.out.println("""
                —————————————————————————————————————————————————————————————————
                ⁕                 WELCOME TO FIRST AVAILABLE SEATS              ⁕
                —————————————————————————————————————————————————————————————————
                            """);
                    first_find_available();
                    break;
                } else if (choosingOption == 4) {
                    System.out.println("\n");
                    System.out.println("""
                —————————————————————————————————————————————————————————————————
                ⁕                      VIEW OF THE SEATS                        ⁕
                —————————————————————————————————————————————————————————————————
                            """);
                    show_seating_plan();
                    break;
                } else if (choosingOption == 5) {
                    System.out.println("\n");
                    System.out.println("""
                —————————————————————————————————————————————————————————————————
                ⁕                     TICKET INFORMATION                        ⁕
                —————————————————————————————————————————————————————————————————
                            """);
                    print_tickets_info();
                    break;
                } else if (choosingOption == 6) {
                    System.out.println("\n");
                    System.out.println("""
                —————————————————————————————————————————————————————————————————
                ⁕                        SEARCH TICKETS                         ⁕
                —————————————————————————————————————————————————————————————————
                            """);
                    search_ticket();
                    break;
                } else if (choosingOption == 0) {
                    System.out.println("\n");
                    quit();

                    break;
                }
                else {
                    System.out.println("Enter the Correct number from the Menu");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nSelect the correct option");
                input.nextLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void buy_seat() throws IOException {
        while (true) {
            try {
                System.out.println("Enter the correct Row letter such as 'A' or 'B' or 'C' or 'D' ");
                rowLetter = input.next().charAt(0);
                if (rowLetter == 'A' || rowLetter == 'a') {
                    index_row = a_seats;
                    break;
                }
                if (rowLetter == 'B' || rowLetter == 'b') {
                    index_row = b_seats;
                    break;
                }
                if (rowLetter == 'C' || rowLetter == 'c') {
                    index_row = c_seats;
                    break;
                }
                if (rowLetter == 'D' || rowLetter == 'd') {
                    index_row = d_seats;
                    break;

                } else {
                    buy_seat();
                }

            } catch (InputMismatchException e) {
                System.out.println("INCORRECT INPUT");
                input.nextLine();
            }
        }

        while(true){
            try{
                System.out.println("Enter the seat number:");
                seatNumber=input.nextInt();
                if (rowLetter=='a' || rowLetter=='A' ){
                    if (seatNumber>=1 && seatNumber<=14){
                        index_seat=seatNumber-1;
                        break;
                    }
                    else {
                        System.out.println("Invalid Seat number for the row");
                    }
                }

                if (rowLetter=='b' || rowLetter=='B' ){
                    if (seatNumber>=1 && seatNumber <=12){
                        index_seat = seatNumber - 1;
                        break;
                    }
                    else {
                        System.out.println("Invalid seat number for the row");
                    }
                }
                if (rowLetter=='c' || rowLetter=='C'){
                    if (seatNumber>=1 && seatNumber<=12){
                        index_seat=seatNumber-1;
                        break;
                    }
                    else {
                        System.out.println("Invalid Seat number for the row");
                    }
                }
                if (rowLetter=='d' || rowLetter=='D'){
                    if (seatNumber>=1 && seatNumber<=14){
                        index_seat=seatNumber-1;
                        break;
                    }
                    else {
                        System.out.println("Invalid Seat number for the row");
                    }
                }
            }catch (InputMismatchException e){
                System.out.println("Entered invalid input,\nPlease Try again with the number\n");
                input.nextLine();
            }
        }
        if (index_row[index_seat]==0){
        index_row[index_seat]=1;

            System.out.println("\n");

            System.out.println("Enter the passenger's name: ");
            input_name=input.next();

            System.out.println("Enter the passenger's Surname: ");
            input_surname=input.next();

            System.out.println("Enter passenger's Email: ");
            input_email=input.next();
            System.out.println("The booking has been successfully done by you. THANK YOU\n");
            if (seatNumber>=1 && seatNumber<=5){
                priceOfTicket=200;
                price=price+200;
            }
            else if (seatNumber>=6 && seatNumber<=9) {
                priceOfTicket=150;
                price = price + 150;
            }
            else {
                priceOfTicket=180;
                price=price+180;
            }

            Person person=new Person(input_name,input_surname,input_email);
            Ticket ticket=new Ticket(String.valueOf(rowLetter).toUpperCase(),seatNumber,priceOfTicket,person);

            array_of_tickets[ticket_count++]= ticket;
            ticket.save();






        }
        else {
            System.out.println("Seat is not Available, TRY AGAIN");
            buy_seat();
        }


        loopingToMenu();



    }

    public static void cancel_seat(){
        while (true) {
            try {
                System.out.println("Enter the correct Row letter such as 'A' or 'B' or 'C' or 'D' ");
                rowLetter =input.next().charAt(0);
                System.out.println("Enter the passenger's name: ");
                input_name=input.next();

                System.out.println("Enter the passenger's Surname: ");
                input_surname=input.next();

                System.out.println("Enter passenger's Email: ");
                input_email=input.next();
                if (rowLetter == 'A' || rowLetter == 'a' ) {
                    index_row=a_seats;
                    break;
                }
                if (rowLetter == 'B' || rowLetter == 'b' ) {
                    index_row=b_seats;
                    break;
                }
                if (rowLetter == 'C' || rowLetter == 'c' ) {
                    index_row=c_seats;
                    break;
                }
                if (rowLetter == 'D' || rowLetter == 'd' ) {
                    index_row=d_seats;
                    break;

                }

            }
            catch (InputMismatchException e){
                System.out.println("INCORRECT INPUT");
                input.nextLine();
            }
        }
        while(true){
            try{
                System.out.println("Enter the seat number:");
                seatNumber=input.nextInt();
                if (rowLetter=='a' || rowLetter=='A' ){
                    if (seatNumber>=1 && seatNumber<=14){
                        index_seat=seatNumber-1;
                        break;
                    }
                    else {
                        System.out.println("Invalid Seat number for the row");
                    }
                }

                if (rowLetter=='b' || rowLetter=='B' ){
                    if (seatNumber>=1 && seatNumber <=12){
                        index_seat = seatNumber - 1;
                        break;
                    }
                    else {
                        System.out.println("Invalid seat number for the row");
                    }
                }
                if (rowLetter=='c' || rowLetter=='C'){
                    if (seatNumber>=1 && seatNumber<=12){
                        index_seat=seatNumber-1;
                        break;
                    }
                    else {
                        System.out.println("Invalid Seat number for the row");
                    }
                }
                if (rowLetter=='d' || rowLetter=='D'){
                    if (seatNumber>=1 && seatNumber<=14){
                        index_seat=seatNumber-1;
                        break;
                    }
                    else {
                        System.out.println("Invalid Seat number for the row");
                    }
                }
            }catch (InputMismatchException e){
                System.out.println("Entered invalid input,\nPlease Try again with the number\n");
                input.nextLine();
            }
        }
        if (index_row[index_seat]==1){

            if (seatNumber>=1 && seatNumber<=5){
                price=price-200;
            }
            else if (seatNumber>=6 && seatNumber<=9) {
                price = price - 150;
            }
            else {
                price=price-180;
            }
            for (int i=0;i<ticket_count;i++){
                Ticket ticket=array_of_tickets[i];
                if (ticket.getPerson().getName().equalsIgnoreCase(input_name)&&
                ticket.getPerson().getSurname().equalsIgnoreCase(input_surname)&&
                ticket.getPerson().getEmail().equalsIgnoreCase(input_email)&&
                ticket.getRow().equalsIgnoreCase(String.valueOf(rowLetter))&&
                ticket.getSeat()==seatNumber)
                {
                    for (int j=i;j<ticket_count-1;j++){
                        array_of_tickets[j]=array_of_tickets[j+1];
                    }
                    ticket_count--;
                    System.out.println("The reservation has been successfully cancelled. THANK YOU\n ");
                    index_row[index_seat]=0;

                }
                else {
                    System.out.println("Given Information is Wrong");
                }
            }




        }
        else {
            System.out.println("The Seat has not been booked yet to Cancel the Reservation");
        }
        loopingToMenu();



    }

    public static void first_find_available(){
        int i;
        for (i=0;i<a_seats.length;i++){
            if (a_seats[i]==0){
                System.out.println("The first  available seat is"+" A"+(i+1));
                break;
            }
            else if (i==14){
                for (int j=0;j<b_seats.length;j++){
                    if (b_seats[j]==0) {
                        System.out.println("The first  available seat is" + " B" + (j + 1));
                        break;
                    }

                    else if (j==12){
                        for (int k=0;k<c_seats.length;k++) {
                            if (c_seats[k] == 0) {
                                System.out.println("The first  available seat is" + " C" + (k + 1));
                                break;

                            } else if (k == 12)
                                for (int dSeat : d_seats) {
                                    if (dSeat == 0) {
                                        System.out.println("The first  available seat is" + " C" + (dSeat + 1));
                                        break;
                                    }

                                }
                        }
                    }
                }
            }

        }
        loopingToMenu();
    }

    public static void show_seating_plan() {
//        seat_diagram();
        System.out.print("A : ");       //Seating plan of A
        for (int plan_a:a_seats){
            if (plan_a==0){
                System.out.print("0"+" ");
            }
            else {
                System.out.print("X"+" ");
            }
        }
        System.out.println(" ");      //Seating Plan of B
        System.out.print("B : ");
        for (int plan_b:b_seats){
            if (plan_b==0){
                System.out.print("0"+" ");
            }
            else {
                System.out.print("X"+" ");
            }
        }
        System.out.println(" ");     //Seating Plan of C
        System.out.print("C : ");
        for (int plan_c:c_seats){
            if (plan_c==0){
                System.out.print("0"+" ");
            }
            else {
                System.out.print("X"+" ");
            }
        }
        System.out.println(" ");     //Seating Plan of D
        System.out.print("D : ");
        for (int plan_d:d_seats){
            if (plan_d==0){
                System.out.print("0"+" ");
            }
            else {
                System.out.print("X"+" ");
            }
        }
        System.out.println("\n");
        loopingToMenu();
    }
    public static void print_tickets_info(){
        for (int i=0;i<ticket_count;i++){
            Ticket ticket=array_of_tickets[i];
            Person person=ticket.getPerson();
            ticket.printing();


        }
        System.out.println("Total Sales is "+price);
        loopingToMenu();
    }

    public static void search_ticket(){
        while (true) {
            try {
                System.out.println("Enter the  Row letter such as 'A' or 'B' or 'C' or 'D' to Search");
                rowLetter =input.next().charAt(0); //Getting input for Row
                if (rowLetter == 'A' || rowLetter == 'a' ) {
                    index_row=a_seats;
                    break;
                }
                if (rowLetter == 'B' || rowLetter == 'b' ) {
                    index_row=b_seats;
                    break;
                }
                if (rowLetter == 'C' || rowLetter == 'c' ) {
                    index_row=c_seats;
                    break;
                }
                if (rowLetter == 'D' || rowLetter == 'd' ) {
                    index_row=d_seats;
                    break;

                }

            }
            catch (InputMismatchException e){
                System.out.println("INCORRECT INPUT");
                input.nextLine();
            }
        }
        while(true){
            try{
                System.out.println("Enter the seat number:");
                seatNumber=input.nextInt();  // Getting input for the seat number
                if (rowLetter=='a' || rowLetter=='A' ){
                    if (seatNumber>=1 && seatNumber<=14){
                        break;
                    }
                    else {
                        System.out.println("Invalid Seat number for the row");
                    }
                }

                if (rowLetter=='b' || rowLetter=='B' ){
                    if (seatNumber>=1 && seatNumber <=12){
                        break;
                    }
                    else {
                        System.out.println("Invalid seat number for the row");
                    }
                }
                if (rowLetter=='c' || rowLetter=='C'){
                    if (seatNumber>=1 && seatNumber<=12){
                        break;
                    }
                    else {
                        System.out.println("Invalid Seat number for the row");
                    }
                }
                if (rowLetter=='d' || rowLetter=='D'){
                    if (seatNumber>=1 && seatNumber<=14){
                        break;
                    }
                    else {
                        System.out.println("Invalid Seat number for the row");
                    }
                }
            }catch (InputMismatchException e){
                System.out.println("Entered invalid input,\nPlease Try again with the number\n");
                input.nextLine();
            }
        }

        if (index_row[index_seat]==1) {
            for (int i = 0; i < ticket_count; i++) {
                Ticket ticket = array_of_tickets[i];
                if (ticket.getRow().equalsIgnoreCase(String.valueOf(rowLetter))
                && ticket.getSeat()==seatNumber){
                    ticket.getPerson().printing();
                    System.out.println("Seat Details:"+ticket.getRow()+ticket.getSeat());
                }

            }
        }
        else {
            System.out.println("The seat is still available ");
        }

        loopingToMenu();
    }

    public static void loopingToMenu(){
        System.out.println("""
                —————————————————————————————————————————————————————————————————
                            """);
        System.out.println("To Go For the Main Menu press 'Y' else press 'N'" + " : ");
        reSelect=input.next().charAt(0);  // Asking the user for the input for what the user want after
        if (reSelect=='y'||reSelect=='Y'){
            userMenu(); // calling Method userMenu()
        }
        else if (reSelect=='n' || reSelect=='N'){
            System.out.println("""
                    Are you really want to exit from the System ?
                    If 'YES' press 'Y' or 'PRESS ANYTHING'
                    """);
            reSelect=input.next().charAt(0);
            if (reSelect=='y'||reSelect=='Y'){
                quit(); // Calling Method quit
            }
            else {
                userMenu();
            }


        }
        else {
            System.out.println("Incorrect input");
            loopingToMenu();
        }
    }

    public static void quit(){
        System.out.println("Thank you for using our Ticket Booking System ! Have a great day ");
        System.out.println("""
                ⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂⁂
                            """);
    }

    public static void main(String[] args) {
        System.out.println("\n");

        seat_diagram();

        userMenu();

    }
}
