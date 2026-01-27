// Denna klass Gör ett radhus som byggföretaget tilverkar
public class RadHus extends Byggnad {
    private int rum;
    private int sovRum;
    private int badRum;
    private int kök;
    private int tomtYta;

    public RadHus(int byggnadsId, int yta, int pris, int rum, int sovRum, int badRum, int kök, int tomtYta) {
        super(byggnadsId, yta, pris);
        // 4–7 rum
        if (rum < 4 || rum > 7) {
            throw new IllegalArgumentException("Antal rum måste vara mellan 4 och 7");
        }

        // 1–3 sovrum
        if (sovRum < 1 || sovRum > 3) {
            throw new IllegalArgumentException("Antal sovrum måste vara mellan 1 och 3");
        }

        // 1–2 badrum
        if (badRum < 1 || badRum > 2) {
            throw new IllegalArgumentException("Antal badrum måste vara mellan 1 och 2");
        }

        // Yta 150–230 kvm
        if (yta < 150 || yta > 230) {
            throw new IllegalArgumentException("Yta måste vara mellan 150 och 230 kvm");
        }

        // Tomt 400–1000 kvm
        if (tomtYta < 400 || tomtYta > 1000) {
            throw new IllegalArgumentException("Tomtstorlek måste vara mellan 400 och 1000 kvm");
        }

        // Pris 2500000 – 4000000 kr
        if (pris < 2500000 || pris > 4000000) {
            throw new IllegalArgumentException("Pris måste vara mellan 3 500 000 och 5 000 000 kr");
        }

        this.rum = rum;
        this.sovRum = sovRum;
        this.badRum = badRum;
        this.kök = 1;
        this.tomtYta = tomtYta;
    }

    @Override
    public int beräknaPris() {
        return pris;  
    }
}
