package application.boardingdraft.Backend.DAL

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import application.boardingdraft.Frontend.Model.Joueur

@Dao
interface JoueurDAO {
    @Query("SELECT * FROM Joueur")
    fun getAllJoueur(): List<Joueur>

    @Query("SELECT * FROM Joueur WHERE NomJoueur LIKE :nom " +
            "AND PrenomJoueur LIKE :prenom")
    fun getJoueur(nom: String, prenom: String) : Joueur

    @Insert
    suspend fun insertJoueur(j: Joueur)

    @Insert
    fun insertTabJoueurs(tabJoueurs: List<Joueur>)

    @Delete
    fun deleteJoueur(j: Joueur)
}