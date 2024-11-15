
import com.tienda.service.ProductoService;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Lizeth
 */
public class ProductoServiceImpl {

    package com.tienda.service.impl ;

    import com.tienda.dao.ProductoDao ;
    import com.tienda.domain.Producto ;
    import com.tienda.service.ProductoService ;
    import java.util.List ;//
    import org.springframework.beans.factory.annotation.Autowired ;
    import org.springframework.stereotype.Service ;//service es un estereotipo en java, esta clase es de servicio
    import org.springframework.transaction.annotation.Transactional ;

    @Service
    public class ProductoServiceImpl implements ProductoService {

        @Autowired// instancia en el service de la producto dao del metodo findall, findbyid
        private ProductoDao productoDao;

        @Override
        @Transactional(readOnly = true)//cuando estoy agregando los metodos de findall, o por id
        public List<Producto> getProductos(boolean activos) {
            var lista = productoDao.findAll();
            if (activos) {
                lista.removeIf(e -> !e.isActivo());//no mostrar las productos no activas
            }
            return lista;
        }

        @Override
        @Transactional(readOnly = true)
        public Producto getProducto(Producto producto) {
            return productoDao.findBy(producto.getIdProducto()).orElse(null);

        }

        @Override
        @Transactional
        public void save(Producto producto)

        {
            productoDao.save(producto);
        }
        @Override
        @Transactional
        public void delete(Producto producto){
             productoDao.delete(producto);
        }

    }

}
