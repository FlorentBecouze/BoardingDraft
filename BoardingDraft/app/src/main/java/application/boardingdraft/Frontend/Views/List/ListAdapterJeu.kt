package application.boardingdraft.Frontend.Views.List

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import application.boardingdraft.Frontend.Model.Jeu
import application.boardingdraft.R

// Classe permettant de lier la liste des jeux avec l'affichage désiré de cette liste
// Utilisée par la recylerView pour afficher correctement les données de chaque jeu
class ListAdapterJeu(var listeJeux: List<Jeu>) : RecyclerView.Adapter<ListAdapterJeu.CelluleJeu>() {

    interface IJeu {
        fun onButtonJeuClickedListener(position: Int)
    }

    private lateinit var my_listener_interface: IJeu

    fun setOnButtonJeuClickedListener(listener: IJeu) {
        my_listener_interface = listener
    }

    // Méthode lancée lors de la création d'une cellule de la recyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CelluleJeu {
        val inflater = LayoutInflater.from(parent.context)

        // Récupération du design d'une cellule
        val view : View = inflater.inflate(R.layout.cellule_liste_jeux, parent, false)

        return CelluleJeu(view, my_listener_interface)
    }

    // Méthode lancée lors de chaque changement dans la recyclerView
    override fun onBindViewHolder(holder: CelluleJeu, position: Int) {
        holder.textViewJeu.text = listeJeux[position].NomJeu
        holder.imageViewJeu.setImageBitmap(listeJeux[position].Photo)
    }

    override fun getItemCount(): Int {
        return listeJeux.count()
    }


    // Classe représentant la cellule à afficher dans la recyclerView
    class CelluleJeu(view: View, listener: IJeu) : RecyclerView.ViewHolder(view) {
        var textViewJeu: TextView = view.findViewById<TextView>(R.id.textView_cellule_jeu)
        var imageViewJeu: ImageView = view.findViewById<ImageView>(R.id.imageView_cellule_jeu)

        // Si on clique sur une cellule
        init {
            view.setOnClickListener {
                listener.onButtonJeuClickedListener(adapterPosition)
            }
        }
    }
}


