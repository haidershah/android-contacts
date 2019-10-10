package com.example.contacts.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.contacts.R
import com.example.contacts.databinding.FragmentContactsBinding
import com.example.contacts.domain.model.Contact
import com.example.contacts.view.adapter.ContactsAdapter
import com.example.contacts.view.listener.ContactsListener
import com.example.contacts.viewmodel.ContactsViewModel
import com.example.contacts.viewmodel.factory.ContactsViewModelFactory

class ContactsFragment : Fragment(), ContactsListener {

    private lateinit var binding: FragmentContactsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_contacts,
            container,
            false
        )

        val viewModel = ViewModelProvider(
            this, ContactsViewModelFactory(context!!)
        )
            .get(ContactsViewModel::class.java)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.contactsRecyclerView.setHasFixedSize(true)
        binding.contactsRecyclerView.adapter = ContactsAdapter(this)

        return binding.root
    }

    override fun onContactClicked(contact: Contact) {
        findNavController().navigate(
            ContactsFragmentDirections.actionContactsFragmentToContactDetailFragment(contact)
        )
    }
}
