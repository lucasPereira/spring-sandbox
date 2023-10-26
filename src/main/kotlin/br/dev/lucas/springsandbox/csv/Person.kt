package br.dev.lucas.springsandbox.csv

import com.opencsv.bean.CsvBindByName
import java.util.Date

data class Person(
        @CsvBindByName(column = "Name") val name: String,
        @CsvBindByName(column = "Date of birth") val birthday: Date
)
