package br.dev.lucas.spring.sandbox

import com.opencsv.CSVReader
import com.opencsv.bean.MappingStrategy

class PersonToCsvHeaderMappingStrategy : MappingStrategy<Person> {
    override fun captureHeader(reader: CSVReader?) {
        throw UnsupportedOperationException()
    }

    override fun populateNewBean(line: Array<out String>?): Person {
        TODO("Not yet implemented")
    }

    override fun transmuteBean(bean: Person?): Array<String> {
        TODO("Not yet implemented")
    }

    override fun setType(type: Class<out Person>?) {}

    override fun generateHeader(bean: Person?): Array<String> {
        return arrayOf("Name", "Date of birth")
    }

}
