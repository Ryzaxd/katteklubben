package klasser;

public class Medlem {

    private int mid;
    private String fnavn;
    private String enavn;
    private String email;
    private String password;

    public Medlem(int mid, String fnavn, String enavn, String email, String password) {
        this.mid = mid;
        this.fnavn = fnavn;
        this.enavn = enavn;
        this.email = email;
        this.password = password;
    }

    public Medlem() {

    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getFnavn() {
        return fnavn;
    }

    public void setFnavn(String fnavn) {
        this.fnavn = fnavn;
    }

    public String getEnavn() {
        return enavn;
    }

    public void setEnavn(String enavn) {
        this.enavn = enavn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
