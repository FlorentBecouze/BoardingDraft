package application.boardingdraft.Frontend.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

//class Joueur(var joueurData: JoueurData) {

//}

@Entity
data class Joueur(
    @PrimaryKey(autoGenerate = true) val NoJoueur: Int,
    val NomJoueur: String,
    val PrenomJoueur: String) {
}
