package application.boardingdraft.Frontend.Views.List

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import application.boardingdraft.Frontend.Model.Joueur
import application.boardingdraft.R

class ListAdapter(val listeJoueurs: ArrayList<Joueur>) : RecyclerView.Adapter<Cellule>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Cellule {
        val inflater = LayoutInflater.from(parent.context)
        val view : View = inflater.inflate(R.layout.cellule_liste, parent, false)
        return Cellule(view)
    }

    override fun onBindViewHolder(holder: Cellule, position: Int) {
        //holder.textViewJoueur.text = listeJoueurs[position].joueurData.name
        holder.textViewJoueur.text = listeJoueurs[position].NomJoueur
    }

    override fun getItemCount(): Int {
        return listeJoueurs.count()
    }
}


class Cellule(view: View) : RecyclerView.ViewHolder(view) {
    val textViewJoueur: TextView = view.findViewById<TextView>(R.id.textview_cellule)
    val imageButtonSuppJoueur: ImageButton = view.findViewById<ImageButton>(R.id.imageButton_add_cellule)
}



