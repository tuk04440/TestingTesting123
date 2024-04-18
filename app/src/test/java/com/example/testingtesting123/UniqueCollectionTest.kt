package com.example.testingtesting123

import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class UniqueCollectionTest {

    lateinit var collection: UniqueCollection

    @Before
    fun setUp() {
        collection = UniqueCollection()
    }

    @Test
    fun addAnItem() {
        collection.addItem(Item("Item1"))
        val item = collection.get(0)
        assert(item.name == "Item1")
    }

    @Test
    fun addUniqueItem() {
        collection.addItem(Item("Item1"))
        collection.addItem(Item("item1"))
        collection.addItem(Item("Item2"))

        assert (collection.size() == 2)
    }

    @Test
    fun clearAllItems() {
        collection.addItem(Item("item1"))
        collection.addItem(Item("Item2"))

        val originalSize = collection.size()
        collection.clear()
        val newSize = collection.size();

        assert(originalSize == 2 && newSize == 0) {"Items not cleared"}
    }

    @Test
    fun getItem() {
        collection.addItem(Item("item1"))
        collection.addItem(Item("Item2"))
        collection.addItem(Item("item3"))

        assert(collection.get(1) == Item("Item2")) {"Item not retrieved"}
    }

    //remove from empty list
    //remove item that is not in list
    //remove item in list
    @Test
    fun removeItem(){
        // remove from empty list test
        var initialSizeList = collection.size()
        collection.remove(Item("SampleItem"))
        assert(collection.size() == initialSizeList) {"Item not removed from empty list: trivial"}

        collection.addItem(Item("item1"))
        collection.addItem(Item("Item2"))
        collection.addItem(Item("item3"))

        initialSizeList = collection.size()
        collection.remove(Item("SampleItem"))
        assert(collection.size() == initialSizeList) {"Item not in list not removed?"}
    }
}