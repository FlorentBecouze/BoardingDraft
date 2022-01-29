package application.boardingdraft.Frontend.Model


//import kotlinx.serialization.*
//import kotlinx.serialization.json.*

//@Serializable
data class JoueurData(var name: String) {
    //var listeJeuxFavoris: ArrayList<Jeux> = ArrayList<Jeux>()
}

//@Serializable
data class JeuxData(var name: String)


class Sauvegarde(listeJoueurs:ArrayList<Joueur>) {
    //var liste: ArrayList<Joueur> = listeJoueurs

    fun main() {
        // Serializing objects
        //val data = JoueurData("Kévin")
        //val string = Json.encodeToString(liste[0].joueurData.name)
        //Log.v("Prénom", string)
        // Deserializing back into objects
        //val obj = Json.decodeFromString<JoueurData>(string)
        //Log.v("Objet", obj.name)

        //val listeData = arrayListOf<JoueurData>()
        //liste.forEach {
        //    listeData.add(it.joueurData)
        //}
        //println("------ Liste à sérialiser : " + listeData)

        //val json = Json.encodeToString(listeData)
        //println("------ JSON : " + json)

        //val obj = Json.decodeFromString<JoueurData>(json)
        //println("------ Objet : " + obj.name)
    }
}

