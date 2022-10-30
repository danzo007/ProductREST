package pl.vistula.productREST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class ProductController {

    @Autowired
    private ProductService serviceZaliubovskyi;

    @GetMapping("/products")
    public List<Product> listZaliubovskyi(){
        return serviceZaliubovskyi.listAllZaliubovskyi();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getZaliubovskyi(@PathVariable Integer id){
        try{
            Product productZaliubovskyi = serviceZaliubovskyi.getZaliubovskyi(id);
            return new ResponseEntity<Product>(productZaliubovskyi, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/products")
    public void addZaliubovskyi(@RequestBody Product product){
        serviceZaliubovskyi.saveZaliubovskyi(product);
    }

    @PutMapping("/products/{idZaliubovskyi}")
    public ResponseEntity<?> updateZaliubovskyi(@RequestBody Product productZaliubovskyi, @PathVariable Integer idZaliubovskyi){
        try {
            Product productToBeExistedZaliubovskyi = serviceZaliubovskyi.getZaliubovskyi(idZaliubovskyi);
            serviceZaliubovskyi.saveZaliubovskyi(productZaliubovskyi);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>("Error message: No such element", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<?> deleteZaliubovskyi(@PathVariable Integer id){
        try {
            Product productToBeExistedZaliubovskyi = serviceZaliubovskyi.getZaliubovskyi(id);
            serviceZaliubovskyi.deleteZaliubovskyi(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>("Error message: No such element",HttpStatus.NOT_FOUND);
        }
    }

}
