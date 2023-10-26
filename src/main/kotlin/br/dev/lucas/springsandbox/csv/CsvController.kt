package br.dev.lucas.springsandbox.csv

import com.opencsv.bean.StatefulBeanToCsvBuilder
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody
import java.io.OutputStreamWriter
import java.util.*

@RestController
class CsvController {

    @GetMapping("/csv")
    fun get(): ResponseEntity<StreamingResponseBody> {
        val stream = StreamingResponseBody { outputStream ->
            val writer = OutputStreamWriter(outputStream)
            val lucas = Person("Lucas", Date())
            val silva = Person("Silva", Date())
            val people = listOf(lucas, silva)
            val beanToCsvBuilder = StatefulBeanToCsvBuilder<Person>(writer)
            val beanToCsv = beanToCsvBuilder.build()
            beanToCsv.write(people)
            writer.flush()
        }
        return ResponseEntity.ok(stream)
    }

}
