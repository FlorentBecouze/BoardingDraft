package application.boardingdraft.Views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Adapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import application.boardingdraft.Model.Joueur
import application.boardingdraft.R
import application.boardingdraft.Views.List.ListAdapter


class AccueilFragment : Fragment(R.layout.fragment_accueil) {
    var listeJoueurs:MutableList<Joueur> = mutableListOf<Joueur>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view_accueil_liste_joueurs)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = ListAdapter(listeJoueurs)

        var bouton_accueil_voter = view?.findViewById<Button>(R.id.bouton_accueil_voter)
        bouton_accueil_voter.setOnClickListener {
            //ON SEST ARRETE LA, A ESSAYER DE SAUVEGARDER DANS UN JSON
        }

        var bouton_accueil_liste_jeux = view?.findViewById<Button>(R.id.bouton_accueil_liste_jeux)
        bouton_accueil_liste_jeux.setOnClickListener {

        }

        var bouton_add_joueur = view?.findViewById<ImageButton>(R.id.bouton_add_joueur)
        bouton_add_joueur.setOnClickListener {
            val nameNewJoueur: String = view?.findViewById<EditText>(R.id.saisie_joueur).text.toString()
            if(nameNewJoueur != "" && nameNewJoueur.get(0) != ' ') {
                listeJoueurs.add(Joueur(view?.findViewById<EditText>(R.id.saisie_joueur).text.toString()))
                recyclerView.adapter!!.notifyDataSetChanged()
            }
        }
    }
}