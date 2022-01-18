package application.boardingdraft.Views.List

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import application.boardingdraft.R

class ListAdapter(val liste: List<String>) : RecyclerView.Adapter<Cellule>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Cellule {
        val inflater = LayoutInflater.from(parent.context)
        val view : View = inflater.inflate(R.layout.cellule_liste, parent, false)
        return Cellule(view)
    }

    override fun onBindViewHolder(holder: Cellule, position: Int) {
        holder.textView.text = liste[position]
    }

    override fun getItemCount(): Int {
        return liste.count()
    }
}


class Cellule(view: View) : RecyclerView.ViewHolder(view) {
    val textView: TextView = view as TextView
}



