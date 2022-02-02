package application.boardingdraft.Backend.DAL

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import application.boardingdraft.Frontend.Model.Joueur

@Dao
interface JoueurDAO {
    @Query("SELECT * FROM Joueur")
    suspend fun getAllJoueur(): List<Joueur>

    @Query("SELECT * FROM Joueur WHERE NoJoueur = :id")
    suspend fun getJoueur(id: Int) : Joueur

    @Insert
    suspend fun insertJoueur(j: Joueur)

    @Insert
    suspend fun insertTabJoueurs(tabJoueurs: List<Joueur>)//retourner un long, faire un copy d'un joueur avec cet identifiant

    @Query("DELETE FROM Joueur WHERE NoJoueur = :id")
    suspend fun deleteJoueur(id: Int)
}