/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author llefe
 */
public class CompteBancaire {

    private double solde;

    public CompteBancaire(double soldeInitial) {
        this.solde = soldeInitial;
    }

    public void deposer(double montant) {
        if (montant > 0) {
            solde += montant;
            System.out.println("Dépôt de " + montant + " euros effectué. Nouveau solde: " + solde + " euros.");
        } else {
            System.out.println("Le montant du dépôt doit être positif.");
        }
    }

    public void retirer(double montant) {
        if (montant > 0 && montant <= solde) {
            solde -= montant;
            System.out.println("Retrait de " + montant + " euros effectué. Nouveau solde: " + solde + " euros.");
        } else if (montant > solde) {
            System.out.println("Fonds insuffisants pour le retrait de " + montant + " euros.");
        } else {
            System.out.println("Le montant du retrait doit être positif.");
        }
    }

    public double getSolde() {
        return solde;
    }

}
