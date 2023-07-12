package ar.edu.unju.fi.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ListaCategoria {
	private List<String> categorias;

	public ListaCategoria() {
		categorias = new ArrayList<String>();
		categorias.add("Recetas de Carnes");
		categorias.add("Recetas de Pescados");
		categorias.add("Recetas de Ensaladas");
		categorias.add("Recetas de Legumbres y Cereales");
		categorias.add("Recetas de Sopas y Cremas");
		categorias.add("Recetas de Bebidas");
		categorias.add("Recetas de Dulces");
		categorias.add("Recetas de Pan");

	}

	public List<String> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<String> categorias) {
		this.categorias = categorias;
	}

}