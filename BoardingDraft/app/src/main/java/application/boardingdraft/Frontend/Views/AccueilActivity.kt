package application.boardingdraft.Frontend.Views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import application.boardingdraft.R

class AccueilActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Cacher l'entête de l'application pour la mettre en fullscreen
        this.getSupportActionBar()!!.hide();

        // Affichage de l'activity principale de l'application
        setContentView(R.layout.activity_accueil)
    }
}
