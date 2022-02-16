package resources;

import java.util.Collection;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MetodosResource {
	
	public static final boolean estaVazio(Object obj) { //change
		if (obj == null)
			return true;
		if (obj instanceof String)
			return estaVazio((String) obj);
		if (obj instanceof Number) {
			Number i = (Number) obj;
			return (i.intValue() == 0);
		}
		if (obj instanceof Object[])
			return ((Object[]) obj).length == 0;
		if (obj instanceof int[])
			return ((int[]) obj).length == 0;
		if (obj instanceof Collection<?>)
			return ((Collection<?>) obj).size() == 0;
		if (obj instanceof Map<?, ?>)
			return ((Map<?, ?>) obj).size() == 0;
		return false;
	}

	public static boolean estaVazio(String str) {
		if (str == null || str.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public static void addMensagem(String msg) {
		FacesMessage mensagem = new FacesMessage(msg);
		FacesContext.getCurrentInstance().addMessage(null, mensagem);
	}

}
