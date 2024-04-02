package personnage

import item.Arme
import item.Armure
import item.Item
import java.nio.file.attribute.GroupPrincipal

class Personnage(
    val nom: String,
    var pointDeVie: Int,
    val pointDeVieMax: Int,
    var attaque: Int,
    var defense: Int,
    var endurance: Int? = null,
    var vitesse: Int,
    var armePrincipal: Arme? = null,
    var armure: Armure? = null,
    var inventaire: MutableList<Item> = mutableListOf()
) {

    val hero = Personnage("hero", 20, 40, 12, 8, 10, 7)
    fun calculeTotalDefense(): Int {
        //TODO Mission 4.2
        var resultat = (this.defense / 2) + this.armure!!.calculProtection()
        return resultat;
    }
    fun equipe(armure: Armure) {
        if (armure in this.inventaire) {
            this.armure = armure
            println("$nom equipe {$armure}")
        }
    }

    // Méthode pour attaquer un adversaire
    fun attaque(adversaire: Personnage) {
        //TODO Mission 4.1
        var degats= this.attaque/2


        if (armePrincipal != null){
            degats= this.armePrincipal!!.calculDegat()


        }
        else{

            println("$nom attaque ${adversaire.nom} avec une attaque de base et inflige $degats points de dégâts.")
        }
        var degats_infliges =degats-adversaire.calculeDefense()
        println("Les dégats infligés sont {$degats_infliges}")
        //

        if (degats<1)
        {
            degats=1
        }
        println("Les dégats infligés sont {$degats}")
        //

        println("Le nombre de dégats est ${degats}, affligé par ${this.nom} ")
        adversaire.pointDeVie-=degats

    }

    fun equipe(arme: Arme ) {

        this.armePrincipal = arme
        println("$nom equipe {$armePrincipal}")
    }

    return "$nom (PV: $pointDeVie/$pointDeVieMax, Attaque: $attaque, Défense: $defense, Endurance: $endurance, Vitesse: $vitesse)"
}
fun ajouterBombe(bombe: Item) {
    inventaire.add(bombe)
}

fun avoirBombe(): Boolean {
    return inventaire.any { it is Bombe }
}

var pointsDeVie: Int = 100 // Points de vie initiaux du personnage
val pointsDeVieMax: Int = 100 // Points de vie maximum du personnage

fun avoirPotion(): Boolean {
    return inventaire.isNotEmpty()
}

fun ajouterPotion(potion: Item) {
    inventaire.add(potion)
}

fun boirePotion() {
    var potion: Potion
    if (avoirPotion()) {
        for (k in inventaire) {
            if (k is Potion) {

                potion = k

                val montantDeSoin = potion
                pointsDeVie += montantDeSoin.soin

                if (pointsDeVie > pointsDeVieMax) {
                    pointsDeVie = pointsDeVieMax
                }

                println("Le personnage boit la potion ${potion.nom} et récupère $montantDeSoin points de vie.")
                inventaire.remove(k)
                break

            }
        }
    } else {
        println("Le personnage n'a pas de potion dans son inventaire.")
    }
}
}