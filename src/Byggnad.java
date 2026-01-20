public abstract class Byggnad { 
    protected int byggnadsId;
    protected int yta;  
    protected int pris; 

    public Byggnad(int byggnadsId, int yta, int pris) {
        this.byggnadsId = byggnadsId;
        this.yta = yta;
        this.pris = pris;
    }

    public abstract int beräknaPris(); 
}
