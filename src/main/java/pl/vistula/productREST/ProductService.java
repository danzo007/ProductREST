package pl.vistula.productREST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repoZaliubovskyi;

    public List<Product> listAllZaliubovskyi(){
        return repoZaliubovskyi.findAll();
    }

    public void saveZaliubovskyi(Product product){
        repoZaliubovskyi.save(product);
    }

    public Product getZaliubovskyi(Integer id){
        return repoZaliubovskyi.findById(id).get();
    }

    public void deleteZaliubovskyi(Integer id){
        repoZaliubovskyi.deleteById(id);
    }
}
