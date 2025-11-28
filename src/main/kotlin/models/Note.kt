package models

import utils.formatSetString

data class Note (var noteId Int = 0,
                 var noteTitle: String,
                 var notePriority: Int,
                 var noteCategory: String,
                 var noteCategory: String,
                 var isNoteArchived: Boolean = false,
                 var items : MutableSet<Item> = mutableSetOf()){
    private var lastItemId = 0
    private fun getNextItemId() = lastItemId++
}

fun addItem(item: Item): Boolean {
    item.itemId = getNextItemId()
    return items.add(item)
}

fun numberOfItems(): Int {
    return items.size
}

fun findOne(id: Int): Item? {
    return items.find { it.id == id }
}

fun delete(id: Int): Boolean {
    return items.removeIf { it.id == id }
}

fun update(id: Int, newItem: Item): Boolean {
    val foundItem = findOne(id)


    if (foundItem != null) {
        foundItem.itemContents = newItem.itemContents
        foundItem.isItemComplete = newItem.isItemComplete
        return true
    }

    return false
}

fun checkNoteCompletionStatus(): Boolean {
    if (items.isNotEmpty()) {
        for (item in items) {
            if (!item.isItemComplete)
                return false
        }
    }
    return true
}

fun listItems() =
    if (items.isEmpty()) "\u{1F6AB} NO ITEMS ADDED"
    else Utilities.formatSetString(items)

override fun toString(): String {
    val archived = if (isNoteArchived) 'Y' else 'N'
    return "$noteId: $noteTitle, Priority($notePriority), " +
            "Category($noteCategory), Archived($archived)\n" +
            listItems()
}