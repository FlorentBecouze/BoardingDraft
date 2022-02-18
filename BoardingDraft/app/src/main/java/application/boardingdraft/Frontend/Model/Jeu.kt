package application.boardingdraft.Frontend.Model

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Jeu(
    @PrimaryKey(autoGenerate = true) val NoJeu: Int = 0,
    val NomJeu: String,
    val DescriptionJeu: String,
    val Photo: Bitmap) {
}
