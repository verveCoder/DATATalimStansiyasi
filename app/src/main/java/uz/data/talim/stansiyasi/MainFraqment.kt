package uz.data.talim.stansiyasi

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import uz.data.talim.stansiyasi.databinding.FragmentMainBinding

class MainFraqment: Fragment(R.layout.fragment_main) {
    private lateinit var binding: FragmentMainBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentMainBinding.bind(view)

        binding.signup.setOnClickListener {
            findNavController().navigate(R.id.from_home_to_signup)
        }

        binding.signin.setOnClickListener {
            findNavController().navigate(R.id.from_home_to_signin)
        }
    }
}