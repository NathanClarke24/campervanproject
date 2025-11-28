package controllers;



class NoteAPI() {
    private var notes = ArrayList<Note>()


    private var lastId = 0
    private fun getId() = lastId++


    fun add(note: Note): Boolean {
        val noteId = getId()
        note.noteId = noteId
        return notes.add(note)
    }

    fun delete(id: Int): Boolean {
        return notes.removeIf { note -> note.noteId == id }
    }
}

fun update(id: Int, note: Note?): Boolean {
    // find the note object by the index number
    val foundNote = findNote(id)

    if ((foundNote != null) && (note != null)) {
        foundNote.noteTitle = note.noteTitle
        foundNote.notePriority = note.notePriority
        foundNote.noteCategory = note.noteCategory
        return true
    }

    return false
}

fun listAllNotes() =
        if (notes.isEmpty())
        "No Camper Vans stored"
        else
formatListString(notes)

fun listActiveNotes() =
        if (numberOfActiveNotes() == 0)
        "No active Camper Vans stored"
        else
formatListString(notes.filter { note -> !note.isNoteArchived })

fun listArchivedNotes() =
        if (numberOfArchivedNotes() == 0)
        "No archived Camper Vans stored"
        else
formatListString(notes.filter { note -> note.isNoteArchived })

fun searchItemByContents(searchString: String): String {
    return if (numberOfNotes() == 0) {
        "No notes stored"
    } else {
        var listOfNotes = ""
        for (note in notes) {
            for (item in note.items) {
                if (item.itemContents.contains(searchString, ignoreCase = true)) {
                    listOfNotes += "${note.noteId}: ${note.noteTitle}\n"
                }
            }
        }
        if (listOfNotes.isEmpty()) {
            "No items found for: $searchString"
        } else {
            listOfNotes
        }
    }
}

fun listTodoItems(): String {
    if (numberOfNotes() == 0) {
        return "No notes stored"
    } else {
        var listOfTodoItems = ""
        for (note in notes) {
            for (item in note.items) {
                if (!item.isItemComplete) {
                    listOfTodoItems += "${note.noteTitle}: ${item.itemContents}\n"
                }
            }
        }
        return listOfTodoItems
    }
}

fun numberOfToDoItems(): Int {
    var numberOfToDoItems = 0
    for (note in notes) {
        for (item in note.items) {
            if (!item.isItemComplete) {
                numberOfToDoItems++
            }
        }
    }
    return numberOfToDoItems
}