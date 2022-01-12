package application.boardingdraft.Controller

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView



/*

//git du prof (réponse au tp1) :
//https://github.com/openium/IsimaTp

//mettre recycler view dans le xml en drag-drop

val recyclerView = view.findviewById<RecyclerView>(R.id.recyclerview)
val textList = listOf("Thomas", "Julien", "Clément")

recyclerView.layoutManager = LinearLayoutManager(requireContext())  //GridLayoutManager(requireContext(), 2)
recyclerView.adapter = nameAdapter(textList)

//faire une ressource layout "cell"
tools:text="hello world"
textSize ...
textStyle
height = wrap_content


class NameAdapter(val list : List<String>) : RecyclerView.Adapter<Cellule>() {
    override fun onCreateViewHolder(parent: ViewGroup) {    //création des cellules
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.cell, parent, false)
        return Cellule(view)
    }

    override fun onBindViewHolder() {      //appelé à chaque fois qu'une cellule apparaît à l'écran
        cellule.textView.text = nameList[index]
    }

    getItemCount() : Int {
        return list.count()
    }
}

class Cellule(view : View) : RecyclerView.ViewHolder(view) {
    val textView: TextView = view as TextView
}

*/