package Properties

class LazyProperty(val initializer: () -> Int) {
    var Value: Int? = null
        get() {
            if (field == null) field = initializer()
            return field
        }
    val lazy: Int
        get() =
            Value!!
}