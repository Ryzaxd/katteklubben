package klasser;

public class Kæledyr {

    private int kid;
    private String knavn;
    private String kalder;
    private String koen;
    private String billedePath;


    public Kæledyr(int kid, String knavn, String kalder, String koen, String billedePath){
        this.kid = kid;
        this.knavn = knavn;
        this.kalder = kalder;
        this.koen = koen;
        this.billedePath = billedePath;
    }

    public Kæledyr() {

    }

    public String getKnavn() {
        return knavn;
    }

    public void setKnavn(String knavn) {
        this.knavn = knavn;
    }

    public String getKalder() {
        return kalder;
    }

    public void setKalder(String kalder) {
        this.kalder = kalder;
    }

    public String getKoen() {
        return koen;
    }

    public void setKoen(String koen) {
        this.koen = koen;
    }

    public int getkid() {
        return kid;
    }

    public void setKid(int kid) {
        this.kid = kid;
    }

    public int getKid() {
        return kid;
    }

    public String getBilledePath() {
        return billedePath;
    }

    public void setBilledePath(String billedePath) {
        this.billedePath = billedePath;
    }
}
