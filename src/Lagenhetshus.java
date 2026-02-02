// Denna klass Gör ett lägenhetshus med traphus och många lägenheter 
public class Lagenhetshus extends Byggnad {
    private int antalLagenheter; 
    private boolean harTrapphus; 
    private boolean harFörråd;   

    public Lagenhetshus(int byggnadsId, int yta, int pris, int antalLagenheter, boolean harTrapphus, boolean harFörråd) {
        super(byggnadsId, yta, pris);
        this.antalLagenheter = antalLagenheter;
        this.harTrapphus = harTrapphus;
        this.harFörråd = harFörråd;
    }

    @Override
    public int beräknaPris() {
        return pris;
    }
}