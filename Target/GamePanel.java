/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.*;

public class GamePanel extends JPanel {

    // Constantes de physique
    private final double gravity = 0.5;       // force verticale constante
    private final Random random = new Random();

    // Interface utilisateur
    private JTextField angleField;
    private JTextField vitesseField;
    private JButton boutonTirer;
    private JButton boutonNouvellePosition;

    // Données du tir
    private double angle;      // en degrés
    private double vitesse;    // entre 10 et 100
    private double wind;       // aléatoire entre -5 et +5

    // Canon, cible et projectile
    private int cannonX, cannonY;
    private int targetX, targetY;
    private double projX, projY;
    private double vx, vy;

    // Score
    private int score = 0;

    // Trace du projectile
    private final List<Point> trajectoire = new ArrayList<>();

    // Timer = animation du tir
    private final Timer timer;

    // Constructeur principal
    public GamePanel() {
        this.setLayout(new BorderLayout());

        // Interface utilisateur : panneau supérieur
        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.LIGHT_GRAY);

        angleField = new JTextField(5);
        vitesseField = new JTextField(5);
        boutonTirer = new JButton("Tirer");
        boutonNouvellePosition = new JButton("Nouvelle position");

        topPanel.add(new JLabel("Angle (0–90°) :"));
        topPanel.add(angleField);
        topPanel.add(new JLabel("Vitesse (10–100) :"));
        topPanel.add(vitesseField);
        topPanel.add(boutonTirer);
        topPanel.add(boutonNouvellePosition);

        this.add(topPanel, BorderLayout.NORTH);

        // Positionner le canon et la cible
        placeCannonAndTarget();

        // Actions des boutons
        boutonNouvellePosition.addActionListener(e -> {
            placeCannonAndTarget();
            score = 0;
            trajectoire.clear();
            repaint();
        });

        boutonTirer.addActionListener(e -> startShooting());

        // Timer (animation toutes les 50 ms)
        timer = new Timer(50, e -> updateProjectile());
    }

    // Méthode pour positionner canon et cible aléatoirement
    private void placeCannonAndTarget() {
        cannonX = random.nextInt(100) + 50;
        cannonY = getHeight() > 0 ? getHeight() - 100 : 500;

        targetX = random.nextInt(100) + 400;
        targetY = random.nextInt(getHeight() > 0 ? getHeight() - 200 : 400) + 50;

        trajectoire.clear();
        repaint();
    }

    // Lancer le projectile avec les valeurs saisies
    private void startShooting() {
        try {
            angle = Double.parseDouble(angleField.getText());
            vitesse = Double.parseDouble(vitesseField.getText());

            if (angle < 0 || angle > 90 || vitesse < 10 || vitesse > 100) {
                JOptionPane.showMessageDialog(this, "Valeurs invalides !");
                return;
            }

            // Vent aléatoire
            wind = random.nextInt(11) - 5; // [-5, 5]

            // Position initiale du projectile = canon
            projX = cannonX;
            projY = cannonY;

            // Conversion de l’angle en radians
            double radians = Math.toRadians(angle);

            // Vitesse initiale (divisée par 2 pour équilibrer le jeu)
            vx = Math.cos(radians) * vitesse / 2;
            vy = -Math.sin(radians) * vitesse / 2;

            trajectoire.clear();
            timer.start(); // on lance le mouvement

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Veuillez entrer des nombres valides !");
        }
    }

    // Mise à jour de la position du projectile
    private void updateProjectile() {
        // Avancer en x et y
        projX += vx;
        projY += vy;

        // Effet du vent et de la gravité
        vx += wind / 10.0;
        vy += gravity;

        // Ajouter à la trace
        trajectoire.add(new Point((int) projX, (int) projY));

        // Tester si on sort de l’écran
        if (projX < 0 || projX > getWidth() || projY > getHeight()) {
            timer.stop(); // fin du tir
        }

        // Tester si on touche la cible (zone carrée de 20x20)
        if (projX >= targetX && projX <= targetX + 20
                && projY >= targetY && projY <= targetY + 20) {
            score++;
            timer.stop();
            repaint();
            JOptionPane.showMessageDialog(this, "Touché ! Bravo !");
        }

        repaint();
    }

    // Affichage général
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Fond
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        // Canon
        g.setColor(Color.BLUE);
        g.fillRect(cannonX, cannonY, 20, 20);

        // Cible
        g.setColor(Color.RED);
        g.fillRect(targetX, targetY, 20, 20);

        // Projectile (dernier point)
        g.setColor(Color.BLACK);
        g.fillOval((int) projX, (int) projY, 5, 5);

        // Trace du projectile
        g.setColor(Color.GRAY);
        for (Point p : trajectoire) {
            g.fillOval(p.x, p.y, 2, 2);
        }

        // Score
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.drawString("Score : " + score, 20, getHeight() - 20);
    }
}
