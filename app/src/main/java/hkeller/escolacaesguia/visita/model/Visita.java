package hkeller.escolacaesguia.visita.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "visita")
public class Visita {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "nome_escola", nullable = false)
  private String nomeEscola;

  @Column(nullable = false)
  private String email;

  @Column(name = "cep")
  private Integer cep;

  @Column(nullable = false)
  private String logradouro;

  @Column(nullable = false)
  private String numero;

  @Column(nullable = false)
  private String bairro;

  @Column(nullable = false)
  private String cidade;

  @Column(nullable = false)
  private String estado;

  @Column(name = "telefone_escola")
  private Long telefoneEscola;

  @Column(name = "nome_responsavel", nullable = false)
  private String nomeResponsavel;

  @Column(name = "telefone_responsavel")
  private Long telefoneResponsavel;

  @Column(name = "numero_alunos")
  private Integer numeroAlunos;

  @Column(name = "serie_escolar", nullable = false)
  private String serieEscolar;

  @Column(name = "idade_alunos")
  private Integer idadeAlunos;

  @Column(name = "texto_objetivo", nullable = false)
  private String textoObjetivo;

  @Column(name = "sim_nao")
  private Integer simNao;

  @Column(name = "data_visita")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate dataVisita;

  @Column(name = "hora_visita")
  private Integer horaVisita;

  @Column(name = "informacoes_extras", nullable = false)
  private String informacoesExtras;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNomeEscola() {
    return nomeEscola;
  }

  public void setNomeEscola(String nomeEscola) {
    this.nomeEscola = nomeEscola;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Integer getCep() {
    return cep;
  }

  public void setCep(Integer cep) {
    this.cep = cep;
  }

  public String getLogradouro() {
    return logradouro;
  }

  public void setLogradouro(String logradouro) {
    this.logradouro = logradouro;
  }

  public String getNumero() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  public String getBairro() {
    return bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  public String getCidade() {
    return cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public Long getTelefoneEscola() {
    return telefoneEscola;
  }

  public void setTelefoneEscola(Long telefoneEscola) {
    this.telefoneEscola = telefoneEscola;
  }

  public String getNomeResponsavel() {
    return nomeResponsavel;
  }

  public void setNomeResponsavel(String nomeResponsavel) {
    this.nomeResponsavel = nomeResponsavel;
  }

  public Long getTelefoneResponsavel() {
    return telefoneResponsavel;
  }

  public void setTelefoneResponsavel(Long telefoneResponsavel) {
    this.telefoneResponsavel = telefoneResponsavel;
  }

  public Integer getNumeroAlunos() {
    return numeroAlunos;
  }

  public void setNumeroAlunos(Integer numeroAlunos) {
    this.numeroAlunos = numeroAlunos;
  }

  public String getSerieEscolar() {
    return serieEscolar;
  }

  public void setSerieEscolar(String serieEscolar) {
    this.serieEscolar = serieEscolar;
  }

  public Integer getIdadeAlunos() {
    return idadeAlunos;
  }

  public void setIdadeAlunos(Integer idadeAlunos) {
    this.idadeAlunos = idadeAlunos;
  }

  public String getTextoObjetivo() {
    return textoObjetivo;
  }

  public void setTextoObjetivo(String textoObjetivo) {
    this.textoObjetivo = textoObjetivo;
  }

  public Integer getSimNao() {
    return simNao;
  }

  public void setSimNao(Integer simNao) {
    this.simNao = simNao;
  }

  public LocalDate getDataVisita() {
    return dataVisita;
  }

  public void setDataVisita(LocalDate dataVisita) {
    this.dataVisita = dataVisita;
  }

  public Integer getHoraVisita() {
    return horaVisita;
  }

  public void setHoraVisita(Integer horaVisita) {
    this.horaVisita = horaVisita;
  }

  public String getInformacoesExtras() {
    return informacoesExtras;
  }

  public void setInformacoesExtras(String informacoesExtras) {
    this.informacoesExtras = informacoesExtras;
  }
}
