import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    // Listan och scannern måste ligga här för att alla metoder ska kunna nå dem
    private static List<Beställning> beställningar = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    // Programstart
    public static void main(String[] args) {
        Main program = new Main();
        program.visaMeny();
    }

    // Lägg till en ny beställning
    void läggTillBeställning() {
        System.out.println("Välj byggnadstyp: 1. Villa, 2. Radhus, 3. Garage, 4. Lägenhetshus");
        int val = scanner.nextInt();

        System.out.println("Ange byggnads ID:");
        int byggnadsId = scanner.nextInt();

        System.out.println("Ange yta:");
        int yta = scanner.nextInt();

        System.out.println("Ange pris:");
        int pris = scanner.nextInt();

        if (val == 1) { // Alternativ för Villa
            System.out.println("Ange antal rum (4-7):");
            int rum = scanner.nextInt();
            System.out.println("Ange antal sovrum (1-3):");
            int sovRum = scanner.nextInt();
            System.out.println("Ange antal badrum (1-2):");
            int badRum = scanner.nextInt();
            System.out.println("Ange tomt yta (400-1000 kvm):");
            int tomtYta = scanner.nextInt();

            Villa villa = new Villa(byggnadsId, yta, pris, rum, sovRum, badRum, 1, tomtYta);
            skapaBeställning(villa);

        } else if (val == 2) { // Alternativ för Radhus
            System.out.println("Ange antal rum (4-7):");
            int rum = scanner.nextInt();
            System.out.println("Ange antal sovrum (1-3):");
            int sovRum = scanner.nextInt();
            System.out.println("Ange antal badrum (1-2):");
            int badRum = scanner.nextInt();
            System.out.println("Ange tomt yta (400-1000 kvm):");
            int tomtYta = scanner.nextInt();

            RadHus radhus = new RadHus(byggnadsId, yta, pris, rum, sovRum, badRum, 1, tomtYta);
            skapaBeställning(radhus);

        } else if (val == 3) { // Alternativ för Garage
            System.out.println("Ange föxsrrådsarea (5-20 kvm):");
            int förrådsArea = scanner.nextInt();
            System.out.println("Ange bilarea (15-30 kvm):");
            int bilArea = scanner.nextInt();

            Garage garage = new Garage(byggnadsId, yta, pris, förrådsArea, bilArea);
            skapaBeställning(garage);

        } else if (val == 4) { // Alternativ för Lägenhetshus
            System.out.println("Ange antal lägenheter (10-20):");
            int antalLagenheter = scanner.nextInt();
            System.out.println("Har trapphus? (true/false):");
            boolean harTrapphus = scanner.nextBoolean();
            System.out.println("Har förråd? (true/false):");
            boolean harForad = scanner.nextBoolean();

            Lagenhetshus lh = new Lagenhetshus(byggnadsId, yta, pris, antalLagenheter, harTrapphus, harForad);
            skapaBeställning(lh);
        }
    }

    // Skapar själva beställningen och kopplar den till en kund
    void skapaBeställning(Byggnad byggnad) {
        System.out.println("Ange kund ID:");
        int kundId = scanner.nextInt();
        scanner.nextLine(); // Rensar bufferten så att nästa textinmatning fungerar

        System.out.println("Ange namn:");
        String namn = scanner.nextLine();
        System.out.println("Ange telefon:");
        String telefon = scanner.nextLine();
        System.out.println("Ange email:");
        String email = scanner.nextLine();

        Kund kund = new Kund(kundId, namn, telefon, email);
        Beställning beställning = new Beställning(byggnad, kund);
        beställningar.add(beställning);

        System.out.println("Beställning för " + byggnad.getClass().getSimpleName() + " lagd.");
    }

    // Visar en lista på alla gjorda beställningar
    void listaBeställningar() {
        if (beställningar.isEmpty()) {
            System.out.println("Inga beställningar finns.");
            return;
        }

        for (Beställning b : beställningar) {
            System.out.println(
                "Byggnads ID: " + b.getByggnad().byggnadsId +
                ", Pris: " + b.beräknaPris()
            );
        }
    }

    // Tar bort en beställning baserat på byggnadens ID
    void taBortBeställning() {
        System.out.println("Ange byggnads ID för att ta bort:");
        int byggnadsId = scanner.nextInt();

        // Letar upp och tar bort beställningen
        boolean borttagen = beställningar.removeIf(b -> b.getByggnad().byggnadsId == byggnadsId);
        
        if (borttagen) {
            System.out.println("Beställning borttagen.");
        } else {
            System.out.println("Ingen beställning hittades med det ID:t.");
        }
    }

    // Räknar ut och visar den totala vinsten från alla beställningar
    void visaVinst() {
        int total = 0;
        for (Beställning b : beställningar) {
            total += b.beräknaPris();
        }
        System.out.println("Total vinst: " + total + " kr");
    }

    // Huvudmenyn för programmet
    void visaMeny() {
        while (true) {
            System.out.println("\n--- MENY ---");
            System.out.println("1. Lägg till beställning");
            System.out.println("2. Ta bort beställning");
            System.out.println("3. Lista beställningar");
            System.out.println("4. Visa total vinst");
            System.out.println("5. Avsluta");

            // Kontrollera att användaren matar in en siffra
            if (!scanner.hasNextInt()) {
                System.out.println("Var god mata in en siffra.");
                scanner.next(); 
                continue;
            }
            
            int val = scanner.nextInt();

            switch (val) {
                case 1 -> läggTillBeställning();
                case 2 -> taBortBeställning();
                case 3 -> listaBeställningar();
                case 4 -> visaVinst();
                case 5 -> {
                    System.out.println("Programmet avslutas.");
                    return;
                }
                default -> System.out.println("Ogiltigt val, försök igen.");
            }
        }
    }
}