package application.boardingdraft.Frontend.Views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.*
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import application.boardingdraft.Frontend.Model.Joueur
import application.boardingdraft.Frontend.ViewModel.JoueurViewModel
import application.boardingdraft.Frontend.Views.List.IJoueur
import application.boardingdraft.R
import application.boardingdraft.Frontend.Views.List.ListAdapterJoueur

class AccueilFragment : Fragment(R.layout.fragment_accueil), IJoueur {

    // Accès aux méthodes de récupération / modifications de données de la BDD.
    val joueurViewModel:JoueurViewModel by viewModels()
    var recyclerView:RecyclerView? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Lien entre la recyclerView affichée et son adaptateur
        recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view_liste_joueurs)
        recyclerView?.layoutManager = LinearLayoutManager(requireContext())
        recyclerView?.adapter = ListAdapterJoueur(emptyList(), this)

        // Observation en directe de la liste des joueurs
        joueurViewModel.currentListeJoueurs.observe(viewLifecycleOwner) {
                joueurs:List<Joueur> ->
            (recyclerView?.adapter!! as ListAdapterJoueur).listeJoueurs = joueurs
            recyclerView?.adapter!!.notifyDataSetChanged()
        }


        val bouton_accueil_voter = view.findViewById<Button>(R.id.bouton_accueil_voter)
        bouton_accueil_voter.setOnClickListener {
            // Affichage du fragment de "vote"
            findNavController().navigate(R.id.action_accueilFragment_to_voteJeuxFragment)
        }

        val bouton_accueil_liste_jeux = view.findViewById<Button>(R.id.bouton_accueil_liste_jeux)
        bouton_accueil_liste_jeux.setOnClickListener {
            // Affichage du fragment de "jeux"
            findNavController().navigate(R.id.action_accueilFragment_to_jeuxFragment)
        }

        val bouton_add_joueur = view.findViewById<ImageButton>(R.id.bouton_add_joueur)
        bouton_add_joueur.setOnClickListener {
            // Récupération du texte saisi par l'utilisateur
            val nameNewJoueur: String = view.findViewById<EditText>(R.id.saisie_joueur).text.toString()

            // Si le champs est rempli et que les premiers caractères ne sont pas des espaces
            if(nameNewJoueur != "" && nameNewJoueur.get(0) != ' ') {
                val textView = view.findViewById<EditText>(R.id.saisie_joueur)

                // Insertion du nouveau joueur dans la BDD
                joueurViewModel.insererJoueur(Joueur(PrenomJoueur = textView.text.toString()))

                // Suppression du texte dans le champs de saisie
                textView.text.clear()
            }
        }
    }

    // Implémentation de la méthode de l'interface "IJoueur"
    override fun onButtonSuppJoueurClicked(joueur: Joueur) {
        // Suppression du joueur dans la BDD
        joueurViewModel.supprimerJoueur(joueur)
    }



}

