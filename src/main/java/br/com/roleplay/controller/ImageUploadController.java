package br.com.roleplay.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Base64;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import br.com.roleplay.utils.Utils;

@Named(value="imageUploadController")
@SessionScoped
public class ImageUploadController implements Serializable{

	private static final long serialVersionUID = 1L;
	private String base64;
	
	public String getBase64() {
		return base64;
	}

	public void setBase64(String base64) {
		this.base64 = base64;
	}

	public void handleFileUpload(FileUploadEvent event) throws IOException {
		if (event != null && event.getFile() != null) {
			base64 = Utils.getImageFromUpload(event.getFile());
			Utils.getSessionMap().put("classImage", base64);
		}
	}

	public StreamedContent getImage() {
		if (Utils.getSessionMap().get("classImage") != null) {
			String base64 = (String) Utils.getSessionMap().get("classImage");
			byte[] decodedBytes = Base64.getDecoder().decode(base64);
			return DefaultStreamedContent.builder().contentType("image/jpg").stream(() -> {
				return new ByteArrayInputStream(decodedBytes);
			}).build();
		}
		return null;
	}

}
