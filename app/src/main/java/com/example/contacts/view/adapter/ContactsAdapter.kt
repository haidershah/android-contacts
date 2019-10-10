package com.example.contacts.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.contacts.databinding.ListItemContactBinding
import com.example.contacts.domain.model.Contact

class ContactsAdapter :
    ListAdapter<Contact, ContactsAdapter.ContactViewHolder>(ContactDiffCallback()) {

    class ContactViewHolder(val binding: ListItemContactBinding) :
        RecyclerView.ViewHolder(binding.root)

    class ContactDiffCallback : DiffUtil.ItemCallback<Contact>() {
        override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ContactViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemContactBinding.inflate(inflater, parent, false)
        return ContactViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.contact = item
        holder.binding.executePendingBindings()
    }
}