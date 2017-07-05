package model;

import java.io.InputStream;

public class Picture {
	private String contentType;
	private InputStream inputStream;
	
	public Picture(String contentType, InputStream inputStream) {
          this.contentType = contentType;
          this.inputStream = inputStream;
		
	}
	
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

}
