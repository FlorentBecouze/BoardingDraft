package application.boardingdraft.Backend.BDD

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import application.boardingdraft.Backend.DAL.Converters
import application.boardingdraft.Backend.DAL.JeuDAO
import application.boardingdraft.Backend.DAL.JoueurDAO
import application.boardingdraft.Frontend.Model.Jeu
import application.boardingdraft.Frontend.Model.Joueur

@Database(entities = [Joueur::class, Jeu::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    // Création unique pour la classe "AppDatabase", des objets suivants
    abstract fun joueurDao(): JoueurDAO
    abstract fun jeuDao(): JeuDAO

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        // Méthode permettant d'empêcher de multiples instances de l'objet "AppDatabase" en même temps.
        fun getDatabase(context: Context): AppDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "Notre database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}