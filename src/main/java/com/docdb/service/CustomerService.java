package com.docdb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.docdb.exception.UserException;
import com.docdb.model.entity.Customer;
import com.docdb.model.entity.Document;
import com.docdb.model.entity.dto.CustomerDTO;
import com.docdb.model.repository.CustomerRepository;
import com.docdb.model.repository.base.BaseRepository;
import com.docdb.service.base.BasePersistenceService;
import com.docdb.service.util.dto.DTOConverter;
import com.docdb.service.util.impl.FileHandlerService;

@Service
public class CustomerService extends BasePersistenceService<Customer, CustomerDTO, Integer> {

	
	@Autowired
	private FileHandlerService fileHandlerService;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private DocumentService docService;
	
	@Autowired
	private UserService userService;
	
	public CustomerService(BaseRepository<Customer, Integer> baseRepository, DTOConverter<Customer, CustomerDTO> dtoConverter) {
		super(baseRepository, dtoConverter);
	}
		
	public Customer addDocument(MultipartFile mpf, String id) throws UserException {
		
		Document document = new Document();
		
		Customer customer = userService.find(Integer.parseInt(id)).getCustomer();
		
		try {
			document.setData(fileHandlerService.createBlobForProfileImage(mpf));
			document.setSize(mpf.getSize());
			document.setName(mpf.getName());
			document.setContentType(mpf.getContentType());
			
			customer.setImage(document);
			document.setCustomer(customer);
			
			docService.save(document);
			
			return customerRepository.save(customer);
			
			
		} catch (NumberFormatException  e) {
			return null;
		}
	}
	
	public void saveCustomer(Customer customer) {
		baseRepository.save(customer);
	}

}
