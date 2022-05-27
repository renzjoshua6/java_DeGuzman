package designpatterns.creational.builder

class Form(builder: FormBuilder) {
    var fullName: String? = ""
    var email: String? = ""
    private var mobileNumber: String? = ""
    var birthdate: String? = ""
    var gender: String? = ""

    init {
        fullName = builder.fullName
        email = builder.email
        mobileNumber = builder.mobileNumber
        birthdate = builder.birthdate
        gender = builder.gender
    }

    fun getmobileNumber(): String? {
        return mobileNumber
    }

    fun setmobileNumber(mobileNumber: String?) {
        this.mobileNumber = mobileNumber
    }

    class FormBuilder(fullName: String?, email: String?) {
        var fullName: String? = ""
        var email: String? = ""
        var mobileNumber: String? = ""
        var birthdate: String? = ""
        var gender: String? = ""

        init {
            this.fullName = fullName
            this.email = email
        }

        fun addMobileNumber(mobileNumber: String?): FormBuilder {
            this.mobileNumber = mobileNumber
            return this
        }

        fun addBirthdate(birthdate: String?): FormBuilder {
            this.birthdate = birthdate
            return this
        }

        fun addGender(gender: String?): FormBuilder {
            this.gender = gender
            return this
        }

        fun build(): Form {
            return Form(this)
        }
    }
}