package application.boardingdraft.Model

class Joueur(var name: String) {
    var listeJeuxFavoris: MutableList<Jeux> = mutableListOf<Jeux>()
}
