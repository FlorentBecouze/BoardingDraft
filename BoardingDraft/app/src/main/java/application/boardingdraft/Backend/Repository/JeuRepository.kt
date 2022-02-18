package application.boardingdraft.Backend.Repository

import androidx.lifecycle.LiveData
import application.boardingdraft.Backend.DAL.JeuDAO
import application.boardingdraft.Frontend.Model.Jeu

class JeuRepository(private val jeuDao: JeuDAO) {

    @Suppress("RedundantSuspendModifier")

    fun getAllJeu() : LiveData<List<Jeu>> {
        return jeuDao.getAllJeu()
    }

    fun getJeu(id : Int) : LiveData<Jeu?> {
        return jeuDao.getJeu(id)
    }

    suspend fun insererJeu(jeu: Jeu) : Long {
        return jeuDao.insertJeu(jeu)
    }

    suspend fun supprimerJeu(jeu: Jeu) {
        jeuDao.deleteJeu(jeu.NoJeu)
    }
}