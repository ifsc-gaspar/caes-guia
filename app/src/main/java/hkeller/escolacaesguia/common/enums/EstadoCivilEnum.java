package hkeller.escolacaesguia.common.enums;

public enum EstadoCivilEnum {
  SOLTEIRO,
  UNIAO_ESTAVEL,
  CASADO,
  DIVORCIADO,
  VIUVO;

  @Override
  public String toString() {
    switch (this) {
      case SOLTEIRO:
        return "Solteiro";
      case UNIAO_ESTAVEL:
        return "União estável";
      case CASADO:
        return "Casado";
      case DIVORCIADO:
        return "Divorciado";
      case VIUVO:
        return "Viuvo";
    }
    return null;
  }
}
