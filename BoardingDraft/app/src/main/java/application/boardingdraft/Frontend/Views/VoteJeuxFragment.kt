package application.boardingdraft.Frontend.Views

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.*
import androidx.lifecycle.lifecycleScope
import application.boardingdraft.R
import coil.ImageLoader
import coil.request.ImageRequest
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class VoteJeuxFragment : Fragment(R.layout.fragment_vote_jeux) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageView: ImageView = view.findViewById(R.id.imageView_en_cours_de_construction)
        val boutonRafraichissement: ImageButton = view.findViewById(R.id.bouton_rafraichissement_image)

        // Site internet sur lequel, les images aléatoires sont prises
        val urlSite: String = "https://loremflickr.com/1200/800/kitten"

        // Instanciation d'un objet permettant de charger une image à partir d'une requête HTTP
        var imageLoader = ImageLoader.Builder(requireContext())
            .availableMemoryPercentage(0.25)
            .crossfade(true)
            .build()
        // Instanciation de l'objet représentant la requête HTTP
        // L'image chargée sera directement mise dans l'imageView affichée sur l'écran
        var request = ImageRequest.Builder(requireContext())
            .data(urlSite)
            .target(imageView)
            .build()


        // Si nous sommes connectés à internet
        if (isOnline(requireContext())) {
            // Utilisation de Coil et chargement d'une nouvelle image depuis le site internet
            imageLoader.enqueue(request)
        } else {    // Sinon affichage d'une image par défaut
            Toast.makeText(context, R.string.texte_toast_pas_internet, Toast.LENGTH_SHORT).show()
            imageView.setImageResource(R.drawable.image_pas_internet)
        }


        // Modification de l'image affichée
        boutonRafraichissement.setOnClickListener {
            if (isOnline(requireContext())) {
                imageLoader = ImageLoader.Builder(requireContext())
                    .availableMemoryPercentage(0.25)
                    .crossfade(true)
                    .build()

                request = ImageRequest.Builder(requireContext())
                    .data(urlSite)
                    .target(imageView)
                    .build()

                imageLoader.enqueue(request)
            } else {
                Toast.makeText(context, R.string.texte_toast_pas_internet, Toast.LENGTH_SHORT).show()
                imageView.setImageResource(R.drawable.image_pas_internet)
            }
        }


        // Possibilité de changer l'image automatiquement toutes les 4 secondes via une coroutine.
        // Veuillez décommenter le code ci-dessous.
        /*
        lifecycleScope.launch {
            rafraichissementImage(imageView, requireContext(), urlSite)
        }*/
    }


    // Méthode vérifiant notre connexion à internet
    private fun isOnline(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (connectivityManager != null) {
            val capabilities =
                connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                    return true
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                    return true
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                    return true
                }
            }
        }
        return false
    }


    // Coroutine permettant de lancer un changement d'image régulier
    suspend fun rafraichissementImage(imageView: ImageView, context: Context, urlSite: String) {
        // Tant que nous sommes connectés à internet, nous changeons d'image toutes les 4 secondes
        while (isOnline(context)) {
            delay(4_000)

            val imageLoader = ImageLoader.Builder(context)
                .availableMemoryPercentage(0.25)
                .crossfade(true)
                .build()

            val request = ImageRequest.Builder(context)
                .data(urlSite)
                .target(imageView)
                .build()

            imageLoader.enqueue(request)
        }

        // Attente nécessaire pour que l'image ait le temps de s'afficher
        delay(1_000)
        Toast.makeText(context, R.string.texte_toast_pas_internet, Toast.LENGTH_SHORT).show()
        imageView.setImageResource(R.drawable.image_pas_internet)
    }
}