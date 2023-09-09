package com.example.vtiplist

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

//enum class Category {
//    muzi_zeny, cerny_humor, prace, IT
//}

class Joke(joke: String, category: String) {
    val jokeText = joke
    val jokeCategory = category
}

class Jokes {

    val jokeLists = listOf<Joke>(
        Joke("Prvni vtip", intentKeyList[0]),
        Joke("Druhy vtip", intentKeyList[0]),
        Joke("Treti vtip", intentKeyList[1]),
        Joke("Ctvrty vtip", intentKeyList[2]),
        Joke("Paty vtip", intentKeyList[3]),
    )

    fun getRandomJoke() : Joke {
        return jokeLists.random()
    }

    fun getCategoryJokes(requiredCategory: String): List<Joke> {
        return jokeLists.filter { it.jokeCategory == requiredCategory }
    }

}