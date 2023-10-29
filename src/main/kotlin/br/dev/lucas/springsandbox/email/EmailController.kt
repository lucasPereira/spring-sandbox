package br.dev.lucas.springsandbox.email

import com.sendgrid.Method
import com.sendgrid.Request
import com.sendgrid.SendGrid
import com.sendgrid.helpers.mail.Mail
import com.sendgrid.helpers.mail.objects.Email
import com.sendgrid.helpers.mail.objects.Personalization
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class EmailController {

    @GetMapping("/email")
    fun get() {
        val email = Email("pslucasps@gmail.com")

        val personalization = Personalization()
        personalization.addDynamicTemplateData("test_variable", "code defined test variable value!")
//        personalization.addDynamicTemplateData("subject_prefix", "[Tag] ")
        personalization.addDynamicTemplateData("variable_not_defined_in_template", "testing 123...")
        personalization.addTo(email)

        val mail = Mail()
        mail.setFrom(email)
        mail.setTemplateId("d-78d5756dc09f48d5a59848aa303f486a")
        mail.addPersonalization(personalization)

        val request = Request()
        request.method = Method.POST
        request.endpoint = "mail/send"
        request.body = mail.build()

        val apiKey = "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"
        val sendGrid = SendGrid(apiKey)
        val response = sendGrid.api(request)

        println(response.statusCode)
        println(response.body)
        println(response.headers)
    }

}