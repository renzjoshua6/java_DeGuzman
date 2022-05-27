package test.creational

import java.util.HashMap
import designpatterns.creational.builder.Register
import org.junit.Assert
import org.junit.Test

class TestBuilder {
    @Test
    fun testIdeal() {
        val entryCorrect1 = HashMap<String, String>()
        entryCorrect1["fullName"] = "Stan Mamala"
        entryCorrect1["email"] = "stan.mamala@hello.com"
        entryCorrect1["mobileNumber"] = "09064611492"
        entryCorrect1["birthdate"] = "1996-10-12"
        entryCorrect1["gender"] = "M"

        Assert.assertEquals("Successfully registered with complete fields!", Register.checkRegister(entryCorrect1))
    }

    @Test
    fun testInvalidFullName() {
        val entryWrong1 = HashMap<String, String>()
        entryWrong1["fullName"] = "Mamala, Stan"
        entryWrong1["email"] = "stan.mamala@hello.com"
        entryWrong1["mobileNumber"] = "09064611492"
        entryWrong1["birthdate"] = "1996-10-12"
        entryWrong1["gender"] = "M"

        val entryWrong2 = HashMap<String, String>()
        entryWrong2["fullName"] = "  "
        entryWrong2["email"] = "stan.mamala@hello.com"
        entryWrong2["mobileNumber"] = "09064611492"
        entryWrong2["birthdate"] = "1996-10-12"
        entryWrong2["gender"] = "M"

        val entryWrong3 = HashMap<String, String>()
        entryWrong3["fullName"] = ""
        entryWrong3["email"] = "stan.mamala@hello.com"
        entryWrong3["mobileNumber"] = "09064611492"
        entryWrong3["birthdate"] = "1996-10-12"
        entryWrong3["gender"] = "M"

        val entryWrong4 = HashMap<String, String>()
        entryWrong4["fullName"] = "StanMamala"
        entryWrong4["email"] = "stan.mamala@hello.com"
        entryWrong4["mobileNumber"] = "09064611492"
        entryWrong4["birthdate"] = "1996-10-12"
        entryWrong4["gender"] = "M"

        val entryWrong5 = HashMap<String, String>()
        entryWrong5["fullName"] = "1234 5678"
        entryWrong5["email"] = "stan.mamala@hello.com"
        entryWrong5["mobileNumber"] = "09064611492"
        entryWrong5["birthdate"] = "1996-10-12"
        entryWrong5["gender"] = "M"

        Assert.assertEquals("Registration unsuccessful.", Register.checkRegister(entryWrong1))
        Assert.assertEquals("Registration unsuccessful.", Register.checkRegister(entryWrong2))
        Assert.assertEquals("Registration unsuccessful.", Register.checkRegister(entryWrong3))
        Assert.assertEquals("Registration unsuccessful.", Register.checkRegister(entryWrong4))
        Assert.assertEquals("Registration unsuccessful.", Register.checkRegister(entryWrong5))
    }

