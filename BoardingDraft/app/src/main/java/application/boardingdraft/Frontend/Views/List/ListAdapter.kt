package application.boardingdraft.Frontend.Views.List

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import application.boardingdraft.Frontend.Model.Joueur
import application.boardingdraft.R

interface IJoueur {
    fun onButtonSuppJoueurClicked(joueur:Joueur)
}

class ListAdapter(var listeJoueurs: List<Joueur>, val interfaceJoueur: IJoueur) : RecyclerView.Adapter<Cellule>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Cellule {
        val inflater = LayoutInflater.from(parent.context)
        val view : View = inflater.inflate(R.layout.cellule_liste, parent, false)
        return Cellule(view)
    }

    override fun onBindViewHolder(holder: Cellule, position: Int) {
        holder.textViewJoueur.text = listeJoueurs[position].PrenomJoueur

        holder.imageButtonSuppJoueur.setOnClickListener {

            val joueur = listeJoueurs[position]
            interfaceJoueur.onButtonSuppJoueurClicked(joueur)
        }
    }

    override fun getItemCount(): Int {
        return listeJoueurs.count()
    }
}


class Cellule(view: View) : RecyclerView.ViewHolder(view) {
    val textViewJoueur: TextView = view.findViewById<TextView>(R.id.textview_cellule)
    val imageButtonSuppJoueur: ImageButton = view.findViewById<ImageButton>(R.id.imageButton_add_cellule)
}

