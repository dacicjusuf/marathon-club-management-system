import java.util.*;

public class Atleticar extends Takmicar implements Maraton {
    private int godineTreninga;
    private String omiljenaDistanca;
    private int brojMaratona;

    public Atleticar(String ime, String prezime, int godine, int godineTreninga, String omiljenaDistanca, int brojMaratona) {
        super(ime, prezime, godine);
        this.godineTreninga = godineTreninga;
        this.omiljenaDistanca = omiljenaDistanca;
        this.brojMaratona = brojMaratona;
    }

    public int getGodineTreninga() {
        return godineTreninga;
    }

    public String getOmiljenaDistanca() {
        return omiljenaDistanca;
    }

    public int getBrojMaratona() {
        return brojMaratona;
    }

    public void ispisiInformacije() {
        System.out.println("Ime: " + getIme() + " Prezime: " + getPrezime() + " Godine: " + getGodine() + "\n" +
                "Godine treninga: " + godineTreninga + "Omiljena distanca: " + omiljenaDistanca + "Broj maratona: " + getBrojMaratona());
    }

    public void dodajMaraton() {
        this.brojMaratona++;
    }

    public void povecajTrening() {
        this.godineTreninga++;
    }

    @Override
    public int izracunajIskustvo() {
        return this.godineTreninga * this.brojMaratona;
    }

    @Override
    public void zapocniMaraton() {
        System.out.println("Maraton je zapocet");
    }

    @Override
    public void zavrsiMaraton() {
        System.out.println("Maraton je zavrsen");
    }

    @Override
    public double izracunajVrijemeTrke(double kilometri) {
        double brzina = 10.0;
        return (double) kilometri / brzina;
    }
}