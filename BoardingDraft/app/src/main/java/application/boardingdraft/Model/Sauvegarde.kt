package application.boardingdraft.Model

import kotlinx.serialization.*
import kotlinx.serialization.json.*

@Serializable
data class JoueurData(val name: String)

@Serializable
data class JeuxData(val name: String)

fun main() {
    // Serializing objects
    val data = JoueurData("Kévin")
    val string = Json.encodeToString(data)
    println(string) // {"name":"Kévin"}
    // Deserializing back into objects
    val obj = Json.decodeFromString<JoueurData>(string)
    println(obj) // Project(name=kotlinx.serialization, language=Kotlin)
}