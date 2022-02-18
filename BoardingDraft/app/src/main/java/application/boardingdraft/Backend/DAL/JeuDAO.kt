package application.boardingdraft.Backend.DAL

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import application.boardingdraft.Frontend.Model.Jeu

@Dao
interface JeuDAO {
    // Ces méthodes ne sont pas en "suspend" car elles retournent des LiveData
    // Les LiveData possèdent déjà un système pour lancer les méthodes dans des threads différents
    @Query("SELECT * FROM Jeu")
    fun getAllJeu(): LiveData<List<Jeu>>

    @Query("SELECT * FROM Jeu WHERE NoJeu = :id")
    fun getJeu(id: Int) : LiveData<Jeu?>

    @Insert
    suspend fun insertJeu(j: Jeu) : Long

    @Insert
    suspend fun insertTabJeux(tabJeux: List<Jeu>)

    @Query("DELETE FROM Jeu WHERE NoJeu = :id")
    suspend fun deleteJeu(id: Int)
}