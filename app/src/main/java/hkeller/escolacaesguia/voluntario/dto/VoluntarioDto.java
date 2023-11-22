package hkeller.escolacaesguia.voluntario.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder

public class VoluntarioDto {
  private Long id;
  private String nome;
  private String nacionalidade;
  private String estadoCivil;
  private String funcao;
  private String email;
  private String telefone;
  private String rua;
  private String numero;
  private String cidade;
  private String cep;
  private String estado;
  private String identidade; // RG
  private String cpf;
  private String instagram;
  private String facebook;
  private String linkedin;
  private String formacao;
  private String cursoFormacao; // Nome do curso de formação
  private String statusFormacao;
  private String experienciasProfissionais;
  private String experienciasVoluntariado;
  private String tempoDisponivel;
  private Date dataInicio;
  private Date dataFim;
  private String atividadesRealizar;
  private String cao;
  //private Long caoId;
  //aqui
  private String caoNome;
  private String caoSexo;
  private String caoRaca;
  private Long caoMicrochip;
  private String caoCor;
  private Date caoDataNascimento;



}
