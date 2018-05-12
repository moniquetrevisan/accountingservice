package com.moniquetrevisan.basic.accountingservice.model;

import java.io.Serializable;

public class Stats implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2512002638553773280L;

	private float soma;
	private float min;
	private float max;
	private float media;
	private float qtde;

	public Stats() {

	}

	public Stats(float soma, float min, float max, float media, float qtde) {
		this.soma = soma;
		this.min = min;
		this.max = max;
		this.qtde = qtde;
	}

	public float getSoma() {
		return soma;
	}

	public void setSoma(float soma) {
		this.soma = soma;
	}

	public float getMin() {
		return min;
	}

	public void setMin(float min) {
		this.min = min;
	}

	public float getMax() {
		return max;
	}

	public void setMax(float max) {
		this.max = max;
	}

	public float getMedia() {
		return media;
	}

	public void setMedia(float media) {
		this.media = media;
	}

	public float getQtde() {
		return qtde;
	}

	public void setQtde(float qtde) {
		this.qtde = qtde;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(max);
		result = prime * result + Float.floatToIntBits(media);
		result = prime * result + Float.floatToIntBits(min);
		result = prime * result + Float.floatToIntBits(qtde);
		result = prime * result + Float.floatToIntBits(soma);
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
		Stats other = (Stats) obj;
		if (Float.floatToIntBits(max) != Float.floatToIntBits(other.max))
			return false;
		if (Float.floatToIntBits(media) != Float.floatToIntBits(other.media))
			return false;
		if (Float.floatToIntBits(min) != Float.floatToIntBits(other.min))
			return false;
		if (Float.floatToIntBits(qtde) != Float.floatToIntBits(other.qtde))
			return false;
		if (Float.floatToIntBits(soma) != Float.floatToIntBits(other.soma))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Stats [soma=" + soma + ", min=" + min + ", max=" + max + ", media=" + media + ", qtde=" + qtde + "]";
	}

}
