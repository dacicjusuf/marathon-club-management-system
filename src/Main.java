import java.util.*;

public class Main {
    public static void main(String[] args) {
        Atleticar a1 = new Atleticar("Jusuf", "Dacic", 20, 2, "Ilidza", 5);
        Atleticar a2 = new Atleticar("Ismail", "Mujanovic", 21, 3, "Pazaric", 10);
        MaratonskiKlub klub = new MaratonskiKlub();

        try {
            klub.dodajAtletu(a1);
            klub.dodajAtletu(a2);
            klub.dodajAtletu(a1);
        } catch(IllegalArgumentException e) {
            System.out.println("Desila se greska pri unosu: " + e.getMessage());
        }


        a1.zapocniMaraton();
        a2.zapocniMaraton();
        a1.zavrsiMaraton();
        a2.zavrsiMaraton();


        a1.izracunajVrijemeTrke(100);
        a2.izracunajVrijemeTrke(150);

        if(a1.equals(a2)) {
            System.out.println("Atleta " + a1.getIme() + " je ista kao i " + a2.getIme() );
        }
        else {
            System.out.println("Nisu iste");
        }

        System.out.println("Hashcode1: " + a1.hashCode());
        System.out.println("Hashcode2: " + a2.hashCode());

        klub.ispisiInformacije();

        System.out.println("Najiskusniji atleticar je: " + klub.najiskusnijiAtleticar());

        klub.atleticarSaMinimalnimIskustvom(2).stream()
                .forEach( a -> {
                    a.ispisiInformacije();
                });

        klub.grupisiAtleticarePoOmiljenojDistanci().entrySet().stream()
                .forEach(a-> {
                    String kljuc = a.getKey();
                    List<Atleticar> vrijednosti = a.getValue();
                    System.out.println(kljuc);

                    vrijednosti.stream()
                            .forEach( at -> {
                                System.out.println(at.getIme() + " " + at.getPrezime());
                            });
                });
    }
}