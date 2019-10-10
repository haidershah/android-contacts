package com.example.contacts.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.contacts.R
import com.example.contacts.databinding.FragmentContactDetailBinding
import com.example.contacts.viewmodel.ContactDetailViewModel
import com.example.contacts.viewmodel.factory.ContactDetailViewModelFactory

class ContactDetailFragment : Fragment() {

    private lateinit var binding: FragmentContactDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_contact_detail,
                container,
                false
            )

        val contact = ContactDetailFragmentArgs.fromBundle(arguments!!).contact
        val viewModel = ViewModelProvider(
            this, ContactDetailViewModelFactory(contact)
        )
            .get(ContactDetailViewModel::class.java)

        binding.viewModel = viewModel

        return binding.root
    }
}
