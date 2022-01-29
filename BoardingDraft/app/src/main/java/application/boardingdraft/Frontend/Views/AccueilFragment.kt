package application.boardingdraft.Frontend.Views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import application.boardingdraft.Backend.BDD.AppDatabase
import application.boardingdraft.Frontend.Model.Joueur
import application.boardingdraft.Frontend.Model.JoueurData
import application.boardingdraft.Frontend.Model.Sauvegarde
import application.boardingdraft.R
import application.boardingdraft.Frontend.Views.List.ListAdapter


class AccueilFragment : Fragment(R.layout.fragment_accueil) {

    var listeJoueurs:ArrayList<Joueur> = ArrayList<Joueur>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var save: Sauvegarde

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view_accueil_liste_joueurs)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = ListAdapter(listeJoueurs)

        var bouton_accueil_voter = view?.findViewById<Button>(R.id.bouton_accueil_voter)
        bouton_accueil_voter.setOnClickListener {
            //ON SEST ARRETE LA, A ESSAYER DE SAUVEGARDER DANS UN JSON
            //save = Sauvegarde(listeJoueurs)
            //save.main()
            Toast.makeText(context, "testtest", Toast.LENGTH_SHORT).show()
        }

        var bouton_accueil_liste_jeux = view?.findViewById<Button>(R.id.bouton_accueil_liste_jeux)
        bouton_accueil_liste_jeux.setOnClickListener {

        }

        var bouton_add_joueur = view?.findViewById<ImageButton>(R.id.bouton_add_joueur)
        bouton_add_joueur.setOnClickListener {
            val nameNewJoueur: String = view?.findViewById<EditText>(R.id.saisie_joueur).text.toString()
            if(nameNewJoueur != "" && nameNewJoueur.get(0) != ' ') {
                //listeJoueurs.add(Joueur(JoueurData(view?.findViewById<EditText>(R.id.saisie_joueur).text.toString())))

                val database = Room.databaseBuilder(requireContext(), AppDatabase::class.java, "Notre_base").build()
                val mon_joueurDao = database.joueurDao()
                val joueur1: Joueur = Joueur(1,"Nom 1", "Prénom 1")
                val joueur2: Joueur = Joueur(2,"Nom 1", "Prénom 1")

                //mon_joueurDao.insertJoueur(joueur1)
                //mon_joueurDao.insertJoueur(joueur2)


                recyclerView.adapter!!.notifyDataSetChanged()
            }
        }
    }
}