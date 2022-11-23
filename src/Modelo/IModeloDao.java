package Modelo;

import java.util.List;

public interface IModeloDao<T> {

	/**
	 * crear un nuevo objeto para que persista en algo(bbdd, fichero, xml, json)
	 * 
	 * @param t el objeto a crear
	 */
	public void create(T t);

	/**
	 * eliminar un objeto de la persistencia
	 * 
	 * @param t objeto a eliminar
	 */

	public void delete(T t);

	/**
	 * obtener un objeto ?si le pido el id del objeto???
	 * 
	 * @param t objeto a busacar en modelo
	 */
	public T get(T t);

	/**
	 * retornar todos los objetos que tenemos
	 * 
	 * @return List de todos los objetos disponibles
	 */
	public List<T> list();

	/**
	 * modificar un objeto
	 * 
	 * @param t objeto a modificar.
	 */
	public void update(T t);
	
	/**
	 * guardar en la persistencia 
	 * puede ser .txt
	 * binario
	 * lista
	 * csv
	 * json
	 */
	public void save();
	
	/**
	 * cargar es un metoodo que nos recarga la lista
	 * de la persistencia
	 */
	public void cargar();
}
