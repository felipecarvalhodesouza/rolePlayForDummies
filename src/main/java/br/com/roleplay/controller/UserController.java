package br.com.roleplay.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import br.com.roleplay.entity.UserEntity;
import br.com.roleplay.model.UserModel;
import br.com.roleplay.repository.UserRepository;
import br.com.roleplay.utils.Utils;

@Named(value = "userController")
@SessionScoped
public class UserController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private UserModel userModel;

	@Inject
	private UserRepository userRepository;

	@Inject
	private UserEntity userEntity;

	public UserModel getUserModel() {
		return userModel;
	}

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}

	public UserModel getUserSession() {

		FacesContext facesContext = FacesContext.getCurrentInstance();

		return (UserModel) facesContext.getExternalContext().getSessionMap().get("authenticatedUser");
	}

	public String logout() {

		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

		return "/index.xhtml?faces-redirect=true";
	}

	public String login() {

		if (StringUtils.isEmpty(userModel.getNickname()) || StringUtils.isBlank(userModel.getNickname())) {

			Utils.message("Nickname required");
			
			return null;
		} else if (StringUtils.isEmpty(userModel.getPassword()) || StringUtils.isBlank(userModel.getPassword())) {

			Utils.message("Password required");
			
			return null;
		} else {

			userEntity = userRepository.validateUser(userModel);

			if (userEntity != null) {

				userModel.setPassword(null);
				userModel.setId(userEntity.getId());

				FacesContext facesContext = FacesContext.getCurrentInstance();

				facesContext.getExternalContext().getSessionMap().put("authenticatedUser", userModel);

				return "system/home?faces-redirect=true";
			} else {

				Utils.message("It was not possible to authenticate.");
				
				return null;
			}
		}

	}

}