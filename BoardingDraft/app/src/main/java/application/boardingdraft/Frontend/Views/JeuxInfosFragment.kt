package application.boardingdraft.Frontend.Views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import application.boardingdraft.R

class JeuxInfosFragment : Fragment(R.layout.fragment_jeux_infos) {

    private val args : JeuxInfosFragmentArgs by navArgs<JeuxInfosFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var textViewTitre: TextView = view.findViewById<TextView>(R.id.titreJeuxInfosTextView)
        var imageViewJeuInfo: ImageView = view.findViewById<ImageView>(R.id.imageView_jeux_infos)
        var textViewDesc: TextView = view.findViewById<TextView>(R.id.descJeuxInfosTextView)

        textViewTitre.text = args.titreJeu
        imageViewJeuInfo.setImageBitmap(args.photoJeu)
        textViewDesc.text = args.descJeu
    }
}