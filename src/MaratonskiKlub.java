import java.util.*;
import java.util.stream.Collectors;

public class MaratonskiKlub {
    private Map<String, Atleticar> kolekcija;
    public MaratonskiKlub() {
        kolekcija = new HashMap<>();
    }
    public Map<String, Atleticar> getKolekcija() {
        return kolekcija;
    }

    public void dodajAtletu(Atleticar atleticar) {
        String kljuc =  atleticar.getIme() + " " + atleticar.getPrezime();
        if(kolekcija.containsKey(kljuc)) {
            throw new IllegalArgumentException("Atleta vec postoji");
        }
        kolekcija.put(kljuc, atleticar);
    }

    public void obrisiAtletu(String imePrezime) {
        kolekcija.remove(imePrezime);
    }

    public void ispisiInformacije() {
        for(Atleticar atleticar : kolekcija.values()) {
            atleticar.ispisiInformacije();
        }
    }

    public Atleticar najiskusnijiAtleticar() {
        Atleticar atletaNajiskusnija = null;
        for(Atleticar atlet : kolekcija.values()) {
            if(atletaNajiskusnija  == null || atletaNajiskusnija.getGodineTreninga() < atlet.getGodineTreninga()) {
                atletaNajiskusnija = atlet;
            }
        }
        return atletaNajiskusnija;
    }

    public List<Atleticar> atleticarSaMinimalnimIskustvom(int minimalneGodineTreninga) {
        List<Atleticar> atleticari = kolekcija.values()
                .stream()
                .filter( a -> a.getGodineTreninga() >= minimalneGodineTreninga)
                .collect(Collectors.toList());

        double prosjecnaStarost = atleticari.stream()
                .mapToDouble( a -> a.getGodine())
                .average()
                .orElse(0.0);

        return atleticari.stream()
                .filter( a -> a.getGodine()>prosjecnaStarost)
                .collect(Collectors.toList());
    }

    public Map<String, List<Atleticar>> grupisiAtleticarePoOmiljenojDistanci() {
        Map<String, List<Atleticar>> mapa = kolekcija.values()
                .stream()
                .collect(Collectors.groupingBy(Atleticar :: getOmiljenaDistanca));

        for(List<Atleticar> liste : mapa.values()) {
            Collections.sort(liste, new Comparator<Atleticar>() {
                @Override
                public int compare(Atleticar o1, Atleticar o2) {
                    return Double.compare(o2.getGodineTreninga(), o1.getGodineTreninga());
                }
            });
        }
        return mapa;
    }
}
