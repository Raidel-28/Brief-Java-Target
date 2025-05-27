/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author llefe
 */
public abstract class Employe {

    protected String nom;

    public Employe(String nom) {
        this.nom = nom;
    }

    public abstract double calculerSalaire();

    public String getNom() {
        return nom;

    }
}
