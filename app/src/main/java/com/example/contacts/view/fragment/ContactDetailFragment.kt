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
import com.example.contacts.view.listener.ContactDetailListener
import com.example.contacts.viewmodel.ContactDetailViewModel
import com.example.contacts.viewmodel.factory.ContactDetailViewModelFactory

class ContactDetailFragment : Fragment(), ContactDetailListener {
    private lateinit var binding: FragmentContactDetailBinding
    private lateinit var viewModel: ContactDetailViewModel

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
        viewModel =
            ViewModelProvider(this, ContactDetailViewModelFactory(activity!!.application, contact))
                .get(ContactDetailViewModel::class.java)

        binding.viewModel = viewModel
        binding.listener = this

        return binding.root
    }

    override fun onSaveClicked() {
        viewModel.saveContact()
    }
}
