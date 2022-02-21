package application.boardingdraft.Frontend.Views.List

import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import application.boardingdraft.Frontend.Model.Jeu
import application.boardingdraft.R

class ListAdapterJeu(var listeJeux: List<Jeu>) : RecyclerView.Adapter<ListAdapterJeu.CelluleJeu>() {

    interface IJeu {
        fun onButtonJeuClickedListener(position: Int)
    }

    private lateinit var my_listener_interface: IJeu

    fun setOnButtonJeuClickedListener(listener: IJeu) {
        my_listener_interface = listener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CelluleJeu {
        val inflater = LayoutInflater.from(parent.context)
        val view : View = inflater.inflate(R.layout.cellule_liste_jeux, parent, false)
        return CelluleJeu(view, my_listener_interface)
    }

    override fun onBindViewHolder(holder: CelluleJeu, position: Int) {
        holder.textViewJeu.text = listeJeux[position].NomJeu
        holder.imageViewJeu.setImageBitmap(listeJeux[position].Photo)
    }

    override fun getItemCount(): Int {
        return listeJeux.count()
    }


    class CelluleJeu(view: View, listener: IJeu) : RecyclerView.ViewHolder(view) {
        var textViewJeu: TextView = view.findViewById<TextView>(R.id.textView_cellule_jeu)
        var imageViewJeu: ImageView = view.findViewById<ImageView>(R.id.imageView_cellule_jeu)

        init {
            view.setOnClickListener {
                listener.onButtonJeuClickedListener(adapterPosition)
            }
        }
    }
}


