	package com.sunbeam.pojo;
	
	public class Movie {
		private int id;
	    private String title;
	    private String release;
	      

		public Movie() {
			super();
		}
		public Movie(int id, String title, String release) {
			super();
			this.id = id;
			this.title = title;
			this.release = release;
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
		public String getRelease() {
			return release;
		}
		public void setRelease(String release) {
			this.release = release;
		}
	    
		@Override
		public String toString() {
			return "Movies [id=" + id + ", title=" + title + ", release=" + release + "]";
		}
	
	}
