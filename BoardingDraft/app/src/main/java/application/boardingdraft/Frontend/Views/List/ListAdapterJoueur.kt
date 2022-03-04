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

// Classe permettant de lier la liste des joueurs avec l'affichage désiré de cette liste
// Utilisée par la recylerView pour afficher correctement les données de chaque joueur
class ListAdapterJoueur(var listeJoueurs: List<Joueur>, val interfaceJoueur: IJoueur) : RecyclerView.Adapter<CelluleJoueur>() {

    // Méthode lancée lors de la création d'une cellule de la recyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CelluleJoueur {
        val inflater = LayoutInflater.from(parent.context)

        // Récupération du design d'une cellule
        val view : View = inflater.inflate(R.layout.cellule_liste_joueurs, parent, false)

        return CelluleJoueur(view)
    }

    // Méthode lancée lors de chaque changement dans la recyclerView
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


// Classe représentant la cellule à afficher dans la recyclerView
class CelluleJoueur(view: View) : RecyclerView.ViewHolder(view) {
    val textViewJoueur: TextView = view.findViewById<TextView>(R.id.textview_cellule_joueur)
    val imageButtonSuppJoueur: ImageButton = view.findViewById<ImageButton>(R.id.imageButton_add_cellule_joueur)
}

