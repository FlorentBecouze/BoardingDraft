package application.boardingdraft.Views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import application.boardingdraft.R
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import application.boardingdraft.Views.List.ListeJeuxFragment

class AccueilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Cacher l'entete de l'application pour la mettre en fullscreen
        this.getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.getSupportActionBar()!!.hide();

        setContentView(R.layout.activity_accueil)

        supportFragmentManager.commit{
            replace<ListeJeuxFragment>(R.id.fragment_recycler_view_accueil)
        }
    }
}