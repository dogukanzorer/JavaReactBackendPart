package nortwind.reactJavaProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import nortwind.reactJavaProject.business.abstracts.ProductService;
import nortwind.reactJavaProject.core.utilities.results.DataResult;
import nortwind.reactJavaProject.core.utilities.results.Result;
import nortwind.reactJavaProject.core.utilities.results.SuccessDataResult;
import nortwind.reactJavaProject.core.utilities.results.SuccessResult;
import nortwind.reactJavaProject.dataAccess.abstracts.ProductDao;
import nortwind.reactJavaProject.entities.concretes.Product;

@Service
public class ProductManager implements ProductService{
	
private ProductDao productDao;

@Autowired
public ProductManager(ProductDao productDao) {
	super();
	this.productDao = productDao;
}
@Override
public DataResult<List<Product>> getAll() {
	return new SuccessDataResult<List<Product>>
	(this.productDao.findAll(),"Data listelendi");	
}

@Override
public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
	Pageable pageable = PageRequest.of(pageNo-1, pageSize);
	
	return new SuccessDataResult<List<Product>>
	(this.productDao.findAll(pageable).getContent());
}

@Override
public Result add(Product product) {
	this.productDao.save(product);
	return new SuccessResult("Data  Eklendi!");
}

@Override
public DataResult<Product> getByProductName(String productName) {
	 return new SuccessDataResult<Product>
	(this.productDao.getByProductName(productName),"Data listelendi");
}

@Override
public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
	return new SuccessDataResult<Product>
	(this.productDao.getByProductNameAndCategory_CategoryId(productName,categoryId),"Data listelendi");
}

@Override
public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
	return new SuccessDataResult<List<Product>>
	(this.productDao.getByProductNameOrCategory_CategoryId(productName, categoryId),"Data listelendi");
}

@Override
public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
	 return new SuccessDataResult<List<Product>>
	(this.productDao.getByCategoryIn(categories),"Data listelendi");
}

@Override
public DataResult<List<Product>> getByProductNameContains(String productName) {
	 return new SuccessDataResult<List<Product>>
	(this.productDao.getByProductNameContains(productName),"Data listelendi");
}

@Override
public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
	return new SuccessDataResult<List<Product>>
	(this.productDao.getByProductNameStartsWith(productName),"Data listelendi");
}

@Override
public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
	 return new SuccessDataResult<List<Product>>
	(this.productDao.getByNameAndCategory(productName,categoryId),"Data listelendi");
}
@Override
public DataResult<Product> findById(int id) {
	
	 return new SuccessDataResult<Product>
		(this.productDao.findById(id),"Data listelendi");
	
}
	
	

	

	

}
