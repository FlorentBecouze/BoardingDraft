package application.boardingdraft.Frontend.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

// Objet utilisé dans l'application et représenté dans la BDD par une table portant le même nom.
@Entity
data class Joueur(
    @PrimaryKey(autoGenerate = true) val NoJoueur: Int = 0,
    val PrenomJoueur: String) {
}
