package item

import jeu.TirageDes
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import personnage.Personnage

class BombeTest (val nombreDeDes: Int,
                 var maxDe: Int,
                 val nom: String,
                 var description: String,
                 val monstre: Personnage){


    @Test
    fun utiliser() {
        val Minotor_squelette = monstre (
            "vasar",
            pointDeVie = 67,
            pointDeVieMax = 67,
            attaque = 18 ,
            defense = 12,
            vitesse = 12,
            endurance = 9)



         val des: TirageDes = TirageDes(this.nombreDeDes, this.maxDe)

        // Utilisation de la méthode lance() pour obtenir le résultat du lancé
        var resultat = des.lance()
        println(" result = $resultat")
        var resulat = resultat - this.monstre.defense
        var pointDeVie = this.monstre.pointDeVie - resultat
        println("l'adversaire a " +pointDeVie +"restant")

        Assertions.assertEquals("","67")
        Assertions.assertNotEquals("a",'a')
        Assertions.assertNotNull("machin")

    }

    private fun monstre(s: String, pointDeVie: Int, pointDeVieMax: Int, attaque: Int, defense: Int, vitesse: Int, endurance: Int): Any {

    }
}
