package application.boardingdraft.Frontend.ViewModel

import android.app.Application
import androidx.lifecycle.*
import application.boardingdraft.Backend.BDD.AppDatabase
import application.boardingdraft.Backend.Repository.JeuRepository
import application.boardingdraft.Frontend.Model.Jeu
import kotlinx.coroutines.launch

class JeuViewModel(application: Application) : AndroidViewModel(application) {
    private val database: AppDatabase by lazy { AppDatabase.getDatabase(getApplication<Application>().applicationContext) }

    private val jeuRepository: JeuRepository by lazy { JeuRepository(database.jeuDao()) }

    val currentListeJeux: LiveData<List<Jeu>> by lazy {
        jeuRepository.getAllJeu()
    }

    fun getJeu(id : Int) : LiveData<Jeu?> {
        return jeuRepository.getJeu(id)
    }

    fun insererJeu(jeu: Jeu) {
        viewModelScope.launch {
            jeuRepository.insererJeu(jeu)
        }
    }

    fun supprimerJeu(jeu: Jeu) {
        viewModelScope.launch {
            jeuRepository.supprimerJeu(jeu)
        }
    }
}