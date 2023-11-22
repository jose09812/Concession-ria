package concessionaria.concessionaria.Enum;

public enum Cargo {
    GERENTE("Gerente"),ATENDENTE("Atendente"),VENDEDOR("Vendedor"),ADMINISTRADOR("Administrador");
    String cargo;
    Cargo(String cargo){
        this.cargo = cargo;
    }
}
