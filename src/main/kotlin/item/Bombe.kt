class Bombe(
    val nombreDeDes: Int,
    var maxDe: Int,
    nom: String,
    description: String,
    val monstre: Personnage
):Item(nom,description) {
    override fun utiliser(cible: Personnage) {
        // Création d'un objet TirageDes pour simuler un lancé de dés 3d8
        val des = TirageDes(this.nombreDeDes, this.maxDe)

        // Utilisation de la méthode lance() pour obtenir le résultat du lancé
        val resultat = des.lance()
        println("Résultat = $resultat")

        // Supposez que la classe Personnage ait des propriétés defense et pointDeVie
        // que vous pouvez utiliser ici
        val resultatFinal = resultat - this.monstre.defense
        val pointsDeVieRestants = this.monstre.pointDeVie - resultatFinal

        println("L'adversaire a $pointsDeVieRestants points de vie restants.")
    }
}