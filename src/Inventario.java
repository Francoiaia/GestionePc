/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Francesco
 */
public class Inventario {
    String stato,pezzo;
    int ID;

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public String getPezzo() {
        return pezzo;
    }

    public void setPezzo(String pezzo) {
        this.pezzo = pezzo;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Inventario(String stato, String pezzo, int ID) {
        this.stato = stato;
        this.pezzo = pezzo;
        this.ID = ID;
    }
}
