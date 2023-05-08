package uz.data.talim.stansiyasi

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import uz.data.talim.stansiyasi.databinding.FragmentSignupBinding

class SignUpFragment: Fragment(R.layout.fragment_signup) {

    private lateinit var binding: FragmentSignupBinding

    private val firestore = Firebase.firestore

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentSignupBinding.bind(view)

        binding.register.setOnClickListener {
            if (binding.regName.text.toString().isEmpty() && binding.regPassword.text.toString().isEmpty()){
                Toast.makeText(requireContext(), "Please, write Name And Passeord", Toast.LENGTH_SHORT).show()
            }
            else if(binding.regName.text.toString().isEmpty()){
                Toast.makeText(requireContext(), "Please, write Name", Toast.LENGTH_SHORT).show()
            }
            else if(binding.regPassword.text.toString().isEmpty()){
                Toast.makeText(requireContext(), "Please, write Name", Toast.LENGTH_SHORT).show()
            }
            else{

                val user = hashMapOf(
                    "name" to binding.regName.text.toString(),
                    "password" to binding.regPassword.text.toString()
                )

                firestore.collection("users").document(binding.regName.text.toString())
                    .set(user)
                    .addOnSuccessListener {
                        Toast.makeText(requireContext(), "Your account created", Toast.LENGTH_SHORT).show()
                        findNavController().navigate(R.id.from_signup_to_home)
                    }
            }
        }
    }
}