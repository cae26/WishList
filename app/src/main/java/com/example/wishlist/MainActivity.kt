package com.example.wishlist

import WishListAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val wishlists : MutableList<Item> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val wishListRv = findViewById<RecyclerView>(R.id.recyclerView)

        val adapter = WishListAdapter(wishlists)

        val submitButton = findViewById<Button>(R.id.submit)
        val itemNameText = findViewById<EditText>(R.id.itemName)
        val priceText = findViewById<EditText>(R.id.price)
        val webAddressText = findViewById<EditText>(R.id.webAddress)

        wishListRv.adapter =adapter

        wishListRv.layoutManager = LinearLayoutManager(this)


        submitButton.setOnClickListener {
            wishlists.add(Item(itemNameText.text.toString(),webAddressText.text.toString(),"$"+priceText.text.toString()))

            itemNameText.onEditorAction(EditorInfo.IME_ACTION_DONE)
            priceText.onEditorAction(EditorInfo.IME_ACTION_DONE)
            webAddressText.onEditorAction(EditorInfo.IME_ACTION_DONE)
            itemNameText.text = null
            priceText.text = null
            webAddressText.text = null

            adapter.notifyDataSetChanged()

        }
            //.setText(null)
    }
}