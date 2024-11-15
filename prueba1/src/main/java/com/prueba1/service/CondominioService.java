
package com.prueba1.service;
import com.prueba1.domain.Prueba1;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired ;
    import org.springframework.stereotype.Service ;//service es un estereotipo en java, esta clase es de servicio
    import org.springframework.transaction.annotation.Transactional ;

/**
 *
 * @author Lizeth
 */
public interface CondominioService {
       
    public List<Condominio> getCondominio(boolean activos);
     
    public Condominio getCondominio(Condominio condominio);

   
    public void save(Condominio condominio);

  
    public void delete(Condominio condominio);
}
public class CondominioServiceImpl {

      
    @Service
    public class CondominioServiceImpl implements CondominioService {

        @Autowired// instancia en el service de la categoria dao del metodo findall, findbyid
        private CondominioDao condominioDao;

        @Override
        @Transactional(readOnly = true)//cuando estoy agregando los metodos de findall, o por id
        public List<Condominio> getCondominios(boolean activos) {
            var lista = condominioDao.findAll();
            if (activos) {
                lista.removeIf(e -> !e.isActivo());//no mostrar las categorias no activas
            }
            return lista;
        }

        @Override
        @Transactional(readOnly = true)
        public Condominio getCondominio(Condominio condominio) {
            return condominioDao.findBy(condominio.getIdCondominio()).orElse(null);

        }

        @Override
        @Transactional
        public void save(Condominio condominio)

        {
            condominioDao.save(condominio);
        }
        @Override
        @Transactional
        public void delete(Condominio condominio){
             condominioDao.delete(condominio);
        }

    }

}