    @Test
    fun testInvalidEmail() {
        val entryWrong1 = HashMap<String, String>()
        entryWrong1["fullName"] = "Stan Mamala"
        entryWrong1["email"] = "stan.mamala"
        entryWrong1["mobileNumber"] = "09064611492"
        entryWrong1["birthdate"] = "1996-10-12"
        entryWrong1["gender"] = "M"

        val entryWrong2 = HashMap<String, String>()
        entryWrong2["fullName"] = "Stan Mamala"
        entryWrong2["email"] = ""
        entryWrong2["mobileNumber"] = "09064611492"
        entryWrong2["birthdate"] = "1996-10-12"
        entryWrong2["gender"] = "M"

        val entryWrong3 = HashMap<String, String>()
        entryWrong3["fullName"] = "Stan Mamala"
        entryWrong3["email"] = "   "
        entryWrong3["mobileNumber"] = "09064611492"
        entryWrong3["birthdate"] = "1996-10-12"
        entryWrong3["gender"] = "M"

        val entryWrong4 = HashMap<String, String>()
        entryWrong4["fullName"] = "Stan Mamala"
        entryWrong4["email"] = "stan!mamala@hello.com"
        entryWrong4["mobileNumber"] = "09064611492"
        entryWrong4["birthdate"] = "1996-10-12"
        entryWrong4["gender"] = "M"

        val entryWrong5 = HashMap<String, String>()
        entryWrong5["fullName"] = "Stan Mamala"
        entryWrong5["email"] = ".%&^*@hello.com"
        entryWrong5["mobileNumber"] = "09064611492"
        entryWrong5["birthdate"] = "1996-10-12"
        entryWrong5["gender"] = "M"

        val entryWrong6 = HashMap<String, String>()
        entryWrong6["fullName"] = "Stan Mamala"
        entryWrong6["email"] = "12345@hello.com"
        entryWrong6["mobileNumber"] = "09064611492"
        entryWrong6["birthdate"] = "1996-10-12"
        entryWrong6["gender"] = "M"

        val entryWrong7 = HashMap<String, String>()
        entryWrong7["fullName"] = "Stan Mamala"
        entryWrong7["email"] = "1stan@hello.com"
        entryWrong7["mobileNumber"] = "09064611492"
        entryWrong7["birthdate"] = "1996-10-12"
        entryWrong7["gender"] = "M"

        Assert.assertEquals("Registration unsuccessful.", Register.checkRegister(entryWrong1))
        Assert.assertEquals("Registration unsuccessful.", Register.checkRegister(entryWrong2))
        Assert.assertEquals("Registration unsuccessful.", Register.checkRegister(entryWrong3))
        Assert.assertEquals("Registration unsuccessful.", Register.checkRegister(entryWrong4))
        Assert.assertEquals("Registration unsuccessful.", Register.checkRegister(entryWrong5))
        Assert.assertEquals("Registration unsuccessful.", Register.checkRegister(entryWrong6))
        Assert.assertEquals("Registration unsuccessful.", Register.checkRegister(entryWrong7))
    }

    @Test
    fun testInvalidMobileNumber() {
        val entryWrong1 = HashMap<String, String>()
        entryWrong1["fullName"] = "Stan Mamala"
        entryWrong1["email"] = "stan.mamala@hello.com"
        entryWrong1["mobileNumber"] = "0906461149a"
        entryWrong1["birthdate"] = "1996-10-12"
        entryWrong1["gender"] = "M"

        val entryWrong2 = HashMap<String, String>()
        entryWrong2["fullName"] = "Stan Mamala"
        entryWrong2["email"] = "stan.mamala@hello.com"
        entryWrong2["mobileNumber"] = "+639064611492"
        entryWrong2["birthdate"] = "1996-10-12"
        entryWrong2["gender"] = "M"

        val entryWrong3 = HashMap<String, String>()
        entryWrong3["fullName"] = "Stan Mamala"
        entryWrong3["email"] = "stan.mamala@hello.com"
        entryWrong3["mobileNumber"] = "   "
        entryWrong3["birthdate"] = "1996-10-12"
        entryWrong3["gender"] = "M"

        val entryWrong4 = HashMap<String, String>()
        entryWrong4["fullName"] = "Stan Mamala"
        entryWrong4["email"] = "stan.mamala@hello.com"
        entryWrong4["mobileNumber"] = ""
        entryWrong4["birthdate"] = "1996-10-12"
        entryWrong4["gender"] = "M"

        val entryWrong5 = HashMap<String, String>()
        entryWrong5["fullName"] = "Stan Mamala"
        entryWrong5["email"] = "stan.mamala@hello.com"
        entryWrong5["mobileNumber"] = "0912"
        entryWrong5["birthdate"] = "1996-10-12"
        entryWrong5["gender"] = "M"

        Assert.assertEquals(
            "Successfully registered with incomplete mobileNumber field!",
            Register.checkRegister(entryWrong1)
        )
        Assert.assertEquals(
            "Successfully registered with incomplete mobileNumber field!",
            Register.checkRegister(entryWrong2)
        )
        Assert.assertEquals(
            "Successfully registered with incomplete mobileNumber field!",
            Register.checkRegister(entryWrong3)
        )
        Assert.assertEquals(
            "Successfully registered with incomplete mobileNumber field!",
            Register.checkRegister(entryWrong4)
        )
        Assert.assertEquals(
            "Successfully registered with incomplete mobileNumber field!",
            Register.checkRegister(entryWrong5)
        )
    }

