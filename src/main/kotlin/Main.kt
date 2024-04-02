import item.Qualite
import jeu.Jeu
import personnage.Personnage

//instanciation des qualités des objets
val qualiteCommun = Qualite("commun", 0, "\u001B[32m")
val qualiteRare = Qualite("rare", 1, couleur = "\u001B[34m")
val qualiteEpic = Qualite("epic", 2, "\u001B[35m")
val qualiteLegendaire = Qualite("legendaire", 3, "\u001B[33m")

fun main(args: Array<String>) {
    //Instantiation des monstres
    val gobelin = Personnage(
        "Damien",
        pointDeVie = 20,
        pointDeVieMax = 20,
        attaque = 5,
        defense = 4,
        vitesse = 11,
        endurance = 6)

    val Basilic = Personnage(
        "Heboros",
        pointDeVie = 52,
        pointDeVieMax = 52,
        attaque = 16,
        defense = 15,
        vitesse = 6,
        endurance = 8)

    val Minotor_squelette = Personnage(
        "vasar",
        pointDeVie = 67,
        pointDeVieMax = 67,
        attaque = 18 ,
        defense = 12,
        vitesse = 12,
        endurance = 9)

    val Yeenoghu = Personnage(
        "bald",
        pointDeVie = 333,
        pointDeVieMax = 333,
        attaque = 29 ,
        defense = 23,
        vitesse = 15,
        endurance = 9)
    // TODO Intermission 1 Ajouter d'autres monstres
    //On ajoute les monstres a la liste de monstres du jeu
    val jeu = Jeu(listOf( gobelin, Basilic, Minotor_squelette, Yeenoghu))
    //Lancement du jeu
    jeu.lancerCombat()
}