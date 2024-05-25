import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;


class Flight{
    ArrayList<String> passengerId ;
    ArrayList<String> passagersNames;
    ArrayList<Integer> numberOfTickets;
    int price = 2000;
    int i = 1;
    public Flight(){
        passengerId = new ArrayList<>();
        passagersNames = new ArrayList<>();
        numberOfTickets = new ArrayList<>();
    }
    public void addPassangerAndNumberOfTickets(String passangerName,int numeberOfTicketsBooked){
        passagersNames.add(passangerName);
        numberOfTickets.add(numeberOfTicketsBooked);
    }
    public StringBuilder passangerIdGenration(){
        StringBuilder passngerId = new StringBuilder("AA");
        int middleIndex = passngerId.length()/2;
        passngerId.insert(middleIndex,i);
        i++;
        return passngerId;
    }
    public int priceCalculation(int numberOfTicketsBooked){
        int totalPriceForBookedTickets = price * numberOfTicketsBooked;
        price = price + numberOfTicketsBooked*200;
        return totalPriceForBookedTickets;
    }
    public void ticketsCancellation(String passagnerNameString){
        int indexOfPassanger = passagersNames.indexOf(passagnerNameString);
        passagersNames.remove(indexOfPassanger);
        // numberOfTickets.remove(indexOfPassanger);
        price = price - numberOfTickets.get(indexOfPassanger)*200;
    }
    public void getPassangerDetails(){
        for(int i = 0;i < passagersNames.size();i++){
            System.out.println(passagersNames.get(i));
        }
        System.out.println();
    }
}
public class FlightTicketReservationSystem{
    public static void main(String[] args) throws Exception {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        Scanner scanner = new Scanner(System.in);

        Flight f = new Flight();
        Boolean loop = true;
        while (loop) {
            System.out.println("Enter your choice");
            System.out.println("***** Enter 1 for ticket booking *****\n***** Enter 2 for cancellation ***** \n***** Enter 3 for Get passenger details *****\n***** Enter 4 for exit *****");
            int choice = Integer.parseInt(br.readLine());
            switch (choice) {
                case 1: System.out.println("welcome to MyAirLines");
                        System.out.println("Please Enter your name to proceed further");
                        String passangerName = br.readLine();
                        System.out.println("Enter number of tickets you want to book");
                        int numberOfTickets = Integer.parseInt(br.readLine());
                        StringBuilder passangerIdString = passangerId(f);
                        addPassanger(f, passangerName, numberOfTickets);
                        int totaCost = priceCalculation(f, numberOfTickets);
                        System.out.println("Thank you "+passangerName+"!! your Bokking ID is "+passangerIdString);
                        System.out.println("Your total booking cost is :"+totaCost);
                        System.out.println("Thanks for booking, have a fun journey!!!");
                    
                    break;
                case 2: System.out.println("Please enter the passanger name at the time of booking");
                        String passangerNameString = br.readLine();
                        ticketsCancellation(f, passangerNameString);
                        System.out.println("Thank you "+passangerNameString+"!!!, your cancellation is successfully completed!");
                        System.out.println("Your amount will be refunded shortly, Thank you!!!");
                    
                    break;
                case 3: System.out.println("Here is passanger list still be there!!!");
                        getAllpassangerList(f);
                    break;
                case 4: loop = false;
                    break;

                default: System.out.println("Enterd wrong choice");
                    break;
            }
        }
    }
    public static void addPassanger(Flight f,String passangerName, int numeberOfTicketsBooked){
        f.addPassangerAndNumberOfTickets(passangerName, numeberOfTicketsBooked);
    }
    public static int priceCalculation(Flight f,int numeberOfTicketsBooked){
        int totalPriceForBookedTickets = f.priceCalculation(numeberOfTicketsBooked);
        return totalPriceForBookedTickets;
    }
    public static StringBuilder passangerId(Flight f){
        StringBuilder passangerIdString = f.passangerIdGenration();
        return passangerIdString;
    }
    public static void ticketsCancellation(Flight f,String passangerNameString){
        f.ticketsCancellation(passangerNameString);
    }
    public static void getAllpassangerList(Flight f){
        f.getPassangerDetails();
    }
}