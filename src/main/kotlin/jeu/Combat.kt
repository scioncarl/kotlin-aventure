package jeu

import personnage.Personnage

class Combat(
    val jeu :Jeu,
    val monstre: Personnage) {
    var nombreTours: Int = 1

    // Méthode pour simuler un tour de combat du joueur
    fun tourDeJoueur() {
        println("\u001B[34m ---Tour de ${this.jeu.joueur.nom} (pv: ${this.jeu.joueur.pointDeVie}) ---")
        //TODO Mission 1.2
        println("Qu'allez vous faire ?")
        println("1. Attaquer")
        println("2. Passer votre tour")
        val choixOption = readln()
        if (choixOption=="1") {
            this.jeu.joueur.attaque(monstre)
        }
        else if (choixOption=="2"){
            println("Le joueur passe son tour.")
        }
        println("\u001b[0m")
    }

    // Méthode pour simuler un tour de combat du monstre
    fun tourDeMonstre() {
        println("le monstre est en plein dilemme ")
        val nb = (1..100).random()
        if (nb <= 70) {
            println("\u001B[31m---Tour de ${monstre.nom} (pv: ${monstre.pointDeVie}) ---")
            //TODO Mission 1.3
            this.monstre.attaque(this.jeu.joueur)
            println("\u001b[0m")
        } else {
            // Check if the monster has a potion and its health is less than half of its max health
            if (monstre.avoirPotion() && monstre.pointDeVie < monstre.pointDeVieMax / 2) {
                val chanceDeBoirePotion = (1..10).random() // 10% chance
                if (chanceDeBoirePotion == 1) {
                    monstre.boirePotion()
                    println("Le monstre boit une potion pour récupérer des points de vie.")
                } else {
                    println("Le monstre ne fait rien.")
                }
            } else {
                println("Le monstre ne fait rien.")
            }
        }
    }


    // Méthode pour exécuter le combat complet
    fun executerCombat() {
        println("Début du combat : ${this.jeu.joueur.nom} vs ${monstre.nom}")
        //La vitesse indique qui commence
        var tourJoueur = this.jeu.joueur.vitesse >= this.monstre.vitesse
        //Tant que le joueur et le monstre sont vivants
        while (this.jeu.joueur.pointDeVie > 0 && monstre.pointDeVie > 0) {
            println("Tours de jeu : ${nombreTours}")
            if (tourJoueur) {
                tourDeJoueur()
            } else {
                tourDeMonstre()
            }
            nombreTours++
            tourJoueur = !tourJoueur // Alternance des tours entre le joueur et le monstre
            println("${this.jeu.joueur.nom}: ${this.jeu.joueur.pointDeVie} points de vie | ${monstre.nom}: ${monstre.pointDeVie} points de vie")
            println("")
        }

        if (this.jeu.joueur.pointDeVie <= 0) {
            println("Game over ! ${this.jeu.joueur.nom} a été vaincu !")
            println("Le combat recommence")

            this.jeu.joueur.pointDeVie = this.jeu.joueur.pointDeVieMax
            this.monstre.pointDeVie = this.monstre.pointDeVieMax
            this.executerCombat()
        } else {
            println("BRAVO ! ${monstre.nom} a été vaincu !")
        }
    }
}