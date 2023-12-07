package hkeller.escolacaesguia.common.enums;

public enum GrauInstrucaoEnum {
  NAO_ALFABETIZADO,
  ENSINO_FUNDAMENTAL_INCOMPLETO,
  ENSINO_FUNDAMENTAL_COMPLETO,
  ENSINO_MEDIO_INCOMPLETO,
  ENSINO_MEDIO_COMPLETO,
  GRADUACAO_INCOMPLETA,
  GRADUCAO_COMPLETA,
  POS_GRADUACAO,
  MESTRADO_OU_DOUTORADO_INCOMPLETO,
  MESTRADO_OU_DOUTURADO_COMPLETO;

  @Override
  public String toString() {
    switch (this) {
      case NAO_ALFABETIZADO:
        return "Não alfabetizado";
      case ENSINO_FUNDAMENTAL_INCOMPLETO:
        return "Ensino fundamental incompleto";
      case ENSINO_FUNDAMENTAL_COMPLETO:
        return "Ensino fundamental completo";
      case ENSINO_MEDIO_INCOMPLETO:
        return "Ensino médio incompleto";
      case ENSINO_MEDIO_COMPLETO:
        return "Ensino médio completo";
      case GRADUACAO_INCOMPLETA:
        return "Graduação incompleta";
      case GRADUCAO_COMPLETA:
        return "Graduação completa";
      case POS_GRADUACAO:
        return "Pós graduação";
      case MESTRADO_OU_DOUTORADO_INCOMPLETO:
        return "Mestrado ou doutorado incompleto";
      case MESTRADO_OU_DOUTURADO_COMPLETO:
        return "Mestrado ou doutorado completo";
    }
    return null;
  }
}
