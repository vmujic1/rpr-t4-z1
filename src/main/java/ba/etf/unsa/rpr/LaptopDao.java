package ba.etf.unsa.rpr;

import java.util.ArrayList;
import java.util.List;

public interface LaptopDao {
    public void dodajLaptopUListu(Laptop laptop);
    public void dodajLaptopUFile(Laptop laptop);
    public Laptop getLaptop(String procesor) throws NeodgovarajucProcesorException;
    public void napuniListu(ArrayList<Laptop> laptopi);

    public List<Laptop> vratiPodatkeIzDatoteke();

}
