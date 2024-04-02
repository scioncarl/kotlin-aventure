package item;

import personnage.Personnage

class Armure (val nom:String, val description:String, val type:TypeArmure, val qualite: Qualite){
    fun calculProtection(): Int {
        val bonusProtection=this.type.bonusType+this.qualite.bonusRarete
        return bonusProtection
    }
    fun utiliser(cible: Personnage) {

    }
}