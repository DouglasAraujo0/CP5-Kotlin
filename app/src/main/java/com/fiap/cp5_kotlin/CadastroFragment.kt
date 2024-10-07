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

        // Configuração o Spinner
        val opcoes = arrayOf("Opção 1", "Opção 2", "Opção 3")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, opcoes)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerOpcao.adapter = adapter

        // Definindo o texto do botão e os hints
        binding.btnCadastrar.text = getString(R.string.cadastrar)  
        binding.inputNome.hint = getString(R.string.nome)          
        binding.inputEmail.hint = getString(R.string.email)       
        binding.inputTelefone.hint = getString(R.string.telefone) 
        binding.inputEndereco.hint = getString(R.string.endereco) 
        binding.inputObservacao.hint = getString(R.string.observacao)

        binding.btnCadastrar.setOnClickListener {
            // Coletando dados do formulário
            val nome = binding.inputNome.text.toString()
            val email = binding.inputEmail.text.toString()
            val telefone = binding.inputTelefone.text.toString()
            val endereco = binding.inputEndereco.text.toString()
            val observacao = binding.inputObservacao.text.toString()
            val opcaoSelecionada = binding.spinnerOpcao.selectedItem.toString() 

            // Repassando os dados para o fragmento de lista
            val listaFragment = ListaFragment()
            val bundle = Bundle().apply {
                putString("NOME", nome)
                putString("EMAIL", email)
                putString("TELEFONE", telefone)
                putString("ENDERECO", endereco)
                putString("OBSERVACAO", observacao)
                putString("OPCAO", opcaoSelecionada)
            }

            // Navegando para o fragmento de lista
            findNavController().navigate(R.id.action_cadastroFragment_to_listaFragment, bundle)
        }

        return binding.root
    }
}
