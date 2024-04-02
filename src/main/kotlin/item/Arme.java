package item

import jeu.TirageDes
import personnage.Personnage

class Arme(val nom: String, val type: TypeArme, val qualite: Qualite) {


    fun calculDegat(): Int {
        var desDegats = TirageDes(this.type.nombreDes, 8).lance()
        val deCritique = TirageDes(1, 20).lance()
        if (deCritique >= this.type.activationCritique) {
            // desDegats * this.type.multiplicateurCritique +   this.qualite.bonusRarete

            desDegats = this.type.multiplicateurCritique * desDegats
            println("Coup critique")


        }

        desDegats+= this.qualite.bonusRarete

        return desDegats
    }


    fun utiliser(personnage: Personnage) {

    }


}