    @Test
    fun testInvalidBirthdate() {
        val entryWrong1 = HashMap<String, String>()
        entryWrong1["fullName"] = "Stan Mamala"
        entryWrong1["email"] = "stan.mamala@hello.com"
        entryWrong1["mobileNumber"] = "09064611492"
        entryWrong1["birthdate"] = "1973-9-10"
        entryWrong1["gender"] = "M"

        val entryWrong2 = HashMap<String, String>()
        entryWrong2["fullName"] = "Stan Mamala"
        entryWrong2["email"] = "stan.mamala@hello.com"
        entryWrong2["mobileNumber"] = "09064611492"
        entryWrong2["birthdate"] = "09-10-1973"
        entryWrong2["gender"] = "M"

        val entryWrong3 = HashMap<String, String>()
        entryWrong3["fullName"] = "Stan Mamala"
        entryWrong3["email"] = "stan.mamala@hello.com"
        entryWrong3["mobileNumber"] = "09064611492"
        entryWrong3["birthdate"] = "73-09-10"
        entryWrong3["gender"] = "M"

        val entryWrong4 = HashMap<String, String>()
        entryWrong4["fullName"] = "Stan Mamala"
        entryWrong4["email"] = "stan.mamala@hello.com"
        entryWrong4["mobileNumber"] = "09064611492"
        entryWrong4["birthdate"] = "1973/09/10"
        entryWrong4["gender"] = "M"

        val entryWrong5 = HashMap<String, String>()
        entryWrong5["fullName"] = "Stan Mamala"
        entryWrong5["email"] = "stan.mamala@hello.com"
        entryWrong5["mobileNumber"] = "09064611492"
        entryWrong5["birthdate"] = "   "
        entryWrong5["gender"] = "M"

        val entryWrong6 = HashMap<String, String>()
        entryWrong6["fullName"] = "Stan Mamala"
        entryWrong6["email"] = "stan.mamala@hello.com"
        entryWrong6["mobileNumber"] = "09064611492"
        entryWrong6["birthdate"] = ""
        entryWrong6["gender"] = "M"

        Assert.assertEquals(
            "Successfully registered with incomplete birthdate field!",
            Register.checkRegister(entryWrong1)
        )
        Assert.assertEquals(
            "Successfully registered with incomplete birthdate field!",
            Register.checkRegister(entryWrong2)
        )
        Assert.assertEquals(
            "Successfully registered with incomplete birthdate field!",
            Register.checkRegister(entryWrong3)
        )
        Assert.assertEquals(
            "Successfully registered with incomplete birthdate field!",
            Register.checkRegister(entryWrong4)
        )
        Assert.assertEquals(
            "Successfully registered with incomplete birthdate field!",
            Register.checkRegister(entryWrong5)
        )
        Assert.assertEquals(
            "Successfully registered with incomplete birthdate field!",
            Register.checkRegister(entryWrong6)
        )
    }

