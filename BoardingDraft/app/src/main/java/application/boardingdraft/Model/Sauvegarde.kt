package application.boardingdraft.Model

import android.os.Debug
import android.util.JsonWriter
import android.util.Log
import android.widget.Toast
import kotlinx.serialization.*
import kotlinx.serialization.json.*
import java.net.ContentHandler

@Serializable
data class JoueurData(var name: String) {
    var listeJeuxFavoris: ArrayList<Jeux> = ArrayList<Jeux>()
}

@Serializable
data class JeuxData(var name: String)


class Sauvegarde(listeJoueurs:ArrayList<Joueur>) {
    var liste: ArrayList<Joueur> = listeJoueurs

    fun main() {
        // Serializing objects
        //val data = JoueurData("Kévin")
        val string = Json.encodeToString(liste[0].joueurData.name)
        Log.v("Prénom", string)
        // Deserializing back into objects
        val obj = Json.decodeFromString<JoueurData>(string)
        Log.v("Objet", obj.name)
    }
}

