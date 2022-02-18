package application.boardingdraft.Frontend.ViewModel

import android.app.Application
import androidx.lifecycle.*
import application.boardingdraft.Backend.BDD.AppDatabase
import application.boardingdraft.Backend.Repository.JoueurRepository
import application.boardingdraft.Frontend.Model.Joueur
import kotlinx.coroutines.launch

class JoueurViewModel(application: Application) : AndroidViewModel(application) {
    private val database: AppDatabase by lazy { AppDatabase.getDatabase(getApplication<Application>().applicationContext) }

    private val joueurRepository:JoueurRepository by lazy { JoueurRepository(database.joueurDao()) }

    val currentListeJoueurs: LiveData<List<Joueur>> by lazy {
        joueurRepository.getAllJoueur()
    }

    fun getJoueur(id : Int) : LiveData<Joueur?> {
        return joueurRepository.getJoueur(id)
    }

    fun insererJoueur(joueur: Joueur) {
        viewModelScope.launch {
            joueurRepository.insererJoueur(joueur)
        }
    }

    fun supprimerJoueur(joueur: Joueur) {
        viewModelScope.launch {
            joueurRepository.supprimerJoueur(joueur)
        }
    }
}