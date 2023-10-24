package com.paradigmas.subasta.controller;

import com.paradigmas.subasta.model.Producto;
import com.paradigmas.subasta.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/producto")
public class ProductoController {

	@Autowired
	private ProductoService productoService;
	
	@GetMapping(value = {"/","/registration"})
	public String registration(Map<String, Object> model) {
		model.put("producto", new Producto());
		return "producto-add-update";
	}
	
	@PostMapping("/home")
	public String createProducto
			(@ModelAttribute("producto") Producto productoDto) {
		productoService.createOrUpdateProduct(productoDto);
		return "redirect:/producto/list";
	}
	
	@GetMapping("/list")
	public String listOfProducto(Model model) {
		List<Producto> productoList = productoService.getAllProducts();
		model.addAttribute("productoList", productoList);
		return "producto-list";
	}
	
	@PostMapping("/delete")
	public String deleteProducto(@RequestParam("id") String id) {
		productoService.deleteProduct(id);
		return "redirect:/producto/list";
	}
	
	@GetMapping("/edit")
	public String editProducto(
			@RequestParam("id") String id, Map<String, Object> model) {
		Producto producto = productoService
				.editProduct(id);
		model.put("producto", producto);
		return "producto-add-update";
	}
	
}
