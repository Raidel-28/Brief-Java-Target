/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author llefe
 */
public class Salarie extends Employe {

    private double salaireMensuel;

    public Salarie(String nom, double salaire) {
        super(nom); // appel du constructeur de la classe mère
        this.salaireMensuel = salaire;
    }

    @Override
    public double calculerSalaire() {
        return salaireMensuel;
    }
}
