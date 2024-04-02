import personnage.Personnage

open class Item (val nom: String, val description: String){
        open fun utiliser(cible: Personnage){
        println("$nom ne peut pas etre utilisé.")
        }

        override fun toString(): String {
        return "{$nom} (nom='$nom', description='$description')"
        }
        }