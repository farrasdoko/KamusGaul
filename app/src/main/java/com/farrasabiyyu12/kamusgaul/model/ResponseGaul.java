package com.farrasabiyyu12.kamusgaul.model;

import java.util.List;
//import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

//@Generated("com.robohorse.robopojogenerator")
public class ResponseGaul{

	@SerializedName("entries")
	private List<EntriesItem> entries;

	public void setEntries(List<EntriesItem> entries){
		this.entries = entries;
	}

	public List<EntriesItem> getEntries(){
		return entries;
	}

	@Override
 	public String toString(){
		return 
			"ResponseGaul{" + 
			"entries = '" + entries + '\'' + 
			"}";
		}
}