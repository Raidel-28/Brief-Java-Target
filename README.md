# 🎯 T.A.R.G.E.T. - Simulation balistique en Java

Ce projet est une application Java Swing de simulation balistique dans laquelle un joueur doit viser une cible rouge à l'aide d'un canon placé aléatoirement sur l'écran.

---

## 🧩 Fonctionnalités

- 🧭 Saisie d'un angle (0 à 90°)
- 💨 Saisie d'une vitesse (10 à 100)
- 🌬️ Vent aléatoire entre -5 et +5 (influence le tir)
- 📍 Cible et canon placés aléatoirement à chaque partie
- 🧠 Physique simplifiée (gravité verticale + vent horizontal)
- 📈 Affichage de la trace du projectile
- ✅ Détection de collision avec la cible
- ❌ Affichage de "Touché !" ou "Raté !" selon le tir
- 🧮 Score affiché à l’écran
- 🎨 Affichage coloré du vent et du résultat

---

## 📁 Structure du projet

.
├── App.java # Point d'entrée principal (main)
├── GamePanel.java # Panneau principal contenant le jeu
├── README.md # Ce fichier

---

## ▶️ Lancement du projet

### 📦 Compilation

Assurez-vous que `App.java` et `GamePanel.java` sont dans le même dossier, puis compilez avec :

```bash
javac App.java GamePanel.java
