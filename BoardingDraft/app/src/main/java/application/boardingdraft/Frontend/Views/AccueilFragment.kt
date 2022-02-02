package application.boardingdraft.Frontend.Views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.*
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import application.boardingdraft.Backend.BDD.AppDatabase
import application.boardingdraft.Backend.DAL.JoueurDAO
import application.boardingdraft.Frontend.Model.Joueur
import application.boardingdraft.Frontend.Views.List.IJoueur
import application.boardingdraft.R
import application.boardingdraft.Frontend.Views.List.ListAdapter
import kotlinx.coroutines.launch


class AccueilFragment : Fragment(R.layout.fragment_accueil), IJoueur {

    var database:AppDatabase? = null
    var listeJoueurs:ArrayList<Joueur> = ArrayList<Joueur>()
    var recyclerView:RecyclerView? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        database = Room.databaseBuilder(requireContext(), AppDatabase::class.java, "Notre_base").build()

        recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view_accueil_liste_joueurs)
        recyclerView!!.layoutManager = LinearLayoutManager(requireContext())
        recyclerView!!.adapter = ListAdapter(listeJoueurs, this)

        var bouton_accueil_voter = view?.findViewById<Button>(R.id.bouton_accueil_voter)
        bouton_accueil_voter.setOnClickListener {
            Toast.makeText(context, "testtest", Toast.LENGTH_SHORT).show()
        }

        var bouton_accueil_liste_jeux = view?.findViewById<Button>(R.id.bouton_accueil_liste_jeux)
        bouton_accueil_liste_jeux.setOnClickListener {

        }

        var bouton_add_joueur = view?.findViewById<ImageButton>(R.id.bouton_add_joueur)
        bouton_add_joueur.setOnClickListener {
            val nameNewJoueur: String = view?.findViewById<EditText>(R.id.saisie_joueur).text.toString()
            if(nameNewJoueur != "" && nameNewJoueur.get(0) != ' ') {
                val monJoueurDao = database!!.joueurDao()
                val textView = view?.findViewById<EditText>(R.id.saisie_joueur)
                var joueur:Joueur? = null

                lifecycleScope.launch {
                    insererJoueur(monJoueurDao, Joueur(PrenomJoueur=textView.text.toString()))
                    //joueur = insererJoueur(....
                }

                //ON SEST ARRETE LA, On CHERCHAIT COMMENT FAIRE POUR QUE INSERT DE DAO RETOURNE LE JOUEUR
                //AFIN QUON PUISSE LE SUPPRIMER DE LA LISTE CAR LE NUMERO NE SE GENERE AUTOMATIQUEMENT QUA LINSERTION


                listeJoueurs.add(joueur)
                textView.text.clear()

                recyclerView!!.adapter!!.notifyDataSetChanged()
            }
        }
    }

    override fun onButtonSuppJoueurClicked(joueur: Joueur) {
        val monJoueurDao = database!!.joueurDao()

        listeJoueurs.remove(joueur)

        lifecycleScope.launch {
            supprimerJoueur(monJoueurDao, joueur)
        }

        recyclerView!!.adapter!!.notifyDataSetChanged()
    }

    suspend fun insererJoueur(dao:JoueurDAO, joueur: Joueur) {
        dao.insertJoueur(joueur)
    }

    suspend fun supprimerJoueur(dao:JoueurDAO, joueur: Joueur) {
        dao.deleteJoueur(joueur.NoJoueur)
    }
}

