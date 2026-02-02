// Denna klass jör ett garage med bil-area
public class Garage extends Byggnad {
    private int förrådsArea;
    private int bilArea;


    public Garage(int byggnadsId, int yta, int pris, int förrådsArea, int bilArea) {
        super(byggnadsId, yta, pris);
        
        // Area 15 – 30 kvm
        if (bilArea<15 || bilArea>30 ){
            throw new IllegalArgumentException("Bil arean får inte vara större än 20 eller mindre än 15");}

        // Area 5 – 20 kvm
        if (förrådsArea<5 || förrådsArea>20){
            throw new IllegalArgumentException("Förrådsarean får inte vara större än 20 eller mindre än 5");}
        
        // Pris 500000 – 100000 kr
        if (pris < 500000 || pris > 1000000) {
                    throw new IllegalArgumentException("Pris måste vara mellan 500000 och 1000000 kr");
        }
        this.förrådsArea = förrådsArea;
        this.bilArea = bilArea;
    }

    @Override
    public int beräknaPris() {
        return pris;  
    }
}
