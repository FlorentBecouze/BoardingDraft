package application.boardingdraft.Frontend.Model

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

// Objet utilisé dans l'application et représenté dans la BDD par une table portant le même nom.
@Entity
data class Jeu(
    @PrimaryKey(autoGenerate = true) val NoJeu: Int = 0,
    val NomJeu: String,
    val DescriptionJeu: String,
    val Photo: Bitmap) {
}
