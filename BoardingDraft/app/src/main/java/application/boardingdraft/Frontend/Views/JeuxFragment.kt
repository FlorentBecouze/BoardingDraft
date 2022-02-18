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
import application.boardingdraft.Frontend.Views.List.IJeu
import application.boardingdraft.Frontend.Views.List.ListAdapterJeu
import application.boardingdraft.R

class JeuxFragment : Fragment(R.layout.fragment_jeux), IJeu {

    val jeuViewModel:JeuViewModel by viewModels()
    var recyclerView:RecyclerView? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view_liste_jeux)
        recyclerView?.layoutManager = LinearLayoutManager(requireContext())
        recyclerView?.adapter = ListAdapterJeu(emptyList(), this)

        jeuViewModel.currentListeJeux.observe(viewLifecycleOwner) {
                jeux:List<Jeu> ->
            (recyclerView?.adapter as ListAdapterJeu).listeJeux = jeux
            recyclerView?.adapter!!.notifyDataSetChanged()
        }

        // Création de jeux à mettre dans la base
        // A lancer qu'1 seule fois au premier téléchargement. Après commenter le code et recharger l'appli
        /*
        val image: ImageView = ImageView(context)
        image.setImageResource(R.drawable.image_accueil)

        val jeu1: Jeu = Jeu(NomJeu = "UNO", DescriptionJeu = "Mettre une bonne description", Photo = genererBitMap(image))
        val jeu2: Jeu = Jeu(NomJeu = "Président", DescriptionJeu = "Mettre une bonne description", Photo = genererBitMap(image))
        val jeu3: Jeu = Jeu(NomJeu = "La bonne paye", DescriptionJeu = "Mettre une bonne description", Photo = genererBitMap(image))
        val jeu4: Jeu = Jeu(NomJeu = "Les petits chevaux", DescriptionJeu = "Mettre une bonne description", Photo = genererBitMap(image))
        val jeu5: Jeu = Jeu(NomJeu = "Mikado", DescriptionJeu = "Mettre une bonne description", Photo = genererBitMap(image))
        val jeu6: Jeu = Jeu(NomJeu = "Le jeu de l'oie", DescriptionJeu = "Mettre une bonne description", Photo = genererBitMap(image))
        jeuViewModel.insererJeu(jeu1)
        jeuViewModel.insererJeu(jeu2)
        jeuViewModel.insererJeu(jeu3)
        jeuViewModel.insererJeu(jeu4)
        jeuViewModel.insererJeu(jeu5)
        jeuViewModel.insererJeu(jeu6)
        */
    }

    override fun onButtonJeuClicked(jeu: Jeu) {
        Toast.makeText(context, "Infos jeu", Toast.LENGTH_SHORT)
        //findNavController().navigate(R.id.action_accueilFragment_to_voteJeuxFragment)
    }

    private fun genererBitMap(image: ImageView) : Bitmap {
        val drawable = image.drawable as BitmapDrawable
        return drawable.bitmap
    }
}