package application.boardingdraft.Views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast
import application.boardingdraft.R
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import application.boardingdraft.Views.List.ListeJoueursFragment

class AccueilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Cacher l'entete de l'application pour la mettre en fullscreen
        this.getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.getSupportActionBar()!!.hide();

        // Affichage de l'activity principale de l'application
        setContentView(R.layout.activity_accueil)

        // Affichage du fragment contenant la RecyclerView de la liste des joueurs
        supportFragmentManager.commit{
            replace<ListeJoueursFragment>(R.id.fragment_recycler_view_accueil_liste_joueurs)
        }

        var bouton_accueil_voter = findViewById<Button>(R.id.bouton_accueil_voter)
        bouton_accueil_voter.setOnClickListener {
            Toast.makeText(baseContext, "bouton voter", Toast.LENGTH_SHORT).show()
        }

        var bouton_accueil_liste_jeux = findViewById<Button>(R.id.bouton_accueil_liste_jeux)
        bouton_accueil_liste_jeux.setOnClickListener {
            Toast.makeText(baseContext, "bouton liste jeux", Toast.LENGTH_SHORT).show()
            supportFragmentManager.commit {
                replace<VoteJeuxFragment>(R.id.fragment_page_liste_jeux)
            }
        }
    }
}