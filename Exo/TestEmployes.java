/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author llefe
 */
public class TestEmployes {

    public static void main(String[] args) {
        Employe e1 = new Salarie("Alice", 3000);
        Employe e2 = new Freelance("Bob", 120, 25);

        System.out.println(e1.getNom() + " gagne " + e1.calculerSalaire() + " €");
        System.out.println(e2.getNom() + " gagne " + e2.calculerSalaire() + " €");
    }
}
