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

    var navHostFragment: NavHostFragment? = null
    var navController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Cacher l'entete de l'application pour la mettre en fullscreen
        this.getSupportActionBar()!!.hide();

        // Affichage de l'activity principale de l'application
        setContentView(R.layout.activity_accueil)

        navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment?.navController

        // Affichage du fragment contenu par l'activity principale de l'application
        //supportFragmentManager.commit{
        //    replace<AccueilFragment>(R.id.fragment_accueil)
        //}
    }

    fun passerAuFragmentVote(view: View) {
        //supportFragmentManager.commit{
        //    replace<VoteJeuxFragment>(R.id.fragment_accueil)
        //    addToBackStack(null)
        //}


    //navController?.navigate(R.id.action_accueilFragment_to_voteJeuxFragment)
    }
}
