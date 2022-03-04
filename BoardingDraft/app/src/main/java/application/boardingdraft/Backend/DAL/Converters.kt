package application.boardingdraft.Backend.DAL

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.room.TypeConverter
import java.io.ByteArrayOutputStream

// Classe utilisée par Room pour convertir des images en Bitmap et inversement,
// pour réussir à les insérer / récupérer dans la base de données
class Converters {

    // Transformation d'une image JPEG de type Bitmap, en tableau de Byte
    @TypeConverter
    fun fromBitmap(bitmap: Bitmap): ByteArray {
        val outputStream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream)
        return outputStream.toByteArray()
    }

    // Transformation d'un tableau de Byte, en image de type Bitmap
    @TypeConverter
    fun toBitmap(byteArray: ByteArray): Bitmap {
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)
    }
}