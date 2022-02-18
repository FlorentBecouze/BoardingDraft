package application.boardingdraft.Frontend.Views.List

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import application.boardingdraft.Frontend.Model.Jeu
import application.boardingdraft.R

interface IJeu {
    fun onButtonJeuClicked(jeu: Jeu)
}

class ListAdapterJeu(var listeJeux: List<Jeu>, val interfaceJeu: IJeu) : RecyclerView.Adapter<CelluleJeu>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CelluleJeu {
        val inflater = LayoutInflater.from(parent.context)
        val view : View = inflater.inflate(R.layout.cellule_liste_jeux, parent, false)
        return CelluleJeu(view)
    }

    override fun onBindViewHolder(holder: CelluleJeu, position: Int) {
        holder.boutonJeu.text = listeJeux[position].NomJeu
        holder.boutonJeu.setOnClickListener {
            interfaceJeu.onButtonJeuClicked(listeJeux[position])
        }

        holder.imageViewJeu.setImageBitmap(listeJeux[position].Photo)
    }

    override fun getItemCount(): Int {
        return listeJeux.count()
    }
}


class CelluleJeu(view: View) : RecyclerView.ViewHolder(view) {
    val boutonJeu: Button = view.findViewById<Button>(R.id.bouton_cellule_jeu)
    val imageViewJeu: ImageView = view.findViewById<ImageView>(R.id.imageView_cellule_jeu)
}

