package com.farrasabiyyu12.kamusgaul.model;

//import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

//@Generated("com.robohorse.robopojogenerator")
public class EntriesItem{

	@SerializedName("authorName")
	private String authorName;

	@SerializedName("definition")
	private String definition;

	@SerializedName("authorId")
	private String authorId;

	@SerializedName("word")
	private String word;

	@SerializedName("slug")
	private String slug;

	@SerializedName("example")
	private String example;

	public void setAuthorName(String authorName){
		this.authorName = authorName;
	}

	public String getAuthorName(){
		return authorName;
	}

	public void setDefinition(String definition){
		this.definition = definition;
	}

	public String getDefinition(){
		return definition;
	}

	public void setAuthorId(String authorId){
		this.authorId = authorId;
	}

	public String getAuthorId(){
		return authorId;
	}

	public void setWord(String word){
		this.word = word;
	}

	public String getWord(){
		return word;
	}

	public void setSlug(String slug){
		this.slug = slug;
	}

	public String getSlug(){
		return slug;
	}

	public void setExample(String example){
		this.example = example;
	}

	public String getExample(){
		return example;
	}

	@Override
 	public String toString(){
		return 
			"EntriesItem{" + 
			"authorName = '" + authorName + '\'' + 
			",definition = '" + definition + '\'' + 
			",authorId = '" + authorId + '\'' + 
			",word = '" + word + '\'' + 
			",slug = '" + slug + '\'' + 
			",example = '" + example + '\'' + 
			"}";
		}
}