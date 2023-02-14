package com.example.paging_practice

data class Data(
    val info: Info,
    val results: List<Result>
)

data class Info(
    val count: Int,
    val next: String,
    val pages: Int,
    val prev: String
)

data class Location(
    val name: String,
    val url: String
)

data class Origin(
    val name: String,
    val url: String
)

data class Result(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)

fun Data.toList() : List<NewData> = results.map { NewData(it.name, it.status, it.species, it.image) }

data class NewData(
    val name:String,
    val status: String,
    val species: String,
    val image :String
)