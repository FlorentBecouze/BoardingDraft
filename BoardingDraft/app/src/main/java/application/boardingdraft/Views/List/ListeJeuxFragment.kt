package application.boardingdraft.Views.List

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import application.boardingdraft.R


class ListeJeuxFragment : Fragment(R.layout.fragment_liste_jeux) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textListe = listOf("Thomas", "Julien", "Antoine", "Clément", "Marc", "Joseph")

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view_accueil)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = ListAdapter(textListe)
    }

}