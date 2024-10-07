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

        // Obtendo os dados do Bundle
        val nome = arguments?.getString("NOME")
        val email = arguments?.getString("EMAIL")
        val telefone = arguments?.getString("TELEFONE")
        val endereco = arguments?.getString("ENDERECO")
        val observacao = arguments?.getString("OBSERVACAO")
        val opcao = arguments?.getString("OPCAO")

        // Exibindo os dados na interface e exibindo opcao selecionada
        binding.txtNome.text = getString(R.string.nome) + ": " + nome
        binding.txtEmail.text = getString(R.string.email) + ": " + email
        binding.txtTelefone.text = getString(R.string.telefone) + ": " + telefone
        binding.txtEndereco.text = getString(R.string.endereco) + ": " + endereco
        binding.txtObservacao.text = getString(R.string.observacao) + ": " + observacao
        binding.txtOpcao.text = getString(R.string.opcao) + ": " + opcao

        return binding.root
    }
}
