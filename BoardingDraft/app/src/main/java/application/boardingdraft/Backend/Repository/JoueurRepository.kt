package application.boardingdraft.Backend.Repository

import androidx.lifecycle.LiveData
import application.boardingdraft.Backend.DAL.JoueurDAO
import application.boardingdraft.Frontend.Model.Joueur

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