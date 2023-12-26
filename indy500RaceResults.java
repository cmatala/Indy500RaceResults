import java.util.Scanner;
import java.util.Random;

public class Indy500RaceResults {
    // Static variable to keep track of the number of racers
    static int numberOfRacers = 0;
    // Instance variables
    public String racerFirstName;
    public String racerLastName;
    public int racerNumber;
    public int numberOfLaps;
    private String vehicleMaker;
    public double miles;
    public double baseWinnings;
    public double bonus;
    public double netWinnings;

    // Constant variables

    public static final double LAP_DISTANCE = 2.5;
    public static final int FULL_RACE_BONUS_LAPS = 200;
    public static final double EARNINGS_PER_LAP = 21.77;
    public static final double ENTRY_FEE_PER_RACER = 300.00;


    public Indy500RaceResults() {
        // Default constructor initializes the number of racers
        numberOfRacers++;
    }

    public void inputRacerInfo() {
        Scanner scanner = new Scanner(System.in);

        // Ask for and assign racer's first name
        System.out.print("Please enter the racer's first name: ");
        this.racerFirstName = scanner.nextLine().toLowerCase();

        // Ask for and assign racer's last name
        System.out.print("Please enter the racer's last name: ");
        this.racerLastName = scanner.nextLine().toLowerCase();

        // Ask for and assign number of laps completed
        System.out.print("Please enter the number of laps completed: ");
        this.numberOfLaps = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        // Ask for and assign racer's vehicle maker
        System.out.print("Please enter racer's vehicle maker: ");
        this.vehicleMaker = scanner.nextLine();


    }

    public void calculateBaseWinnings() {

        double earningsPerLap = EARNINGS_PER_LAP;

        if (numberOfLaps >= 50 && numberOfLaps <= 100) {
            earningsPerLap *= 1.33;
        } else if (numberOfLaps >= 101 && numberOfLaps <= 150) {
            earningsPerLap *= 1.66;
        } else if (numberOfLaps >= 151 && numberOfLaps <= 200) {
            earningsPerLap *= 2.00;
        }

        this.baseWinnings = earningsPerLap * numberOfLaps;
    }

    public void generateRandomRacerNumber() {
        Random random = new Random();
        this.racerNumber = random.nextInt(5000) + 1; // Generates a random number between 1 and 5000 (inclusive)
    }

    public void calculateMiles() {
        this.miles = LAP_DISTANCE * this.numberOfLaps;
    }

    public void calculateBonus() {
        this.bonus = 0; // Initialize bonus to 0

        // Check if the racer completed the full race (200 laps)
        if (this.numberOfLaps == FULL_RACE_BONUS_LAPS) {
            this.bonus = 15750; // Add the base bonus amount

            // Check if the vehicle maker is Ford
            if ("Ford".equalsIgnoreCase(this.vehicleMaker)) {
                this.bonus += 3500; // Add the additional bonus for Ford racers
            }
        }
    }


    public void calculateNetWinnings() {
        this.netWinnings = this.baseWinnings + this.bonus - ENTRY_FEE_PER_RACER;
    }
    // Getter methods


    public String getVehicleMaker() {
        return vehicleMaker;
    }



    public double getMiles() {
        return miles;
    }


    public double getBaseWinnings() {
        return baseWinnings;
    }



    public double getBonus() {
        return bonus;
    }



    public double getNetWinnings() {
        return netWinnings;
    }



    @Override
    public String toString() {
        String myStringBase = String.format("$%.2f", baseWinnings);
        String myBonus = String.format("$%.2f", bonus);
        String myNet = String.format("$%.2f", netWinnings);

        String message = String.format("%-10d%-25s%-15s%-10d%-10.2f%-15s%-15s%-15s",
                racerNumber, racerFirstName + " " + racerLastName,
                vehicleMaker, numberOfLaps, miles, myStringBase,
                myBonus, myNet);


        return message;
    }
}
