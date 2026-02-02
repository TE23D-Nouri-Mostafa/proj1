// Representerar en beställning av en byggnad och kopplar den med en kund.
public class Beställning {
    private Byggnad byggnad;  
    private Kund kund;

    public Beställning(Byggnad byggnad, Kund kund) {
        this.byggnad = byggnad;
        this.kund = kund;
    }

    public Byggnad getByggnad() {
        return byggnad;
    }

    public Kund getKund() {
        return kund;
    }

    public int beräknaPris() {
        return byggnad.beräknaPris();
    }
}
