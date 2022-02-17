package application.boardingdraft.Frontend.Views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import application.boardingdraft.R
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.room.Room
import application.boardingdraft.Backend.BDD.AppDatabase

class AccueilActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Cacher l'entete de l'application pour la mettre en fullscreen
        this.getSupportActionBar()!!.hide();

        // Affichage de l'activity principale de l'application
        setContentView(R.layout.activity_accueil)
    }
}
