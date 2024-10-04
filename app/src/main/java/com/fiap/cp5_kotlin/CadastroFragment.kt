package com.fiap.cp5_kotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.fiap.cp5_kotlin.databinding.FragmentCadastroBinding

class CadastroFragment : Fragment() {
    private lateinit var binding: FragmentCadastroBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCadastroBinding.inflate(inflater, container, false)

        // Configurar o Spinner
        val opcoes = arrayOf("Opção 1", "Opção 2", "Opção 3")  // Substitua com suas opções
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, opcoes)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerOpcao.adapter = adapter

        binding.btnCadastrar.setOnClickListener {
            // Coletar dados do formulário
            val nome = binding.inputNome.text.toString()
            val email = binding.inputEmail.text.toString()
            val telefone = binding.inputTelefone.text.toString()
            val endereco = binding.inputEndereco.text.toString()
            val observacao = binding.inputObservacao.text.toString()
            val opcaoSelecionada = binding.spinnerOpcao.selectedItem.toString() // Obter a opção selecionada

            // Repassar os dados para o fragmento de lista
            val listaFragment = ListaFragment()
            val bundle = Bundle().apply {
                putString("NOME", nome)
                putString("EMAIL", email)
                putString("TELEFONE", telefone)
                putString("ENDERECO", endereco)
                putString("OBSERVACAO", observacao)
                putString("OPCAO", opcaoSelecionada) // Passar a opção selecionada
            }

            // Navegar para o fragmento de lista
            findNavController().navigate(R.id.action_cadastroFragment_to_listaFragment, bundle)
        }

        return binding.root
    }
}
