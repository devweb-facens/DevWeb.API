package br.com.devweb.enums;


public enum Perfil {

	ADMIN(1,"ROLE_ADMIN"),
	PROFESSOR(2,"ROLE_PROFESSOR"),
	COORDENADOR(3,"ROLE_COORDENADOR");
	
	private int cod;
	private String descricao;
	
	private Perfil(int cod, String descricao) {
		this.cod = cod;
		this.descricao=descricao;
	}
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public static Perfil toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}else {
			for (Perfil x : Perfil.values()) {
				if(cod.equals(x.getCod())) {
					return x;
				}
			}
			throw new IllegalArgumentException("ID invalido" + cod);
		}
	}
}
