package com.example.contacts.view.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.contacts.domain.model.Contact
import com.example.contacts.view.adapter.ContactsAdapter

@BindingAdapter("listData")
fun RecyclerView.listData(contacts: List<Contact>?) {
    val adapter = adapter as ContactsAdapter
    adapter.submitList(contacts)
}
