package hello

data class HelloAppState(val value : String = "",
                         val valueList : List<String> = listOf(),
                         val hoverValue : String = "")