package application.boardingdraft.Backend.DAL

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import application.boardingdraft.Frontend.Model.Joueur

// DAO : Data Access Object     DAL : Data Access Layer
// Cette interface est la dernière couche avant la BDD et c'est elle qui y est directement connectée.
// Elle lance les différentes procédures SQL.
@Dao
interface JoueurDAO {
    // Ces méthodes ne sont pas en "suspend" car elles retournent des LiveData
    // Les LiveData possèdent déjà un système pour lancer les méthodes dans des threads différents
    @Query("SELECT * FROM Joueur")
    fun getAllJoueur(): LiveData<List<Joueur>>

    @Query("SELECT * FROM Joueur WHERE NoJoueur = :id")
    fun getJoueur(id: Int) : LiveData<Joueur?>

    @Insert
    suspend fun insertJoueur(j: Joueur) : Long

    @Insert
    suspend fun insertTabJoueurs(tabJoueurs: List<Joueur>)

    @Query("DELETE FROM Joueur WHERE NoJoueur = :id")
    suspend fun deleteJoueur(id: Int)
}