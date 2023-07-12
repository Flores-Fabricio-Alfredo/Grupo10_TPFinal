package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.service.ICommonService;
import ar.edu.unju.fi.util.ListaCategoria;

@Service
public class CommonServiceMysqlImp implements ICommonService{

	@Autowired
	ListaCategoria listaCategoria;

	@Override
	public List<String> getRecetasCategoria() {
		return listaCategoria.getCategorias();
	}
}