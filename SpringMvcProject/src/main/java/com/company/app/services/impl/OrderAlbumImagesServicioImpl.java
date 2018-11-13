/**
 * MailServicioImpl.java
 */
package com.company.app.services.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.app.commons.exceptions.ServicioException;
import com.company.app.dao.interfaz.MediaDAO;
import com.company.app.dao.interfaz.ObjectsDAO;
import com.company.app.model.MediaVO;
import com.company.app.model.ObjectsVO;
import com.company.app.services.inter.OrderAlbumImagesServicio;

/**
 * <p>
 * Nombre Clase: UtilMAil
 * </p>
 * <p>
 * Descripcion
 * </p>
 * <p>
 * Metodos de la clase
 * </p>
 * 
 * @author
 * 
 * @d02/03/2010
 */
@Service
public class OrderAlbumImagesServicioImpl implements OrderAlbumImagesServicio {

	protected static final Logger logger = Logger.getLogger(Thread
			.currentThread().getClass());

	private static final String CONSTANTE_RUTA_DIR_INT_IMAGES = "D://wamp//www//galeria//files//gimgs//";

	private static final String CONSTANTE_RUTA_DIR_OUT_IMAGES = "d://images//";

	@Autowired
	private MediaDAO mediaDAO;

	@Autowired
	private ObjectsDAO objectsDAO;

	/**
	 * <{@inheritDoc}
	 */
	public boolean orderAlbumImages() throws ServicioException {

		// Obtenemos todas las carpetas
		List<ObjectsVO> listObjects = null;
		List<MediaVO> listMedia = null;
		String strRuta = null;
		try {

			listObjects = this.getObjectsDAO().findAllObjectsVO();
			listMedia = this.getMediaDAO().findAllMediaVO();

			if (listObjects != null) {

				for (Iterator<ObjectsVO> iterator = listObjects.iterator(); iterator
						.hasNext();) {
					ObjectsVO objectsVO = (ObjectsVO) iterator.next();
					strRuta = createFolder(objectsVO);
					if (strRuta != null && !strRuta.isEmpty()) {
						insertImagesFolder(listMedia, objectsVO, strRuta);
					}

				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	private boolean copyImagesFromGimgs(String rutaOrigen, String rutaDestino){
		boolean isOk= false;
		 try {
             Path origenPath = Paths.get(rutaOrigen);
             Path destinoPath = Paths.get(rutaDestino);
             //sobreescribir el fichero de destino si existe y lo copia
             Files.copy(origenPath, destinoPath, StandardCopyOption.REPLACE_EXISTING);
             isOk = true;
         } catch (FileNotFoundException ex) {
             ex.printStackTrace();
         } catch (IOException ex) {
        	 ex.printStackTrace();
         }
		 return isOk;
	}

	private boolean insertImagesFolder(List<MediaVO> listMedia,
			ObjectsVO objectsVO, String strRuta) throws ServicioException {
		MediaVO mediaVO = null;
		List<MediaVO> listMediaTemp = null;
		try {
			if (listMedia != null) {
				listMediaTemp = new ArrayList<MediaVO>();
				for (Iterator<MediaVO> iterator = listMedia.iterator(); iterator
						.hasNext();) {
					mediaVO = (MediaVO) iterator.next();
					if (mediaVO.getMedia_ref_id()!=null && mediaVO.getMedia_ref_id().equals(objectsVO.getId())){
						copyImagesFromGimgs(CONSTANTE_RUTA_DIR_INT_IMAGES+mediaVO.getMedia_file(),strRuta+"//"+mediaVO.getMedia_file());
//						File file= new File(strRuta+"//"+mediaVO.getMedia_file());
//						file.createNewFile();
					} else {
						listMediaTemp.add(mediaVO);
					}
				}
				listMedia = listMediaTemp;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	private String createFolder(ObjectsVO objectsVO) throws ServicioException {
		File file = null;
		String[] carpetas = null;
		String strRuta = null;
		try {
			if (objectsVO != null && objectsVO.getYear() != null
					&& !objectsVO.getYear().isEmpty()) {
				file = new File(CONSTANTE_RUTA_DIR_OUT_IMAGES
						+ objectsVO.getYear());
				if (!file.isDirectory()) {
					if (!file.mkdir()) {
						System.out.println("Error al crear la carpeta: "
								+ file.getAbsolutePath());
					}
				}
				carpetas = objectsVO.getUrl().split("/");
				if (carpetas != null && carpetas.length > 0) {
					strRuta = CONSTANTE_RUTA_DIR_OUT_IMAGES
							+ objectsVO.getYear();
					for (int i = 0; i < carpetas.length; i++) {
						if (carpetas[i].length() > 0
								&& !"project".equals(carpetas[i])
								&& !"projects".equals(carpetas[i])) {
							strRuta = strRuta + "//" + carpetas[i];
							file = new File(strRuta);
							if (!file.isDirectory()) {
								if (!file.mkdir()) {
									System.out
											.println("Error al crear la carpeta: "
													+ file.getAbsolutePath());
								}
							}
						}
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strRuta;
	}

	public MediaDAO getMediaDAO() {
		return mediaDAO;
	}

	public void setMediaDAO(MediaDAO mediaDAO) {
		this.mediaDAO = mediaDAO;
	}

	public ObjectsDAO getObjectsDAO() {
		return objectsDAO;
	}

	public void setObjectsDAO(ObjectsDAO objectsDAO) {
		this.objectsDAO = objectsDAO;
	}

}
