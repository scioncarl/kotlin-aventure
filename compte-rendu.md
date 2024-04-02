# COMPTE-RENDU BALDUR'S GATE 4

## Introduction

Ce rapport présente un aperçu des concepts Kotlin qui ont été explorés jusqu'à présent. Kotlin est un langage de programmation moderne, concis et sûr, compatible avec Java, adapté au développement d'applications Android et d'autres applications logicielles.

## Héritage et Classes

Kotlin permet l'héritage de classes via le mot-clé ":", permettant aux classes d'hériter des propriétés et méthodes d'une classe parente. Par exemple :

----
```kotlin
class SuperClasse {  
    // Propriétés et méthodes de la classe parente  
}

class SousClasse: SuperClasse {
   // Propriétés et méthodes spécifiques à la sous-classe  
}
```
----

## Polymorphisme

Kotlin prend en charge le polymorphisme, permettant aux objets d'être traités de manière uniforme, indépendamment de leur type réel. Cela se fait via l'utilisation du mot-clé open pour les classes parentes et du mot-clé override pour les méthodes dans les classes enfant.

## Exemple de Code

Voici un exemple de code illustrant l'héritage et le polymorphisme :

----
```kotlin
open class Animal(val nom: String) {
    open fun faireDuBruit() {
        println("L'animal fait un bruit.")
    }
}

class Chien(nom: String) : Animal(nom) {
    override fun faireDuBruit() {
        println("Le chien aboie.")
    }
}
```
----

## Utilisation d'Objets et de Méthodes

Kotlin permet également la création et l'utilisation d'objets, ainsi que la définition de méthodes dans ces objets. Voici un exemple d'utilisation d'une méthode pour vérifier si un personnage dispose d'au moins une potion dans son inventaire :

----
```kotlin
class Personnage(val nom: String) {
    private val inventaire = mutableListOf<Item>()

    fun avoirPotion(): Boolean {
        return inventaire.any { it is Potion }
    }

    fun ajouterPotion(potion: Potion) {
        inventaire.add(potion)
    }
}

class Item(val nom: String)

class Potion(nom: String, val effet: String) : Item(nom)
```
----
## Introduction

Ce rapport présente les fonctionnalités implémentées pour la classe Personnage en Kotlin, basées sur les spécifications fournies.

## Fonctionnalités implémentées

Ajout de Potion à l'Inventaire
Le personnage peut ajouter une potion à son inventaire en utilisant la méthode ajouterPotion(potion: Potion) de la classe Personnage.

Vérification de la Présence de Potion
Le personnage peut vérifier s'il a au moins une potion dans son inventaire en utilisant la méthode avoirPotion(): Boolean de la classe Personnage.

Ajout de Bombe à l'Inventaire (mise à jour)
La classe Personnage a été mise à jour pour permettre l'ajout de bombes à l'inventaire avec la méthode ajouterBombe(bombe: String).

Boire une Potion
Le personnage peut boire la première potion de son inventaire en utilisant la méthode boirePotion() de la classe Personnage. Cette méthode met à jour les points de vie du personnage en fonction du montant de soin de la potion, ajustant les points de vie au maximum si nécessaire, et retire la potion de l'inventaire. Un message est affiché indiquant le nom de la potion et le montant de points de vie récupérés.

## Exemple d'utilisation

```kotlin
fun main() {
    val personnage = Personnage()
    personnage.ajouterPotion(Personnage.Potion("Potion de guérison", 30))
    personnage.boirePotion() // Le personnage boit la potion de guérison et récupère 30 points de vie.
    personnage.boirePotion() // Le personnage n'a pas de potion dans son inventaire.
}
```
## Introduction

Ce rapport présente les problèmes de code rencontrés et les solutions proposées jusqu'à présent dans le cadre du développement du projet. Les éléments suivants ont été discutés et résolus pour assurer le bon fonctionnement du code.

## Problèmes Rencontrés

Problème : Absence de définition des méthodes et des variables nécessaires dans la fonction tourDeMonstre().
Solution : Les méthodes telles que aUnePotion(), boirePotion(), attaque(), ainsi que les variables monstre, jeu, et joueur doivent être correctement définies dans les classes correspondantes.

Problème : Erreurs de logique dans la fonction tourDeMonstre().
Solution : La logique de la fonction a été revue pour s'assurer que le monstre attaque le joueur dans certaines conditions spécifiques et boit une potion avec une probabilité de 10% lorsque ses points de vie sont faibles.

## Solutions Apportées

Les classes Monstre et Joueur ont été correctement définies avec les méthodes aUnePotion(), boirePotion() et attaque(), ainsi que les propriétés nécessaires telles que nom, pointDeVie et pointDeVieMax.

La fonction tourDeMonstre() a été modifiée pour inclure la logique permettant au monstre d'attaquer le joueur et de boire une potion selon des conditions spécifiques.

## Conclusion

