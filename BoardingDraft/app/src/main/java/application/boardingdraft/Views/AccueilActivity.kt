package application.boardingdraft.Views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import application.boardingdraft.R
import androidx.fragment.app.commit
import androidx.fragment.app.replace

class AccueilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Cacher l'entete de l'application pour la mettre en fullscreen
        this.getSupportActionBar()!!.hide();

        // Affichage de l'activity principale de l'application
        setContentView(R.layout.activity_accueil)

        // Affichage du fragment contenant la RecyclerView de la liste des joueurs sur la page d'accueil
        supportFragmentManager.commit{
            replace<AccueilFragment>(R.id.fragment_accueil)
        }
    }
}