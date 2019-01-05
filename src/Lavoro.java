/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

/**
 *
 * @author Francesco
 */
public class Lavoro {
    private String cliente,stat,pezzo,tipodilavoro;
    int id;
    
    public Lavoro(String cliente, String stat, String pezzo, String tipodilavoro, int id) {
        this.cliente = cliente;
        this.stat = stat;
        this.pezzo = pezzo;
        this.tipodilavoro = tipodilavoro;
        this.id = id;
    }
    
    public String getCliente() {
        return cliente;
    }
    
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    
    public String getStat() {
        return stat;
    }
    
    public void setStat(String stat) {
        this.stat = stat;
    }
    
    public String getPezzo() {
        return pezzo;
    }
    
    public void setPezzo(String pezzo) {
        this.pezzo = pezzo;
    }
    
    public String getTipodilavoro() {
        return tipodilavoro;
    }
    
    public void setTipodilavoro(String tipodilavoro) {
        this.tipodilavoro = tipodilavoro;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
}
