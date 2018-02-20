package model;

import java.text.DecimalFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="artwork")
public class GalleryPiece {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="TITLE")
	private String title;
	@Column(name="ARTIST_NAME")
	private String artistName;
	@Column(name="MEDIA")
	private String media;
	@Column(name="YEAR")
	private String year;
	@Column(name="VALUE")
	private double value;

	
	public GalleryPiece() {
		
	}
	
	public GalleryPiece(String t, String a) {
		this.title = t;
		this.artistName = a;
	}
	
	public GalleryPiece(String t, String a, String m, String y, double v) {
		this.title = t;
		this.artistName = a;
		this.media = m;
		this.year = y;
		this.value = v;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public String getMedia() {
		return media;
	}

	public void setMedia(String media) {
		this.media = media;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
	
	public String returnAllArtDetails() {
		DecimalFormat df = new DecimalFormat("##.00");
		return "Title: " + title + "\tArtist: " + artistName + "\tMedia: " + media + "\tYear: " + year + "\tValue: $" + df.format(value);
	}
	
	public String returnTitleArtist() {
		return "Title: " + title + "\tArtist: " + artistName;
	}
	
	
}
