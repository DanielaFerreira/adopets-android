package com.example.adopets.model

open class Usuario(
    open var email: String = "",
    open var nome: String = "",
    open var senha: String = "",
    open var dataNasc: String = "",
    open var foto: ByteArray = "".toByteArray(),
    open var telefone: String = "",
    open var bairro: String = "",
    open var rua: String = "",
    open var numero: String = "",
    open var complemento: String = "",
    open var cep: String = ""
)

class Doador(override var email: String = "", override var nome: String = "",
             override var senha: String = "", override var dataNasc:String = "",
             override var foto: ByteArray = "".toByteArray(), override var telefone: String = "", override var bairro: String = "",
             override var rua: String = "", override var numero: String = "", override var complemento: String = "",
             override var cep: String = ""): Usuario(email, nome, senha, dataNasc, foto, telefone, bairro, rua, numero, complemento, cep)

class Adotante(override var email: String = "", override var nome: String = "",
               override var senha: String = "", override var dataNasc: String = "",
               override var foto: ByteArray = "".toByteArray(), override var telefone: String = "", override var bairro: String = "",
               override var rua: String = "", override var numero: String = "", override var complemento: String = "",
               override var cep: String = ""): Usuario(email, nome, senha, dataNasc, foto, telefone, bairro, rua, numero, complemento, cep)

class Voluntario(override var email: String = "", override var nome: String = "",
                 override var senha: String = "", override var dataNasc: String = "",
                 override var foto: ByteArray = "".toByteArray(), override var telefone: String = "", override var bairro: String = "",
                 override var rua: String = "", override var numero: String = "", override var complemento: String = "",
                 override var cep: String = "", var pontuacao: Float = 0F): Usuario(email, nome, senha,dataNasc, foto, telefone, bairro, rua, numero, complemento, cep)

class Contratante(override var email: String = "", override var nome: String = "",
                  override var senha: String = "", override var dataNasc: String = "",
                  override var foto: ByteArray = "".toByteArray(), override var telefone: String = "", override var bairro: String = "",
                  override var rua: String = "", override var numero: String = "", override var complemento: String = "",
                  override var cep: String = ""): Usuario(email, nome, senha, dataNasc, foto, telefone, bairro, rua, numero, complemento, cep)

class Processo(
    var id: String = "",
    var motivo: String = "",
    var situacao: String = "",
    var dataCriacao: String = "",
    var dataFim: String = "",
    var doador: Doador = Doador()
)

class AdotanteProcesso(
    var adotante: Adotante = Adotante(),
    var processo: Processo = Processo()
)

class Servico(
    var id: String = "",
    var tipo: String = "",
    var dataInicio: String = "",
    var dataFim: String = "",
    var descricao: String = "",
    var voluntario: Voluntario = Voluntario()
)

class ContratanteServico(
    var contratante: Contratante = Contratante(),
    var servico: Servico = Servico()
)

class Animal(
    var id: String = "",
    var foto: ByteArray = "".toByteArray(),
    var situacao: String = "",
    var raca: String = "",
    var descricao: String = "",
    var tamanho: String = "",
    var sexo: String = "",
    var necessidade: String = "",
    var tipo: String = "",
    var nome: String = "",
    var dataNasc: String = ""
)

class AnimalProceso(
    var animal: Animal = Animal(),
    var processo: Processo = Processo()
)

class AnimalServico(
    var animal: Animal = Animal(),
    var servico: Servico = Servico()
)
