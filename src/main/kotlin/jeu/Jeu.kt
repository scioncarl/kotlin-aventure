package jeu

import personnage.Personnage


class Jeu(monstres: List<Personnage>) {
    lateinit var joueur: Personnage
    var combats: MutableList<Combat> = mutableListOf()
    var score: Int = 0

    // Corps du constructeur
    init {
        // Lancement de la création du personage du joueur
        this.creerPersonnage()
        // Pour chaque monstre dans la liste de monstres
        for (unMonstre in monstres) {
            // On créer un combat
            val unCombat = Combat(this, unMonstre)
            combats.add(unCombat)
        }
    }

    fun lancerCombat() {
        for (unCombat in this.combats) {
            unCombat.executerCombat()
            // Mettre à jour le score en fonction du nombre de tours
            val tours = unCombat.nombreTours
            score += calculerScore(tours)
        }
        println("Score final du joueur: $score")
    }

    private fun calculerScore(tours: Int): Int {
        // Par exemple, vous pouvez attribuer plus de points pour moins de tours
        return 500 - tours * 10
    }

    /**
     *  Méthode pour créer le personnage du joueur en demandant les informations à l'utilisateur
     *
     */
    fun creerPersonnage(): Personnage {
        println("Création votre personnage:")
        // TODO Mission 1.1
        //val hero = Personnage("", 0, 0, 0, 0, 0, 0)

        println("Saisir le nom du personnage")
        var nomPerso = readln().toString()
        println("Saisir le nombre de point de vie")
        var nombrePointDeVie = readln().toInt()
        println("Saisir le score de l'attaque")
        var scoreAtq = readln().toInt()
        println("Saisir le score de défense")
        var scoreDef = readln().toInt()
        println("Saisir le score d'endurance")
        var scoreEnd = readln().toInt()
        println("Saisir le score de vitesse")
        var scoreVit = readln().toInt()
        var pointDeVieMax =50+ (scoreEnd * 10)

        if (scoreAtq+ scoreDef + scoreEnd + scoreVit > 40) {

            println("Erreur")
            println("Saisir le nom du personnage")
            var nomPerso = readln().toString()
            println("Saisir le nombre de point de vie")
            var nombrePointDeVie = readln().toInt()
            println("Saisir le score de l'attaque")
            scoreAtq = readln().toInt()
            println("Saisir le score de défense")
            scoreDef = readln().toInt()
            println("Saisir le score d'endurance")
            scoreEnd = readln().toInt()
            println("Saisir le score de vitesse")
            scoreVit = readln().toInt()
            var pointDeVieMax = scoreEnd - 10
        }
        else{




        }

        val heros = Personnage (nomPerso, pointDeVieMax, pointDeVieMax, scoreAtq, scoreDef, scoreEnd, scoreVit)
        println(heros)
        this.joueur = heros
        return heros
    }



}

