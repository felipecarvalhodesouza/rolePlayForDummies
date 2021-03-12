package br.com.roleplay.repository;

import java.io.Serializable;

import javax.persistence.Query;

import br.com.roleplay.entity.UserEntity;
import br.com.roleplay.model.UserModel;
import br.com.roleplay.utils.Utils;

public class UserRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	public UserEntity validateUser(UserModel userModel) {

		try {

			// QUERY QUE VAI SER EXECUTADA (UsuarioEntity.findUser)
			Query query = Utils.JpaEntityManager().createNamedQuery("UserEntity.findUser");

			// PARÂMETROS DA QUERY
			query.setParameter("nickname", userModel.getNickname());
			query.setParameter("password", userModel.getPassword());

			// RETORNA O USUÁRIO SE FOR LOCALIZADO
			return (UserEntity) query.getSingleResult();

		} catch (Exception e) {
			return null;
		}
	}
}
