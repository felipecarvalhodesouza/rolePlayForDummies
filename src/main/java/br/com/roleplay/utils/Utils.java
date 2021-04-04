package br.com.roleplay.utils;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.model.file.UploadedFile;

public class Utils {

	public static String applicationResources = "br.com.roleplay.messages.messages";

	public static EntityManager JpaEntityManager() {

		FacesContext facesContext = FacesContext.getCurrentInstance();

		ExternalContext externalContext = facesContext.getExternalContext();

		HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();

		return (EntityManager) request.getAttribute("entityManager");
	}

	// MOSTRAR MENSAGEM
	public static void message(String message) {

		FacesContext facesContext = FacesContext.getCurrentInstance();

		facesContext.addMessage(null, new FacesMessage("Alert", message));
	}

	// MOSTRAR MENSAGEM
	public static void warningMessage(String message) {

		FacesContext facesContext = FacesContext.getCurrentInstance();

		facesContext.addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_WARN, getLocaleName("label.warning"), message));
	}

	// MOSTRAR MENSAGEM
	public static void infoMessage(String message) {

		FacesContext facesContext = FacesContext.getCurrentInstance();

		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", message));
	}

	public static Locale getLocaleContext() {
		return FacesContext.getCurrentInstance().getViewRoot().getLocale();
	}

	public static ResourceBundle getResouceBundle() {
		return ResourceBundle.getBundle(applicationResources, getLocaleContext());
	}

	public static String getLocaleName(String key) {
		return getResouceBundle().getString(key);
	}

	public static String replaceSpecialChars(String string) {
		return string.replaceAll("[^a-zA-Z]", "");
	}

	public static Map<String, Object> getSessionMap() {
		return FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	}

	public static BufferedImage resize(BufferedImage img, int height, int width) {
		Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = resized.createGraphics();
		g2d.drawImage(tmp, 0, 0, null);
		g2d.dispose();
		return resized;
	}

	public static byte[] toByteArray(BufferedImage bi, String format) throws IOException {

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(bi, format, baos);
		byte[] bytes = baos.toByteArray();
		return bytes;
	}
	
	public static String getImageFromUpload(UploadedFile file) throws IOException {
		ImageInputStream iis = ImageIO.createImageInputStream(new ByteArrayInputStream(file.getContent()));
		BufferedImage read = ImageIO.read(iis);
		read = Utils.resize(read, 200, 150);
		return Base64.getEncoder().encodeToString(Utils.toByteArray(read, "png"));
	}
}
