public class Kund {  // Customer
    private int kundId;
    private String namn;
    private String telefon;
    private String email;

    public Kund(int kundId, String namn, String telefon, String email) {
        this.kundId = kundId;
        this.namn = namn;
        this.telefon = telefon;
        this.email = email;
    }

    public void skapaKund() {
    }

    public String getNamn() {
        return namn;
    }

    public String getTelefon() {
        return telefon;
    }

    public String getEmail() {
        return email;
    }
}
