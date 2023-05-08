package uz.data.talim.stansiyasi

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import uz.data.talim.stansiyasi.databinding.FragmentSigninBinding


class SignInFragment: Fragment(R.layout.fragment_signin) {

    private lateinit var binding: FragmentSigninBinding

    private val firestore = Firebase.firestore

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentSigninBinding.bind(view)

        binding.login.setOnClickListener {
            if (binding.logName.text.toString().isNotEmpty() && binding.logPassword.text.toString().isNotEmpty()) {
                val readData = firestore.collection("users").document(binding.logName.text.toString())
                readData.get()
                    .addOnSuccessListener { document ->
                        val name = document.getString("name")
                        val pass = document.getString("password")

                        if (name == binding.logName.text.toString() && pass == binding.logPassword.text.toString()){
                            findNavController().navigate(R.id.from_signin_to_catalog)
                        }
                        else{
                            Toast.makeText(requireContext(), "Your account not found. Please, SIGN UP", Toast.LENGTH_SHORT).show()
                        }
                    }
            }
            else{
                Toast.makeText(requireContext(), "Please, write Name And Passeord", Toast.LENGTH_SHORT).show()
            }
        }
    }
}