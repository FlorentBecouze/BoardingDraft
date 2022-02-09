package application.boardingdraft.Frontend.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Joueur(
    @PrimaryKey(autoGenerate = true) val NoJoueur: Int = 0,
    val PrenomJoueur: String) {
}
