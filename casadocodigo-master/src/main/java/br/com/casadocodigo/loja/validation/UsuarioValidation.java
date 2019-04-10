package br.com.casadocodigo.loja.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.casadocodigo.loja.dao.UsuarioDAO;
import br.com.casadocodigo.loja.models.Usuario;

public class UsuarioValidation implements Validator {
	private UsuarioDAO usuarioDAO;
	
	@Autowired
	public UsuarioValidation(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return Usuario.class.isAssignableFrom(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "nome", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "email", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "senha", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "repetirSenha", "field.required");

		Usuario usuario = (Usuario) target;
		if (usuario.getSenha().length() < 5) errors.rejectValue("senha", "field.password.min");
		if (!usuario.getSenha().equals(usuario.getRepetirSenha()))	errors.rejectValue("repetirSenha", "field.password.repeat");
		
		try {
			Usuario usuario2 = usuarioDAO.loadUserByUsername(usuario.getEmail());
			System.out.println(usuario2);
			errors.rejectValue("email", "field.email.exists");
		} catch (Exception e) {
		}
	}
	
}
