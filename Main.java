
public class Main {
    public static void main(String[] args) {
        Indy500RaceResults racer1 = new Indy500RaceResults();
        Indy500RaceResults racer2 = new Indy500RaceResults();
        Indy500RaceResults racer3 = new Indy500RaceResults();

        System.out.println("Welcome to the NASCAR Indy 500!");
        racer1.inputRacerInfo();
        racer2.inputRacerInfo();
        racer3.inputRacerInfo();

        // Calculate base winnings
        racer1.calculateBaseWinnings();
        racer2.calculateBaseWinnings();
        racer3.calculateBaseWinnings();

        // Generate a random racer number
        racer1.generateRandomRacerNumber();
        racer2.generateRandomRacerNumber();
        racer3.generateRandomRacerNumber();

        // Calculate miles
        racer1.calculateMiles();
        racer2.calculateMiles();
        racer3.calculateMiles();

        // Calculate bonus
        racer1.calculateBonus();
        racer2.calculateBonus();
        racer3.calculateBonus();

        // Calculate net winnings
        racer1.calculateNetWinnings();
        racer2.calculateNetWinnings();
        racer3.calculateNetWinnings();

        System.out.println("Welcome to the NASCAR Indy 500!");

        // Display the table header
        System.out.printf("%-10s%-25s%-15s%-10s%-10s%-15s%-15s%-15s%n",
                "Bib#", "Name", "Make", "Laps", "Miles", "Base Winnings", "Bonus", "Net Winnings");

        // Print an underline with dashes
        System.out.println("-".repeat(115));
        // Display racer information using the toString method
        System.out.println(racer1.toString());
        System.out.println(racer2.toString());
        System.out.println(racer3.toString());

        // Calculate and display totals
        double totalMilesCovered = racer1.getMiles() + racer2.getMiles() + racer3.getMiles();
        double totalBaseWinnings = racer1.getBaseWinnings() + racer2.getBaseWinnings() + racer3.getBaseWinnings();
        double totalBonusWinnings = racer1.getBonus() + racer2.getBonus() + racer3.getBonus();
        double totalNetWinnings = racer1.getNetWinnings() + racer2.getNetWinnings() + racer3.getNetWinnings();
        String formattedTotalNetWinnings = String.format("%.2f", totalNetWinnings);

        System.out.println("\nTotal Miles Covered: " + totalMilesCovered);
        System.out.println("Total Base Winnings: $" + totalBaseWinnings);
        System.out.println("Total Bonus Winnings: $" + totalBonusWinnings);
        System.out.println("Total Net Winnings: $" + formattedTotalNetWinnings);


    }
}