package sprzet;

import java.io.Serializable;

public class Mikrofon implements Serializable{
	private String marka;
	private String model;
	private boolean CzyDynamiczny;
	
	public Mikrofon() {
		marka = "Shure";
		model = "SM58-LCE";
		CzyDynamiczny = true;
	}
	
	public Mikrofon(String marka, String model, boolean CzyDynamiczny) {
		this.marka = marka;
		this.model = model;
		this.CzyDynamiczny = CzyDynamiczny;
	}
	

	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public boolean getCzyDynamiczny() {
		return CzyDynamiczny;
	}

	public void setCzyDynamiczny(boolean czyDynamiczny) {
		CzyDynamiczny = czyDynamiczny;
	}
	
}
