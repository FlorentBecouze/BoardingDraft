package application.boardingdraft.Backend.BDD

import androidx.room.Database
import androidx.room.RoomDatabase
import application.boardingdraft.Backend.DAL.JoueurDAO
import application.boardingdraft.Frontend.Model.Joueur

@Database(entities = [Joueur::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun joueurDao(): JoueurDAO
}