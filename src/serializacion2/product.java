/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializacion2;

import java.io.Serializable;

/**
 *
 * @author oracle
 */
public class product  implements Serializable{
    String cod;
    int des;
    int prezo;

    public product(String cod, int des, int prezo) {
        this.cod = cod;
        this.des = des;
        this.prezo = prezo;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public int getDes() {
        return des;
    }

    public void setDes(int des) {
        this.des = des;
    }

    public int getPrezo() {
        return prezo;
    }

    public void setPrezo(int prezo) {
        this.prezo = prezo;
    }

    @Override
    public String toString() {
        return "product{" + "cod=" + cod + ", des=" + des + ", prezo=" + prezo + '}';
    }

    
    
    
}
