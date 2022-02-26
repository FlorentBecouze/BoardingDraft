package application.boardingdraft.Frontend.Views

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.*
import application.boardingdraft.R
import coil.ImageLoader
import coil.request.ImageRequest
import kotlinx.coroutines.delay

class VoteJeuxFragment : Fragment(R.layout.fragment_vote_jeux) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageView: ImageView = view.findViewById(R.id.imageView_en_cours_de_construction)
        val boutonRafraichissement: ImageButton = view.findViewById(R.id.bouton_rafraichissement_image)

        val urlSite: String = "https://loremflickr.com/1200/800/kitten"

        var imageLoader = ImageLoader.Builder(requireContext())
            .availableMemoryPercentage(0.25)
            .crossfade(true)
            .build()

        var request = ImageRequest.Builder(requireContext())
            .data(urlSite)
            .target(imageView)
            .build()


        // Si nous sommes connecte a internet
        if (isOnline(requireContext())) {
            // Utilisation de Coil et chargement d'une nouvelle image depuis le site internet
            imageLoader.enqueue(request)
        } else {
            Toast.makeText(context, "Veuillez vous connecter à Internet pour voir les images", Toast.LENGTH_SHORT).show()
            imageView.setImageResource(R.drawable.image_pas_internet)
        }


        boutonRafraichissement.setOnClickListener {
            // Modification de l'image
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
                Toast.makeText(context, "Veuillez vous connecter à Internet pour voir les images", Toast.LENGTH_SHORT).show()
                imageView.setImageResource(R.drawable.image_pas_internet)
            }
        }

        // Possibilite de changer l'image automatiquement. Veuillez decommenter le code ci-dessous.
        /*
        lifecycleScope.launch {
            rafraichissementImage(imageView, requireContext(), imageLoader, request, urlSite)
        }*/
    }


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


    suspend fun rafraichissementImage(imageView: ImageView, context: Context, imageLoader: ImageLoader, request: ImageRequest, urlSite: String) {
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
        delay(1_000)
        Toast.makeText(context, "Veuillez vous connecter à Internet pour voir les images", Toast.LENGTH_SHORT).show()
        imageView.setImageResource(R.drawable.image_pas_internet)
    }
}