package org.example.controllers

class NoteAPI {

    private var notes = ArrayList<Note>()
    private var lastId = 0
    private fun getId() = lastId++

    fun add(note: Note): Boolean {
        note.noteId = getId()
        return notes.add(note)
    }

    fun delete(id: Int): Boolean {
        return notes.removeIf { note -> note.noteId == id }
    }

    fun update(id: Int, note: Note?): Boolean {
        val foundNote = findNote(id)

        if (foundNote != null && note != null) {
            foundNote.noteTitle = note.noteTitle
            foundNote.notePriority = note.notePriority
            foundNote.noteCategory = note.noteCategory
            return true
        }
        return false
    }

    fun listAllNotes(): String =
        if (notes.isEmpty()) "No notes stored"
        else formatListString(notes)

    fun listActiveNotes(): String =
        if (numberOfActiveNotes() == 0) "No active notes stored"
        else formatListString(notes.filter { note -> !note.isNoteArchived })

    fun listArchivedNotes(): String =
        if (numberOfArchivedNotes() == 0) "No archived notes stored"
        else formatListString(notes.filter { note -> note.isNoteArchived })

    fun searchItemByContents(searchString: String): String {
        return if (numberOfNotes() == 0) "No notes stored"
        else {
            var listOfNotes = ""
            for (note in notes) {
                for (item in note.items) {
                    if (item.itemContents.contains(searchString, ignoreCase = true)) {
                        listOfNotes += "${note.noteId}: ${note.noteTitle}\n$item\n"
                    }
                }
            }
            if (listOfNotes.isEmpty()) "No items found for: $searchString"
            else listOfNotes
        }
    }

    fun listTodoItems(): String {
        if (numberOfNotes() == 0) return "No notes stored"

        var listOfTodoItems = ""
        for (note in notes) {
            for (item in note.items) {
                if (!item.isItemComplete) {
                    listOfTodoItems += "${note.noteId}: ${note.noteTitle} : " +
                            "${item.itemTitle}: ${item.itemContents}\n"
                }
            }
        }
        return listOfTodoItems
    }

    fun numberOfToDoItems(): Int {
        var count = 0
        for (note in notes) {
            for (item in note.items) {
                if (!item.isItemComplete) {
                    count++
                }
            }
        }
        return count
    }

