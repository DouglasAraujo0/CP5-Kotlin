package com.fiap.cp5_kotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.fiap.cp5_kotlin.databinding.FragmentListaBinding

class ListaFragment : Fragment() {
    private lateinit var binding: FragmentListaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListaBinding.inflate(inflater, container, false)

        // Obter os dados do Bundle
        val nome = arguments?.getString("NOME")
        val email = arguments?.getString("EMAIL")
        val telefone = arguments?.getString("TELEFONE")
        val endereco = arguments?.getString("ENDERECO")
        val observacao = arguments?.getString("OBSERVACAO")
        val opcao = arguments?.getString("OPCAO") // Obter a opção selecionada

        // Exibir os dados na interface (ajuste conforme necessário)
        binding.txtNome.text = nome
        binding.txtEmail.text = email
        binding.txtTelefone.text = telefone
        binding.txtEndereco.text = endereco
        binding.txtObservacao.text = observacao
        binding.txtOpcao.text = opcao // Exibir a opção selecionada

        return binding.root
    }
}
