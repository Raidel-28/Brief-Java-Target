/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author llefe
 */
public class TestAnimaux {

    public static void main(String[] args) {
        Animal[] animaux = {new Chien(), new Chat()};

        for (Animal a : animaux) {
            a.crier(); // Polymorphisme : appel de la méthode redéfinie selon l'objet réel
        }
    }
}
