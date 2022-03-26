// package com.examly.springapp.Controllers;

// import java.util.List;
// import java.util.NoSuchElementException;
// import java.util.stream.Collectors;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpHeaders;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.multipart.MultipartFile;
// import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

// //import ma.files.store.message.ResponseFile;
// import com.examly.springapp.message.ResponseFile;

// //import ma.files.store.message.ResponseMessage;
// import com.examly.springapp.message.ResponseMessage;

// //import ma.files.store.model.FileDB;
// //import com.examly.springapp.Models.FileDB;

// import com.examly.springapp.Repository.FileDBRepository;

// //import ma.files.store.service.FileStorageService;
// import com.examly.springapp.Services.FileStorageService;

// @Controller
// // @CrossOrigin("http://localhost:8081")
// public class FileController 
// {

// 	@Autowired
// 	private FileStorageService storageService;

// 	@PostMapping("/upload")
// 	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) 
// 	{
// 		String message = "";
// 		try 
// 		{
// 			storageService
// 			.store(file);

// 			message = "Uploaded the file successfully: " 
// 			+ file.getOriginalFilename();
// 			return ResponseEntity
// 			.status(HttpStatus.OK)
// 			.body(new ResponseMessage(message));
// 		} 
// 		catch (Exception e) 
// 		{
// 			message = "Could not upload the file: " 
// 			+ file.getOriginalFilename() + "!";
// 			return ResponseEntity
// 			.status(HttpStatus.EXPECTATION_FAILED)
// 			.body(new ResponseMessage(message));
// 		}
// 	}

// 	@GetMapping("/files")
// 	public ResponseEntity<List<ResponseFile>> getListFiles() 
// 	{
// 		List<ResponseFile> files = storageService
// 		.getAllFiles()
// 		.map
// 		(dbFile -> 
// 		{
// 			String fileDownloadUri = ServletUriComponentsBuilder
// 			.fromCurrentContextPath()
// 			.path("/files/")
// 			.path(dbFile.getId()).toUriString();

// 			return new ResponseFile(dbFile.getName()
// 			, fileDownloadUri
// 			, dbFile
// 			.getType(), dbFile
// 			.getData()
// 			);
// 		}
// 		)
// 		.collect(Collectors.toList());

// 		return ResponseEntity.status(HttpStatus.OK)
// 		.body(files);
// 	}

// 	@GetMapping("/files/{id}")
// 	public ResponseEntity<Object> getFile(@PathVariable String id) 
// 	{
		
// 		try 
// 		{
// 			FileDBRepository fileDB = storageService
// 			.getFile(id);

// 			// Response type: byte[]
// 			return ResponseEntity
// 			.ok()
// 					.header(HttpHeaders
// 					.CONTENT_DISPOSITION,
// 					 "attachment; filename=\"" 
// 					 + fileDB.getName()
// 					  + "\"")
// 					.body(fileDB
// 					.getData());
// 		} 
// 		catch (NoSuchElementException e) 
// 		{
// 			return ResponseEntity
// 			.status(HttpStatus.EXPECTATION_FAILED)
// 			.body(new ResponseMessage(e.getMessage()));
// 		}
// 	}
	
// 	@DeleteMapping("/files/{id}")
// 	public ResponseEntity<ResponseMessage> deletFileById(@PathVariable String id) 
// 	{
// 		String message = "";
// 		message = storageService.deletFileById(id);
// 		return ResponseEntity
// 		.status(HttpStatus.OK)
// 		.body(new ResponseMessage(message));
		
// 	}
// }