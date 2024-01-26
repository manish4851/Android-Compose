package com.example.composepractice

import com.google.gson.annotations.SerializedName

data class Quotes(@field:SerializedName("quotes") val quotes:List<Quote>)