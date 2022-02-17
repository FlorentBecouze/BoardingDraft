package application.boardingdraft.Frontend.Views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.*
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import application.boardingdraft.Backend.BDD.AppDatabase
import application.boardingdraft.Backend.DAL.JoueurDAO
import application.boardingdraft.Backend.Repository.JoueurRepository
import application.boardingdraft.Frontend.Model.Joueur
import application.boardingdraft.Frontend.ViewModel.JoueurViewModel
import application.boardingdraft.Frontend.Views.List.IJoueur
import application.boardingdraft.R
import application.boardingdraft.Frontend.Views.List.ListAdapter
import kotlinx.coroutines.launch

class AccueilFragment : Fragment(R.layout.fragment_accueil), IJoueur {

    val joueurViewModel:JoueurViewModel by viewModels()
    var recyclerView:RecyclerView? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view_accueil_liste_joueurs)
        recyclerView!!.layoutManager = LinearLayoutManager(requireContext())
        recyclerView!!.adapter = ListAdapter(emptyList(), this)

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        joueurViewModel.currentListeJoueurs.observe(viewLifecycleOwner) {
                joueurs:List<Joueur> ->
            (recyclerView!!.adapter!! as ListAdapter).listeJoueurs = joueurs
            recyclerView!!.adapter!!.notifyDataSetChanged()
        }


        var bouton_accueil_voter = view.findViewById<Button>(R.id.bouton_accueil_voter)
        bouton_accueil_voter.setOnClickListener {
            findNavController().navigate(R.id.action_accueilFragment_to_voteJeuxFragment)
        }

        var bouton_accueil_liste_jeux = view.findViewById<Button>(R.id.bouton_accueil_liste_jeux)
        bouton_accueil_liste_jeux.setOnClickListener {
            findNavController().navigate(R.id.action_accueilFragment_to_jeuxFragment)
        }

        var bouton_add_joueur = view.findViewById<ImageButton>(R.id.bouton_add_joueur)
        bouton_add_joueur.setOnClickListener {
            val nameNewJoueur: String = view.findViewById<EditText>(R.id.saisie_joueur).text.toString()
            // Si le champs est rempli et que le premier caractère n'est pas un espace
            if(nameNewJoueur != "" && nameNewJoueur.get(0) != ' ') {
                val textView = view.findViewById<EditText>(R.id.saisie_joueur)

                joueurViewModel.insererJoueur(Joueur(PrenomJoueur = textView.text.toString()))
                textView.text.clear()
            }
        }
    }

    override fun onButtonSuppJoueurClicked(joueur: Joueur) {
        joueurViewModel.supprimerJoueur(joueur)
    }



}

