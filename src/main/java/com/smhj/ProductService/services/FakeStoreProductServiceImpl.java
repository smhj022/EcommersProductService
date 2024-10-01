package com.smhj.ProductService.services;

import com.smhj.ProductService.dtos.FakeStoreProductDto;
import com.smhj.ProductService.exceptions.CategoryNotFoundException;
import com.smhj.ProductService.exceptions.ProductNotFoundException;
import com.smhj.ProductService.models.Category;
import com.smhj.ProductService.models.Product;
import com.smhj.ProductService.thirdpartyclients.FakeStoreClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("FakeProductService")
public class FakeStoreProductServiceImpl implements ProductService {

    private FakeStoreClient fakeStoreClient;

    @Autowired
    public FakeStoreProductServiceImpl(FakeStoreClient fakeStoreClient){
        this.fakeStoreClient = fakeStoreClient;
    }

    @Override
    public Product getProductById(Long id) throws ProductNotFoundException {
        return getProductFromFakeStoreProductDto(fakeStoreClient.getProductById(id));
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<>();
        for(FakeStoreProductDto productDto : fakeStoreClient.getAllProducts()){
            productList.add(getProductFromFakeStoreProductDto(productDto));
        }
        return productList;
    }

    @Override
    public Product deleteProductById(Long id) throws ProductNotFoundException {
        return getProductFromFakeStoreProductDto(fakeStoreClient.deleteProductById(id));
    }

    @Override
    public Product addProduct(Product product) {
        return getProductFromFakeStoreProductDto(
                fakeStoreClient.addProduct(getFakeStoreProductDto(product)));
    }

    @Override
    public Product updateProductById(Long id, Product product) {
        return getProductFromFakeStoreProductDto(
                fakeStoreClient.updateProductById(id, getFakeStoreProductDto(product)));
    }

    @Override
    public List<Product> getProductsByCategory(Long id) throws CategoryNotFoundException {
        return null;
    }

    private Product getProductFromFakeStoreProductDto(FakeStoreProductDto fakeStoreProductDto){

        Product product = new Product();

        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        Category category = new Category();
        category.setName(fakeStoreProductDto.getCategory());
        product.setCategory(category);
        product.setPrice(fakeStoreProductDto.getPrice());

        return product;
    }

    private FakeStoreProductDto getFakeStoreProductDto(Product product){
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setTitle(product.getTitle());
        fakeStoreProductDto.setDescription(product.getDescription());
        fakeStoreProductDto.setCategory(product.getCategory().getName());
        fakeStoreProductDto.setPrice(product.getPrice());
        fakeStoreProductDto.setImage("https://image.com");
        return fakeStoreProductDto;
    }
}
