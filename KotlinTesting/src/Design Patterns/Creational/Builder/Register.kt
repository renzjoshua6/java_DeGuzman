package designpatterns.creational.builder

import java.util.HashMap
import designpatterns.creational.builder.Form.FormBuilder
import java.util.logging.Level
import java.util.logging.Logger
import java.util.regex.Pattern


object Register {
    var newForm: Form? = null
    private val logger = Logger.getLogger(Register::class.java.name)
    fun checkRegister(formMap: HashMap<String, String>): String {
        var registrationStatus = "Registration unsuccessful."

        // ASSUMPTIONS:
        // 1. User has entered all fields
        // 2. fullName is in <firstName lastName> format and are all alphabet characters
        // 3. mobileNumber is in 09xxxxxxxxx format
        // 4. birthdate is in YYYY-MM-DD
        // 5. Gender is either M, F or N (for Male, Female and Non-Binary)

        val fullName = formMap["fullName"]
        val email = formMap["email"]
        val mobileNumber = formMap["mobileNumber"]
        val birthdate = formMap["birthdate"]
        val gender = formMap["gender"]
        var count = 0
        return if (fullName!!.split(" ".toRegex())
                .toTypedArray().size >= 2 && Pattern.compile("^[a-zA-Z]{4,}(?: [a-zA-Z]+)?(?: [a-zA-Z]+)?$").matcher(fullName).matches()
        ) {
            val namePattern = Pattern.compile(
                "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$"
            )
            val nameMatcher = namePattern.matcher(email)
            val emailEx = email!!.split("@".toRegex()).toTypedArray()[0]
            val emailPattern = Pattern.compile(
                "^[a-zA-Z][a-zA-Z0-9.]+$"
            )
            val emailMatcher = emailPattern.matcher(emailEx)
            if (nameMatcher.matches() && emailMatcher.matches()) {
                val builder = FormBuilder(fullName, email)
                val numberPattern = Pattern.compile(
                    "^09[0-9]+$"
                )
                val numberMatcher = numberPattern.matcher(mobileNumber)
                if (mobileNumber!!.length == 11 && numberMatcher.matches()) {
                    builder.addMobileNumber(mobileNumber)
                } else {
                    count += 2
                    logger.log(
                        Level.INFO,
                        "Invalid mobileNumber format!"
                    )
                }
                val bdatePattern =
                    Pattern.compile("^\\d{4}-(02-(0[1-9]|[12][0-9])|(0[469]|11)-(0[1-9]|[12][0-9]|30)|(0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))$")
                val bdateMatcher = bdatePattern.matcher(birthdate)
                if (bdateMatcher.matches()) {
                    builder.addBirthdate(birthdate)
                } else {
                    logger.log(
                        Level.INFO,
                        "Invalid birthdate format!"
                    )
                    count += 4
                }
                if (gender == "M" || gender =="F" || gender == "N") {
                    builder.addGender(mobileNumber)
                } else {
                    count += 5
                    logger.log(
                        Level.INFO,
                        "Invalid gender format!"
                    )
                }
                if (count == 0) {
                    newForm = builder.build()
                    registrationStatus = "Successfully registered with complete fields!"
                    registrationStatus
                } else if (count == 2) {
                    newForm = builder.build()
                    registrationStatus = "Successfully registered with incomplete mobileNumber field!"
                    registrationStatus
                } else if (count == 4) {
                    newForm = builder.build()
                    registrationStatus = "Successfully registered with incomplete birthdate field!"
                    registrationStatus
                } else if (count == 5) {
                    newForm = builder.build()
                    registrationStatus = "Successfully registered with incomplete gender field!"
                    registrationStatus
                } else if (count == 6) {
                    newForm = builder.build()
                    registrationStatus = "Successfully registered with incomplete mobileNumber and birthdate fields!"
                    registrationStatus
                } else if (count == 7) {
                    newForm = builder.build()
                    registrationStatus = "Successfully registered with incomplete mobileNumber and gender fields!"
                    registrationStatus
                } else if (count == 9) {
                    newForm = builder.build()
                    registrationStatus = "Successfully registered with incomplete birthdate and gender fields!"
                    registrationStatus
                } else {
                    newForm = builder.build()
                    registrationStatus = "Successfully registered with incomplete fields!"
                    registrationStatus
                }
            } else {
                logger.log(Level.INFO, "Invalid email format!")
                registrationStatus
            }
        } else {
            logger.log(Level.INFO, "Invalid fullName format!")
            registrationStatus
        }
    }
}
