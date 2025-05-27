/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author llefe
 */
public class Freelance extends Employe {

    private int heures;
    private double tarifHoraire;

    public Freelance(String nom, int heures, double tarif) {
        super(nom); // appel du constructeur de la classe mère
        this.heures = heures;
        this.tarifHoraire = tarif;
    }

    @Override
    public double calculerSalaire() {
        return heures * tarifHoraire;
    }
}
