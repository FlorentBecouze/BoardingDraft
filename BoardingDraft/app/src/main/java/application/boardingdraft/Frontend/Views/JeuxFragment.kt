package application.boardingdraft.Frontend.Views

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import application.boardingdraft.Frontend.Model.Jeu
import application.boardingdraft.Frontend.ViewModel.JeuViewModel
import application.boardingdraft.Frontend.Views.List.ListAdapterJeu
import application.boardingdraft.R

class JeuxFragment : Fragment(R.layout.fragment_jeux) {

    val jeuViewModel:JeuViewModel by viewModels()
    var recyclerView:RecyclerView? = null
    var listeJeux: MutableList<Jeu> = mutableListOf()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var adapter = ListAdapterJeu(emptyList())

        recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view_liste_jeux)
        recyclerView?.layoutManager = LinearLayoutManager(requireContext())
        recyclerView?.adapter = adapter

        adapter.setOnButtonJeuClickedListener(object :ListAdapterJeu.IJeu {
            override fun onButtonJeuClickedListener(position: Int) {
                var jeuSel: Jeu = (recyclerView?.adapter as ListAdapterJeu).listeJeux[position]

                Toast.makeText(context, "Position $position", Toast.LENGTH_SHORT).show()
                Toast.makeText(context, "Jeu sélectionné : ${jeuSel.NomJeu}", Toast.LENGTH_SHORT).show()
            }
        })

        jeuViewModel.currentListeJeux.observe(viewLifecycleOwner) {
                jeux:List<Jeu> ->
            (recyclerView?.adapter as ListAdapterJeu).listeJeux = jeux
            recyclerView?.adapter!!.notifyDataSetChanged()
        }

        // Création de jeux à mettre dans la base
        // A lancer qu'1 seule fois au premier téléchargement. Après commenter le code et recharger l'appli
        //creerJeux();
    }

    private fun creerJeux() {
        val image1: ImageView = ImageView(context)
        val image2: ImageView = ImageView(context)
        val image3: ImageView = ImageView(context)
        val image4: ImageView = ImageView(context)
        val image5: ImageView = ImageView(context)
        val image6: ImageView = ImageView(context)
        val image7: ImageView = ImageView(context)

        image1.setImageResource(R.drawable.image_accueil)
        image2.setImageResource(R.drawable.image_accueil)
        image3.setImageResource(R.drawable.image_accueil)
        image4.setImageResource(R.drawable.image_accueil)
        image5.setImageResource(R.drawable.image_accueil)
        image6.setImageResource(R.drawable.image_accueil)
        image7.setImageResource(R.drawable.image_accueil)

        listeJeux.add(Jeu(NomJeu = "UNO", DescriptionJeu = "Mettre une bonne description", Photo = genererBitMap(image1)))
        listeJeux.add(Jeu(NomJeu = "Président", DescriptionJeu = "Mettre une bonne description", Photo = genererBitMap(image2)))
        listeJeux.add(Jeu(NomJeu = "La bonne paye", DescriptionJeu = "Mettre une bonne description", Photo = genererBitMap(image3)))
        listeJeux.add(Jeu(NomJeu = "Les petits chevaux", DescriptionJeu = "Mettre une bonne description", Photo = genererBitMap(image4)))
        listeJeux.add(Jeu(NomJeu = "Mikado", DescriptionJeu = "Mettre une bonne description", Photo = genererBitMap(image5)))
        listeJeux.add(Jeu(NomJeu = "Le jeu de l'oie", DescriptionJeu = "Mettre une bonne description", Photo = genererBitMap(image6)))
        listeJeux.add(Jeu(NomJeu = "Phase 10", DescriptionJeu = "Mettre une bonne description", Photo = genererBitMap(image7)))

        listeJeux.forEach { it ->
            jeuViewModel.insererJeu(it)
        }
    }

    private fun genererBitMap(image: ImageView) : Bitmap {
        val drawable = image.drawable as BitmapDrawable
        return drawable.bitmap
    }
}