Les problèmes de code ont été identifiés et résolus avec succès. Les modifications apportées à la fonction tourDeMonstre() garantissent désormais un comportement cohérent et attendu du monstre dans le jeu. Il est essentiel de maintenir ces solutions à jour et de continuer à surveiller le code pour assurer un fonctionnement stable du projet.
## Classe Arme et Armure
Il a fallu créer une classe Arme ainsi qu'une classe Armure pour pouvoir créer des objets correspondants pour pouvoir offrir des bonus de statistiques. 
Voilà donc le code des deux classes et leurs méthodes associées:
```kotlin
class Arme(nom: String, val type: TypeArme, val qualite: Qualite, description: String):Item(nom, description) {


    fun calculDegat(): Int {
        var desDegats = TirageDes(this.type.nombreDes, 8).lance()
        val deCritique = TirageDes(1, 20).lance()
        if (deCritique >= this.type.activationCritique) {
            // desDegats * this.type.multiplicateurCritique +   this.qualite.bonusRarete

            desDegats *= this.type.multiplicateurCritique
            println("Coup critique")


        }

            desDegats+= this.qualite.bonusRarete

        return desDegats
    }


    override fun utiliser(cible: Personnage) {

    }


}
```
----
```kotlin
class Armure (nom:String, description:String, val type:TypeArmure, val qualite: Qualite):Item(nom,description){
    fun calculProtection(): Int {
        val bonusProtection=this.type.bonusType+this.qualite.bonusRarete
        return bonusProtection
    }
    override fun utiliser(cible: Personnage) {

    }
}
```
## Sort de Soin

Un sort de soin a été créé comme suit :
----
```kotlin
val sortDeSoin = object : Sort("Sort de Soin", 10) {
    override fun effet(caster: Personnage, cible: Personnage) {
        // Logique du soin ici
    }
}
```
----

Ce sort de soin a une puissance de soin de 80 et est capable de soigner un personnage lorsqu'il est lancé.

## Arme Magique

Une arme magique a été créée comme suit :
----
```kotlin
val armeMagique= Sort("arme magique", { caster, cible ->
    run {
        val tirageDes=TirageDes(nbDe = 1, maxDe = 20)
        val resultat=tirageDes.lance()
        val qualite = if (resultat<5)
            qualiteCommun
        else if (resultat<10)
            qualiteRare
        else if (resultat<15)
            qualiteEpic
        else
            qualiteLegendaire
        val arme= Arme("armeMagique", typeEpeeLongue, qualite ,"une arme magique" )
        cible.inventaire.add(arme)
        println("Une arme magique a été ajoutée à l'inventaire.")
        cible.armePrincipal=arme
    }
}
)
```
----

Cette arme magique, nommée "armeMagique", peut infliger des dégâts à un personnage lorsqu'elle est utilisée.

## Armure Magique

Une armure magique a été créée comme suit :
----
```kotlin
val armureMagique= Sort("armure magique", { caster, cible ->
    run {
        val tirageDes = TirageDes(nbDe = 1, maxDe = 20)
        val resultat = tirageDes.lance()
        val qualite = if (resultat < 5)
            qualiteCommun
        else if (resultat < 10)
            qualiteRare
        else if (resultat < 15)
            qualiteEpic
        else
            qualiteLegendaire
        val armure = Armure("armure en cuir", "une armure bien sérrée", typeArmureCuir, qualite)
        cible.inventaire.add(armure)
        println("Une armure magique a été ajoutée à l'inventaire.")
        cible.armure = armure
    }
}
)
```
## Tour du joueur
Le tour du joueur n'existant pas à l'origine, nous avons du le créer et l'améliorer au fur et à mesure.

Au commencement on n'avait la possibilité que d'attaquer l'ennemi ou de passer notre tour puis plusieurs options se sont rajoutées comme la possibilité de jeter un sort, de voler un objet à un ennemi, ou se soigner. Tout cela a abouti à ce code pour la méthode tourDeJoueur
```kotlin
fun tourDeJoueur() {
        println("\u001B[34m ---Tour de ${this.jeu.joueur.nom} (pv: ${this.jeu.joueur.pointDeVie}) ---")
       //TODO Mission 1.2
        println("Qu'allez vous faire ?")
        println("1. Attaquer")
        println("2. Boire une potion")
        println("3. lancer un sort")
        println("4. Voler")
        println("5. Passer votre tour")
        var choixOption = readln()
        while (choixOption!="1" && choixOption!="2" && choixOption!="3" && choixOption!="4" && choixOption!="5"){
            println("Qu'allez vous faire ?")
            println("1. Attaquer")
            println("2. Boire une potion")
            println("3. Lancer un sort")
            println("4. Voler")
            println("5. Passer votre tour")
            choixOption = readln()
        }
        when (choixOption) {
            "1" -> {
                this.jeu.joueur.attaque(monstre)
            }
            "2" -> {
                this.jeu.joueur.boirePotion()
            }
            "3" -> {
                val mage=this.jeu.joueur as Mage
                mage.choisirEtLancerSort(monstre)
            }
            "4" -> {
                val voleur= this.jeu.joueur as Voleur
                voleur.voler(monstre)
            }
            "5" -> {
                println("Le joueur passe son tour.")
            }
        }
        println("\u001b[0m")
    }
```

sources utilisées: Kotlin, Baldur's Gate 4
