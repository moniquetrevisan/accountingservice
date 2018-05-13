package com.moniquetrevisan.basic.accountingservice.model;

import java.io.Serializable;

public class Accounting implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5033929702358323745L;
	private String id;
	private String contaContabil;
	private String data;
	private float valor;
	
	public Accounting() {
		
	}
	
	public Accounting(String id, String contaContabil, String data, float valor) {
		this.id = id;
		this.contaContabil = contaContabil;
		this.data = data;
		this.valor = valor;
	}
	
	public Accounting(String contaContabil, String data, float valor) {
		this.contaContabil = contaContabil;
		this.data = data;
		this.valor = valor;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContaContabil() {
		return contaContabil;
	}

	public void setContaContabil(String contaContabil) {
		this.contaContabil = contaContabil;
	}

	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contaContabil == null) ? 0 : contaContabil.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + Float.floatToIntBits(valor);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Accounting other = (Accounting) obj;
		if (contaContabil == null) {
			if (other.contaContabil != null)
				return false;
		} else if (!contaContabil.equals(other.contaContabil))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Float.floatToIntBits(valor) != Float.floatToIntBits(other.valor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return getId() + "," + getContaContabil() + "," + getData() + "," + getValor();
	}
	
}