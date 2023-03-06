package com.example.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

//@Entity
public class Comments {
//    @Id
    private int comment_id;
    private String comment_text;
    private String comment_by;
    private int comment_time;
    private int descendants;
//    @OneToMany(cascade = CascadeType.ALL)
    private List<Integer> kids = new ArrayList<>();
    // getters and setters

	public Comments(int id, String comment_text2, String comment_by2, int time, List<Integer> kids2) {
		this.comment_id = id;
		this.comment_text = comment_text2;
		this.comment_by = comment_by2;
		this.comment_time = time;
		this.kids = kids2;
	}

	
	public Comments(int comment_id, String comment_text, String comment_by, int comment_time, int descendants,
			List<Integer> kids) {
		super();
		this.comment_id = comment_id;
		this.comment_text = comment_text;
		this.comment_by = comment_by;
		this.comment_time = comment_time;
		this.descendants = descendants;
		this.kids = kids;
	}


	public String getText() {
		return comment_text;
	}

	public void setText(String text) {
		this.comment_text = text;
	}

	public int getId() {
		return comment_id;
	}

	public void setId(int comment_id) {
		this.comment_id = comment_id;
	}

	public String getBy() {
		return comment_by;
	}

	public void setBy(String by) {
		this.comment_by = by;
	}

	public int getTime() {
		return comment_time;
	}

	public void setTime(int time) {
		this.comment_time = time;
	}

	public List<Integer> getKids() {
		return kids;
	}

	public void setKids(List<Integer> kids) {
		this.kids = kids;
	}

	public int getDescendants() {
		// TODO Auto-generated method stub
		return descendants;
	}

	public void setDescendants(int descendants) {
		this.descendants = descendants;
	}


    // getters and setters
    
}
