package ba.etf.unsa.rpr;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LaptopDaoSerializableFile implements LaptopDao  {

    private File file;
    private ArrayList<Laptop> laptopi;


    public File getFile() {
        return file;
    }

    public ArrayList<Laptop> getLaptopi() {
        return laptopi;
    }

    @Override
    public void dodajLaptopUListu(Laptop laptop) {
        laptopi.add(laptop);
    }

    @Override
    public void dodajLaptopUFile(Laptop laptop) {
        laptopi.add(laptop);
        try{
            ObjectOutputStream izlaz= new ObjectOutputStream(new FileOutputStream("laptopi.txt"));
            izlaz.writeObject(laptopi);
            izlaz.close();
        } catch(Exception e){
            System.out.println("Greska" +  e);
        }




    }

    @Override
    public Laptop getLaptop(String procesor) throws NeodgovarajucProcesorException {

        for(Laptop l : this.laptopi){
            if(l.getProcesor().equals(procesor)) return l;
        }

        throw new NeodgovarajucProcesorException("Greska");
    }

    @Override
    public void napuniListu(ArrayList<Laptop> laptopi) {
        this.laptopi = laptopi;
    }
@Override
public List<Laptop> vratiPodatkeIzDatoteke(){
        this.file = new File("laptopi.txt");
        try {
            ObjectInputStream in = new ObjectInputStream((new FileInputStream((this.file))));
            List<Laptop> l = (List)in.readObject();
            this.laptopi = (ArrayList<Laptop>) l;
        } catch(Exception e) {
            this.laptopi = new ArrayList<Laptop>();
            System.err.println(e.getMessage());

        }

    return laptopi;
}
}
