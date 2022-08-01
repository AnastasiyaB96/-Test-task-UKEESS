package com.belaia.anastasia.testtaskukeess.data

import com.fasterxml.jackson.annotation.JsonProperty

data class PersonModel(
    @JsonProperty("_id")
    val id: String,
    @JsonProperty("name")
    val name: String,
    @JsonProperty("gender")
    val gender: String,
    @JsonProperty("about")
    val about: String,
    @JsonProperty("picture")
    val picture: String,
    @JsonProperty("birth")
    val birth: Birth,
    @JsonProperty("death")
    val death: Death?
)

data class Birth(
    @JsonProperty("date")
    val date: String,
    @JsonProperty("location")
    val location: Location,
    @JsonProperty("death")
    val death: Death?
)

data class Death(
    @JsonProperty("date")
    val date: String,
    @JsonProperty("location")
    val location: Location
)

data class Location(
    @JsonProperty("name")
    val name: String,
    @JsonProperty("latitude")
    val latitude: Long,
    @JsonProperty("longitude")
    val longitude: Long
)
