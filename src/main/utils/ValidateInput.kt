fun readValidCategory(prompt: String?): String {
    var input = readNextLine(prompt)
    do {
        if (itsValidCategory(input))
            return input
        else {
            print ("Invalid input $input. Please try again: ")
            input = readNextLine(prompt)        }
    }
}