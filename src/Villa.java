public class Villa extends Byggnad {
    private int rum;
    private int sovRum;
    private int badRum;
    private int kök;
    private int tomtYta;

    public Villa(int byggnadsId, int yta, int pris, int rum, int sovRum, int badRum, int kök, int tomtYta) {
        super(byggnadsId, yta, pris);
        this.rum = rum;
        this.sovRum = sovRum;
        this.badRum = badRum;
        this.kök = kök;
        this.tomtYta = tomtYta;
    }

    @Override
    public int beräknaPris() {
        return pris;  
    }
}
