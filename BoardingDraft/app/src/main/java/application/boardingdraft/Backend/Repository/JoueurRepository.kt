package application.boardingdraft.Backend.Repository

import androidx.lifecycle.LiveData
import application.boardingdraft.Backend.DAL.JoueurDAO
import application.boardingdraft.Frontend.Model.Joueur

// Declares the DAO as a private property in the constructor. Pass in the DAO
// instead of the whole database, because you only need access to the DAO
class JoueurRepository(private val joueurDao: JoueurDAO) {

    @Suppress("RedundantSuspendModifier")

    fun getAllJoueur() : LiveData<List<Joueur>> {
        return joueurDao.getAllJoueur()
    }

    fun getJoueur(id : Int) : LiveData<Joueur?> {
        return joueurDao.getJoueur(id)
    }

    suspend fun insererJoueur(joueur: Joueur) : Long {
        return joueurDao.insertJoueur(joueur)
    }

    suspend fun supprimerJoueur(joueur: Joueur) {
        joueurDao.deleteJoueur(joueur.NoJoueur)
    }
}