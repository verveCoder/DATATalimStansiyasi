package uz.data.talim.stansiyasi

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import uz.data.talim.stansiyasi.databinding.FragmentDetailsBinding

class DetailsFragment: Fragment(R.layout.fragment_details) {
    private lateinit var binding: FragmentDetailsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentDetailsBinding.bind(view)
    }
}