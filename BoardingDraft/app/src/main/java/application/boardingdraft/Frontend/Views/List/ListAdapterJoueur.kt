package application.boardingdraft.Frontend.Views.List

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

class ListAdapterJoueur(var listeJoueurs: List<Joueur>, val interfaceJoueur: IJoueur) : RecyclerView.Adapter<CelluleJoueur>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CelluleJoueur {
        val inflater = LayoutInflater.from(parent.context)
        val view : View = inflater.inflate(R.layout.cellule_liste_joueurs, parent, false)
        return CelluleJoueur(view)
    }

    override fun onBindViewHolder(holder: CelluleJoueur, position: Int) {
        holder.textViewJoueur.text = listeJoueurs[position].PrenomJoueur

        holder.imageButtonSuppJoueur.setOnClickListener {
            interfaceJoueur.onButtonSuppJoueurClicked(listeJoueurs[position])
        }
    }

    override fun getItemCount(): Int {
        return listeJoueurs.count()
    }
}


class CelluleJoueur(view: View) : RecyclerView.ViewHolder(view) {
    val textViewJoueur: TextView = view.findViewById<TextView>(R.id.textview_cellule_joueur)
    val imageButtonSuppJoueur: ImageButton = view.findViewById<ImageButton>(R.id.imageButton_add_cellule_joueur)
}