    @Test
    fun testInvalidGender() {
        val entryWrong1 = HashMap<String, String>()
        entryWrong1["fullName"] = "Stan Mamala"
        entryWrong1["email"] = "stan.mamala@hello.com"
        entryWrong1["mobileNumber"] = "09064611492"
        entryWrong1["birthdate"] = "1996-10-12"
        entryWrong1["gender"] = "Male"

        val entryWrong2 = HashMap<String, String>()
        entryWrong2["fullName"] = "Stan Mamala"
        entryWrong2["email"] = "stan.mamala@hello.com"
        entryWrong2["mobileNumber"] = "09064611492"
        entryWrong2["birthdate"] = "1996-10-12"
        entryWrong2["gender"] = ""

        val entryWrong3 = HashMap<String, String>()
        entryWrong3["fullName"] = "Stan Mamala"
        entryWrong3["email"] = "stan.mamala@hello.com"
        entryWrong3["mobileNumber"] = "09064611492"
        entryWrong3["birthdate"] = "1996-10-12"
        entryWrong3["gender"] = "   "

        val entryWrong4 = HashMap<String, String>()
        entryWrong4["fullName"] = "Stan Mamala"
        entryWrong4["email"] = "stan.mamala@hello.com"
        entryWrong4["mobileNumber"] = "09064611492"
        entryWrong4["birthdate"] = "1996-10-12"
        entryWrong4["gender"] = "B"

        val entryWrong5 = HashMap<String, String>()
        entryWrong5["fullName"] = "Stan Mamala"
        entryWrong5["email"] = "stan.mamala@hello.com"
        entryWrong5["mobileNumber"] = "09064611492"
        entryWrong5["birthdate"] = "1996-10-12"
        entryWrong5["gender"] = "1"

        Assert.assertEquals(
            "Successfully registered with incomplete gender field!",
            Register.checkRegister(entryWrong1)
        )
        Assert.assertEquals(
            "Successfully registered with incomplete gender field!",
            Register.checkRegister(entryWrong2)
        )
        Assert.assertEquals(
            "Successfully registered with incomplete gender field!",
            Register.checkRegister(entryWrong3)
        )
        Assert.assertEquals(
            "Successfully registered with incomplete gender field!",
            Register.checkRegister(entryWrong4)
        )
        Assert.assertEquals(
            "Successfully registered with incomplete gender field!",
            Register.checkRegister(entryWrong5)
        )
    }

    @Test
    fun testInvalidMobileNumberAndBirthdate() {
        val entryWrong1 = HashMap<String, String>()
        entryWrong1["fullName"] = "Stan Mamala"
        entryWrong1["email"] = "stan.mamala@hello.com"
        entryWrong1["mobileNumber"] = "0906461149a"
        entryWrong1["birthdate"] = "1996-1-12"
        entryWrong1["gender"] = "M"

        Assert.assertEquals(
            "Successfully registered with incomplete mobileNumber and birthdate fields!",
            Register.checkRegister(entryWrong1)
        )
    }

    @Test
    fun testInvalidMobileNumberAndGender() {
        val entryWrong1 = HashMap<String, String>()
        entryWrong1["fullName"] = "Stan Mamala"
        entryWrong1["email"] = "stan.mamala@hello.com"
        entryWrong1["mobileNumber"] = "0906461149a"
        entryWrong1["birthdate"] = "1996-10-12"
        entryWrong1["gender"] = "Male"

        Assert.assertEquals(
            "Successfully registered with incomplete mobileNumber and gender fields!",
            Register.checkRegister(entryWrong1)
        )
    }

    @Test
    fun testInvalidBirthdateAndGender() {
        val entryWrong1 = HashMap<String, String>()
        entryWrong1["fullName"] = "Stan Mamala"
        entryWrong1["email"] = "stan.mamala@hello.com"
        entryWrong1["mobileNumber"] = "09064611492"
        entryWrong1["birthdate"] = "1973-9-10"
        entryWrong1["gender"] = "Male"

        Assert.assertEquals(
            "Successfully registered with incomplete birthdate and gender fields!",
            Register.checkRegister(entryWrong1)
        )
    }

    @Test
    fun testAllInvalid() {
        val entryWrong1 = HashMap<String, String>()
        entryWrong1["fullName"] = "Stan Mamala"
        entryWrong1["email"] = "stan.mamala@hello.com"
        entryWrong1["mobileNumber"] = "0906461149a"
        entryWrong1["birthdate"] = "1973-9-10"
        entryWrong1["gender"] = "Male"

        Assert.assertEquals("Successfully registered with incomplete fields!", Register.checkRegister(entryWrong1))
    }
}